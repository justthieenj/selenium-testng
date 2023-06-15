package data;

import lombok.Data;

import java.util.List;

@Data
public class TestCase {
    private int id;
    private String title;
    private int priority;
    private String status;
    private List<String> steps;
}
