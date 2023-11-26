package cl.ucn.modelo;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.joda.time.DateTime;

@Converter(autoApply = true)
public class DateTimeConverter implements AttributeConverter<DateTime, java.sql.Timestamp> {

    @Override
    public java.sql.Timestamp convertToDatabaseColumn(DateTime attribute) {
        return (attribute != null) ? new java.sql.Timestamp(attribute.getMillis()) : null;
    }

    @Override
    public DateTime convertToEntityAttribute(java.sql.Timestamp dbData) {
        return (dbData != null) ? new DateTime(dbData.getTime()) : null;
    }
}
