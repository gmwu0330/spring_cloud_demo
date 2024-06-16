package demo.auth.persistence.repository.converter.enums;

import demo.enums.StatusEnum;
import jakarta.persistence.Converter;

@Converter
public class StatusEnumConverter extends AbstractConverter<StatusEnum, Integer> {
    public StatusEnumConverter() {
        super(StatusEnum.class);
    }
}
