package demo.model.user.converter;

import demo.model.user.api.response.UserResp;
import demo.repository.entity.AuthUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserResp toResp(AuthUser entity);

}
