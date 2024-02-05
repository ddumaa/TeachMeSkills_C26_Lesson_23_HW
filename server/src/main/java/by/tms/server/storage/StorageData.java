package by.tms.server.storage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StorageData {
    private final List<Double> operationsStories;
    private final List<Double> numbers;
    private final List <Character> operations;
    @Setter
    private double result;
    public StorageData(){
        numbers = new ArrayList<>();
        operations = new ArrayList<>();
        operationsStories = new ArrayList<>();
    }
    public void save(Double d) {
        operationsStories.add(d);
    }
}
