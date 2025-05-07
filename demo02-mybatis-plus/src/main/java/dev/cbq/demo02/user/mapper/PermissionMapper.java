package dev.cbq.demo02.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dev.cbq.demo02.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
