package dev.cbq.demo02.user.domain;

import dev.cbq.demo02.user.domain.response.UserResponseVo;
import dev.cbq.demo02.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapStruct {

	UserResponseVo toUserResponseVo(User user);

}
