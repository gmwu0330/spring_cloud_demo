package demo.auth.persistence.repository.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
        return Objects.isNull(locDateTime) ? null : Timestamp.valueOf(locDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return Objects.isNull(sqlTimestamp) ? null : sqlTimestamp.toLocalDateTime();
    }
}
