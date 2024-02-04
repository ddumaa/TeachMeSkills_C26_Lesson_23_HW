package by.tms.server.storage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class StorageData {
    private final List<Double> operationsStories = new ArrayList<>();
    @Getter
    private final List<Double> numbers;
    @Getter
    private final List <Character> operations;
    @Setter
    @Getter
    private double result;
    public StorageData(){
        numbers = new ArrayList<>();
        operations = new ArrayList<>();
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

    public List<Double> findAll() {
        return new ArrayList<>(operationsStories);
    }
}
