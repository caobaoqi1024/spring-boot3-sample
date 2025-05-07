package dev.cbq.demo04;

import dev.cbq.demo04.comments.entity.Comment;
import dev.cbq.demo04.comments.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Demo04Application implements ApplicationRunner {

	private final CommentRepository repository;

	public static void main(String[] args) {
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Demo04Application.class, args);
	}

	@EventListener
	public void onApplicationReadyEvent(ApplicationReadyEvent event) {
		log.info("Demo04Application.onApplicationReadyEvent {}", event.getApplicationContext());
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (repository.count() > 0) {
			return; // 已有数据则跳过
		}

		IntStream.rangeClosed(1, 30).forEach(i -> {
			Comment comment = Comment.builder()
				.id((long) i)
				.bookId("book-" + (i % 5 + 1)) // 模拟 5 本书
				.userId("user-" + (i % 10 + 1)) // 模拟 10 个用户
				.userName("用户" + (i % 10 + 1))
				.content("这是第 " + i + " 条评论，内容略略略。")
				.rating((i % 5) + 1)
				.createTime(LocalDateTime.now().minusDays(i))
				.updateTime(LocalDateTime.now())
				.enable(true)
				.build();
			repository.save(comment);
		});

		System.out.println("✅ 成功初始化 30 条评论数据");
	}
}
