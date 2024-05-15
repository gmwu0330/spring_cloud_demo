package demo.admin.model.user.converter;

import demo.admin.model.user.api.response.UserResp;
import demo.admin.repository.entity.AuthUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserResp toResp(AuthUser entity);

}
