package demo.auth.model.admin.user.converter;

import demo.auth.model.admin.user.api.response.UserResp;
import demo.auth.persistence.repository.entity.AuthUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserResp toResp(AuthUser entity);

}
