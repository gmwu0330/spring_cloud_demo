package demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsType implements IEnum{

    WEAPON("WEAPON", "武器"),
    DEFAULT("DEFAULT", "未分類")
    ;
    private final String code;
    private final String label;

    @Override
    public String getValue() {
        return code;
    }

}
