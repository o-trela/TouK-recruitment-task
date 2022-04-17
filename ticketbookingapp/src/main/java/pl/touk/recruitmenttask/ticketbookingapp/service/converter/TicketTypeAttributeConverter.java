package pl.touk.recruitmenttask.ticketbookingapp.service.converter;

import pl.touk.recruitmenttask.ticketbookingapp.model.TicketType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TicketTypeAttributeConverter implements AttributeConverter<TicketType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TicketType attribute) {
        if (attribute == null)
            return null;

        int finalValue;
        switch (attribute) {
            case adult -> finalValue = 1;
            case student -> finalValue = 2;
            case child -> finalValue = 3;
            default -> throw new IllegalArgumentException(attribute + "not supported.");
        }

        return finalValue;
    }

    @Override
    public TicketType convertToEntityAttribute(Integer dbData) {
        if (dbData == null)
            return null;

        TicketType finalValue;
        switch (dbData) {
            case 1 -> finalValue = TicketType.adult;
            case 2 -> finalValue = TicketType.student;
            case 3 -> finalValue = TicketType.child;
            default -> throw new IllegalArgumentException(dbData + "not supported.");
        }

        return finalValue;
    }
}
