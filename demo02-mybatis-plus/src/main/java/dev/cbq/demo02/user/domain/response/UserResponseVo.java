package dev.cbq.demo02.user.domain.response;

import dev.cbq.demo02.entity.Role;

import java.time.LocalDateTime;

public record UserResponseVo(
	String username,
	String email,
	LocalDateTime createTime,
	LocalDateTime updateTime,
	Role role
) {
}
