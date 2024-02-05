package by.tms.client.storage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class StorageData {
    @Getter
    @Setter
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
    public void addNumbers (double number){
        numbers.add(number);
    }
    public void addOperations (char operation){
        operations.add(operation);
    }
    public void save(Double d) {
        operationsStories.add(d);
    }
}
