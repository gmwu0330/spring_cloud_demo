package demo.enums;

import demo.enums.base.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsTypeEnum implements IEnum {
    WEAPON("WEAPON", "武器"),
    DEFAULT("DEFAULT", "未分類");
    private final String code;
    private final String label;

    @Override
    public String getValue() {
        return code;
    }

}
