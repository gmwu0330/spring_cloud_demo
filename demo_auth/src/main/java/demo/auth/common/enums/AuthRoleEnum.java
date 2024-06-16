package demo.auth.common.enums;

import demo.enums.base.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthRoleEnum implements IEnum<String> {

    ADMIN("ADMIN", "管理者"),
    MEMBER("MEMBER", "會員")
    ;
    private final String code;
    private final String label;

    @Override
    public String getValue() {
        return code;
    }
}
