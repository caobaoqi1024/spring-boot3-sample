package dev.cbq.demo02.user.service.impl;

import dev.cbq.demo02.user.domain.request.SignInVo;
import dev.cbq.demo02.user.domain.request.SignUpVo;
import dev.cbq.demo02.entity.User;
import dev.cbq.demo02.exception.BusinessException;
import dev.cbq.demo02.user.service.RoleService;
import dev.cbq.demo02.user.service.SignService;
import dev.cbq.demo02.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class SignServiceImpl implements SignService {

	private final UserService userService;
	private final RoleService roleService;


	@Override
	public String signIn(SignInVo vo) {
		User user = Optional.ofNullable(userService.isUserExists(vo.email())).orElseThrow(
			() -> new BusinessException(String.format("user not found with %s", vo.email()))
		);
		if (!vo.password().equals(user.getPassword())) {
			throw new BusinessException("password invalid");
		}
		return user.getEmail();
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void signUp(SignUpVo vo) {
		if (ObjectUtils.isNotEmpty(userService.isUserExists(vo.username()))) {
			throw new BusinessException(String.format("username %s already exists", vo.username()));
		}
		User user = new User();
		user.setUsername(vo.username());
		user.setEmail(vo.email());
		user.setPassword(vo.password());
		boolean save = userService.save(user);
		if (!save) {
			throw new BusinessException("save user failure");
		}
		roleService.addGeneralRoleByUserId(userService.isUserExists(vo.username()).getId());
	}

}
