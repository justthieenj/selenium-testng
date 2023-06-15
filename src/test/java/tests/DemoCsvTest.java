package tests;

import common.CsvUtils;
import org.testng.annotations.Test;

public class DemoCsvTest {
    @Test
    public void testReadTestCaseFile() {
        System.out.println("get data from csv file");
        CsvUtils.getAllTestCases().forEach(System.out::println);

        System.out.println("get test case by id");
        var testCase = CsvUtils.getById(1);
        System.out.println(testCase);

        System.out.println("print steps of test case 2");
        CsvUtils.getById(2).getSteps().forEach(System.out::println);
    }
}
