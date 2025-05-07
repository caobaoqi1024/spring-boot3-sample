package dev.cbq.demo04.comments.service;

import dev.cbq.demo04.comments.entity.Comment;
import dev.cbq.demo04.comments.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository repository;

	@Override
	public Comment save(Comment comment) {
		return repository.save(comment);
	}

	@Override
	public Comment update(Comment comment) {
		comment.setUpdateTime(java.time.LocalDateTime.now());
		return repository.save(comment);
	}

	@Override
	public void deleteById(Long id) {
		Comment comment = repository.findById(id).orElse(null);
		if (comment != null && Boolean.TRUE.equals(comment.getEnable())) {
			comment.setEnable(false);
			comment.setUpdateTime(java.time.LocalDateTime.now());
			repository.save(comment);
		}
	}

	@Override
	public Comment getById(Long id) {
		Optional<Comment> optional = repository.findById(id);
		return optional.orElse(null);
	}

	@Override
	public List<Comment> getListByBookId(String bookId) {
		return repository.findByBookIdAndEnableTrueOrderByCreateTimeDesc(bookId);
	}

	@Override
	public Page<Comment> getListByBookIdPaged(String bookId, Pageable pageable) {
		return repository.findAll(
			org.springframework.data.domain.Example.of(
				Comment.builder().bookId(bookId).enable(true).build()
			),
			pageable
		);
	}
}
