package backBook.demo.DTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringArrayConverter implements AttributeConverter<String[], String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);  // 배열을 JSON 문자열로 변환
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting array to JSON", e);
        }
    }

    @Override
    public String[] convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, String[].class);  // JSON 문자열을 배열로 변환
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting JSON to array", e);
        }
    }
}
