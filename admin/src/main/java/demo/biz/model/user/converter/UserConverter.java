package demo.biz.model.user.converter;

import demo.biz.model.user.api.response.UserResp;
import demo.biz.persistence.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserResp toResp(User entity);

}
