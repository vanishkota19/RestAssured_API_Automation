package utils;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "userData")
    public static Object[][] userData() {
        return new Object[][]{
                {"Vanish", "QA"},
                {"Anjali", "Developer"},
                {"TestUser", "Manager"}
        };
        
        
    }
    
    @DataProvider(name = "jsonUserData")
    public static Object[][] jsonUserData() {

        List<Map<String, Object>> data =
                JsonUtils.readJsonArray(
                        "src/test/resources/testdata/users.json");
        
        Object[][] result = new Object[data.size()][1];

        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i);
        }

        return result;
    }
    
    
    
    @DataProvider(name = "csvUserData")
    public static Object[][] csvUserData() {

        List<Map<String, String>> data =
                CsvUtils.readCsv(
                        "src/test/resources/testdata/users.csv");

        Object[][] result = new Object[data.size()][1];

        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i);
        }

        return result;
    }

}
