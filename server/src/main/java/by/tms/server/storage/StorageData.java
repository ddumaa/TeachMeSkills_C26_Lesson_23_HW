package by.tms.server.storage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class StorageData {
    private List<Double> operationsStories;
    @Getter
    private List<Double> numbers;
    @Getter
    private List <Character> operations;
    @Setter
    @Getter
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
