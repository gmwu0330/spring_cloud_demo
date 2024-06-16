package demo.enums;

import demo.enums.base.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public enum StatusEnum implements IEnum<Integer> {
    N(0, "否"),
    Y(1, "是"),
    ;
    private final Integer code;
    private final String label;

    @Override
    public Integer getValue() {
        return this.code;
    }

    public boolean getBoolean() {
        return Objects.equals(this.getCode(), 1);
    }

}
