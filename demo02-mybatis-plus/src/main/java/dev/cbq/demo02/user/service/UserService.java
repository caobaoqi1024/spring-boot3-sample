package dev.cbq.demo02.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import dev.cbq.demo02.entity.User;

public interface UserService extends IService<User> {
	User findUserWithRoleByUserId(String email);
	User isUserExists(String username);
}
