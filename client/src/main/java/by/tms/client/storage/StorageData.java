package by.tms.client.storage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StorageData {
    @Setter
    private static List<Double> operationsStories;
    private final List<Double> numbers;
    private final List <Character> operations;
    @Setter
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
    public void save(double d) {
        operationsStories.add(d);
    }
}
