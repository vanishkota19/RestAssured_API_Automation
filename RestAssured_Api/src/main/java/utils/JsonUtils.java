package utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static String readJson(String filePath) {
        try {
            return new String(
                Files.readAllBytes(Paths.get(filePath))
            );
        } catch (Exception e) {
            throw new RuntimeException("Unable to read json file");
        }
    }
    
    // ✅ NEW: Read JSON array for data-driven testing
    public static List<Map<String, Object>> readJsonArray(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = readJson(filePath);
            return mapper.readValue(
                    json,
                    new TypeReference<List<Map<String, Object>>>() {}
            );
        } catch (Exception e) {
            throw new RuntimeException("Unable to parse JSON array: " + filePath);
        }
    }
}
