package common;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Column;
import data.TestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class CsvUtils {
    private static Collection<TestCase> testCases;

    private static List<Column> getColumns() {
        return List.of(
                new Column(0, "id"),
                new Column(1, "title"),
                new Column(2, "priority"),
                new Column(3, "status"),
                new Column(4, "steps")
        );
    }

    private static Collection<TestCase> readTestCaseFile() {
        try {
            var csvFile = new FileInputStream("src/test/resources/data/testcase.csv");
            var schema = CsvSchema.builder()
                    .addColumns(getColumns())
                    .setSkipFirstDataRow(true)
                    .setNullValue("")
                    .build();
            var mapper = new CsvMapper();
            var reader = mapper
                    .enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE)
                    .enable(CsvParser.Feature.TRIM_SPACES)
                    .readerFor(TestCase.class)
                    .with(schema);
            var mappingIterator = reader.readValues(csvFile);
            return mappingIterator.readAll().stream().map(row -> (TestCase) row).toList();
        } catch (IOException e) {
            throw new RuntimeException("Error reading csv file", e);
        }
    }

    public static synchronized Collection<TestCase> getAllTestCases() {
        return testCases = testCases == null ? readTestCaseFile() : testCases;
    }

    /**
     * @param id id in the csv file
     * @return TestCase object that's mapped from the row with the given id
     */
    public static TestCase getById(int id) {
        return getAllTestCases().stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No data found for id: " + id));
    }
}
