package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CsvUtils {

    public static List<Map<String, String>> readCsv(String filePath) {

        List<Map<String, String>> data = new ArrayList<>();

        CSVFormat format = CSVFormat.DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setTrim(true)
                .build();

        try (
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVParser csvParser = new CSVParser(reader, format)
        ) {
            for (CSVRecord record : csvParser) {
                Map<String, String> row = new HashMap<>();

                for (String header : csvParser.getHeaderMap().keySet()) {
                    row.put(header, record.get(header));
                }
                data.add(row);
            }

        } catch (Exception e) {
            throw new RuntimeException("Unable to read CSV file: " + filePath, e);
        }

        return data;
    }
}
