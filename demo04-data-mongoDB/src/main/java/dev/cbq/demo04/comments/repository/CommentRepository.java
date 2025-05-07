package dev.cbq.demo04.comments.repository;

import dev.cbq.demo04.comments.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Long> {

	List<Comment> findByBookIdAndEnableTrue(String bookId);

	List<Comment> findByBookIdAndEnableTrueOrderByCreateTimeDesc(String bookId);

//	List<Comment> findByParentIdAndEnableTrue(String parentId); // 如果你之后支持嵌套评论

	List<Comment> findByUserIdAndEnableTrue(String userId);

}
