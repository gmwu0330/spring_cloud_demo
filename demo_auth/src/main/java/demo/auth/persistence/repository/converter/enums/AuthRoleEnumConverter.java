package demo.auth.persistence.repository.converter.enums;

import demo.auth.common.enums.AuthRoleEnum;
import jakarta.persistence.Converter;

@Converter
public class AuthRoleEnumConverter extends AbstractConverter<AuthRoleEnum, String> {
    public AuthRoleEnumConverter() {
        super(AuthRoleEnum.class);
    }
}
