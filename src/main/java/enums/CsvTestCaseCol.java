package enums;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Column;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CsvTestCaseCol {
    id, title, priority, status, steps;

    public static List<Column> getColumns() {
        var stringList = Arrays.stream(values()).map(Enum::name).toList();
        var columns = new ArrayList<CsvSchema.Column>();
        for (int i = 0; i < stringList.size(); i++) {
            columns.add(new CsvSchema.Column(i, stringList.get(i)));
        }
        return columns;
    }
}
