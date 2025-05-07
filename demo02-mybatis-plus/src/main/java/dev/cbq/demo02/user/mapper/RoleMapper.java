package dev.cbq.demo02.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dev.cbq.demo02.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

	Optional<Role> findRoleByUserId(@Param("userId") Long userId);
	void insertRoleByUserId(@Param("userId") Long userId,@Param("roleId") Long roleId);

}
