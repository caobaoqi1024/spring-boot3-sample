package dev.cbq.demo04.comments.service;

import dev.cbq.demo04.comments.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
	Comment save(Comment comment);

	Comment update(Comment comment);

	void deleteById(Long id);

	Comment getById(Long id);

	List<Comment> getListByBookId(String bookId);

	Page<Comment> getListByBookIdPaged(String bookId, Pageable pageable);

}
