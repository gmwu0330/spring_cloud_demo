package demo.auth.persistence.repository.converter.enums;

import demo.enums.base.IEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public abstract class AbstractConverter<T extends Enum<T> & IEnum<E>, E> implements
        AttributeConverter<T, E> {
    private final Class<T> clazz;

    public AbstractConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public E convertToDatabaseColumn(T attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public T convertToEntityAttribute(E dbData) {
        T[] enums = clazz.getEnumConstants();
        for (T e : enums) {
            if (e.getValue().equals(dbData)) {
                return e;
            }
        }
        return null;
    }
}