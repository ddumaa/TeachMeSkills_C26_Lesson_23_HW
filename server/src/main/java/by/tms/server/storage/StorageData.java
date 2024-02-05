package by.tms.server.storage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StorageData {
    private static final List<Double> operationsStories = new ArrayList<>();
    private final List<Double> numbers;
    private final List <Character> operations;
    @Setter
    private double result;
    public StorageData(){
        numbers = new ArrayList<>();
        operations = new ArrayList<>();
    }
    public void save(double d) {
        operationsStories.add(d);
    }
}
