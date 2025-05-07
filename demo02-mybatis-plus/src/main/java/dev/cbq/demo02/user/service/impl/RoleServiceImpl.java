package dev.cbq.demo02.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dev.cbq.demo02.entity.Role;
import dev.cbq.demo02.exception.BusinessException;
import dev.cbq.demo02.user.mapper.RoleMapper;
import dev.cbq.demo02.user.model.ERole;
import dev.cbq.demo02.user.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

	private final RoleMapper roleMapper;

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void addGeneralRoleByUserId(Long userId) {
		Role role = this.getOneOpt(new LambdaQueryWrapper<Role>().eq(Role::getCode, ERole.GENERAL)).orElseThrow(
			() -> new BusinessException(String.format("role not found with %s", ERole.GENERAL))
		);
		roleMapper.insertRoleByUserId(userId, role.getId());
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void addAdminRoleByUserId(Long userId) {
		Role role = this.getOneOpt(new LambdaQueryWrapper<Role>().eq(Role::getCode, ERole.ADMIN)).orElseThrow(
			() -> new BusinessException(String.format("role not found with %s", ERole.ADMIN))
		);
		roleMapper.insertRoleByUserId(userId, role.getId());
	}

}
