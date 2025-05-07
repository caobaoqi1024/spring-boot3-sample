package dev.cbq.demo02.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import dev.cbq.demo02.entity.Role;

public interface RoleService extends IService<Role> {

	void addGeneralRoleByUserId(Long userId);

	void addAdminRoleByUserId(Long userId);

}
