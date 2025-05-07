package dev.cbq.demo02.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.cbq.demo02.entity.Role;
import dev.cbq.demo02.entity.User;
import dev.cbq.demo02.exception.BusinessException;
import dev.cbq.demo02.user.mapper.RoleMapper;
import dev.cbq.demo02.user.mapper.UserMapper;
import dev.cbq.demo02.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	private final RoleMapper roleMapper;


	@Override
	public User findUserWithRoleByUserId(String email) {
		User user = Optional.ofNullable(this.isUserExists(email)).orElseThrow(() -> new BusinessException(String.format("not found user with username %s", email)));
		Role role = roleMapper.findRoleByUserId(user.getId()).orElseThrow(() -> new BusinessException(String.format("not found role with user %s", user.getId())));
		user.setRole(role);
		return user;
	}

	@Override
	public User isUserExists(String username) {
		return this.getOne(new LambdaQueryWrapper<User>()
			.eq(User::getUsername, username)
			.or()
			.eq(User::getEmail, username)
		);
	}

}
