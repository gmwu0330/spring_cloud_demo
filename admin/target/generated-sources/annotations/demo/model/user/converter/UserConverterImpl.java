package demo.model.user.converter;

import demo.model.user.api.response.UserResp;
import demo.repository.entity.AuthUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-15T22:36:15+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserResp toResp(AuthUser entity) {
        if ( entity == null ) {
            return null;
        }

        UserResp userResp = new UserResp();

        return userResp;
    }
}
