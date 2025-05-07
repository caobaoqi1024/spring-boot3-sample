package dev.cbq.demo04.comments.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "comments")
@CompoundIndex(def = "{'bookId': 1, 'createTime': -1}")
public class Comment {
	private Long id;
	@Indexed
	private String bookId;
	@Indexed
	private String userId;
	private String userName;
	private String content;
	private int rating;
	private LocalDateTime createTime = LocalDateTime.now();
	private LocalDateTime updateTime = LocalDateTime.now();
	private Boolean enable = Boolean.TRUE;
}
