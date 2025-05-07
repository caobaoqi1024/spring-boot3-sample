package dev.cbq.demo04.comments.controller;

import dev.cbq.demo04.comments.entity.Comment;
import dev.cbq.demo04.comments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService service;

	// 添加评论
	@PostMapping
	public Comment addComment(@RequestBody Comment comment) {
		return service.save(comment);
	}

	// 更新评论
	@PutMapping("/{id}")
	public Comment updateComment(@PathVariable Long id, @RequestBody Comment comment) {
		comment.setId(id); // 确保更新指定 ID 的评论
		return service.update(comment);
	}

	@DeleteMapping("/{id}")
	public void deleteComment(@PathVariable Long id) {
		service.deleteById(id);
	}

	@GetMapping("/{id}")
	public Comment getComment(@PathVariable Long id) {
		return service.getById(id);
	}

	@GetMapping("/book/{bookId}")
	public List<Comment> getCommentsByBook(@PathVariable String bookId) {
		return service.getListByBookId(bookId);
	}

	@GetMapping("/book/{bookId}/page")
	public Page<Comment> getCommentsByBookPaged(
		@PathVariable String bookId,
		@RequestParam(defaultValue = "0") int page,
		@RequestParam(defaultValue = "10") int size
	) {
		return service.getListByBookIdPaged(bookId, PageRequest.of(page, size));
	}
}
