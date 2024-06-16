package demo.auth.model.admin.user.converter;

import demo.auth.model.admin.user.api.response.UserResp;
import demo.auth.persistence.repository.entity.AuthUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T10:06:18+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserResp toResp(AuthUser entity) {
        if ( entity == null ) {
            return null;
        }

        UserResp userResp = new UserResp();

        userResp.setUsername( entity.getUsername() );

        return userResp;
    }
}
