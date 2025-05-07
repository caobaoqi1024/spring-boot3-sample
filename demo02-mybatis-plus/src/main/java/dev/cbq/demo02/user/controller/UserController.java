package dev.cbq.demo02.user.controller;

import dev.cbq.common.utils.Result;
import dev.cbq.demo02.entity.User;
import dev.cbq.demo02.user.domain.UserMapStruct;
import dev.cbq.demo02.user.domain.response.UserResponseVo;
import dev.cbq.demo02.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final UserMapStruct userMapStruct;

	@GetMapping
	public Result<List<UserResponseVo>> list() {
		return Result.success(userService.list().stream()
			.map(userMapStruct::toUserResponseVo)
			.toList());
	}

	@GetMapping("/{email}")
	public Result<UserResponseVo> findById(@PathVariable("email") String email) {
		User user = userService.findUserWithRoleByUserId(email);
		if (ObjectUtils.isEmpty(user)) {
			return Result.notFound(String.format("User with email %s not found", email));
		}
		return Result.success(userMapStruct.toUserResponseVo(user));
	}

}
