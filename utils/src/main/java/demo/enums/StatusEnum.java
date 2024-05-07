package demo.enums;

import demo.enums.base.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum implements IEnum {
    ENABLED(0, "啟用"),
    DISABLED(1, "停用");
    private final Integer value;
    private final String label;

    @Override
    public String getValue() {
        return this.value.toString();
    }
}
