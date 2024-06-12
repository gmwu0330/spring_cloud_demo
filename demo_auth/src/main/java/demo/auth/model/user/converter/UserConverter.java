package demo.auth.model.user.converter;

import demo.auth.model.user.api.response.UserResp;
import demo.auth.repository.entity.AuthUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserResp toResp(AuthUser entity);

}
