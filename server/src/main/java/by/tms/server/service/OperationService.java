package by.tms.server.service;

import by.tms.server.storage.StorageData;

public class OperationService {
    private final Message message = new Message();
    public StorageData calculate(StorageData storageData) {
        double result = 0;
        boolean divisionByZero = false;
        if (!storageData.getNumbers().isEmpty()) {
            result = storageData.getNumbers().get(0);
            for (int i = 1; i < storageData.getNumbers().size(); i++) {
                char op = storageData.getOperations().get(i - 1);
                double nextNum = storageData.getNumbers().get(i);
                switch (op) {
                    case '+':
                        result += nextNum;
                        break;
                    case '-':
                        result -= nextNum;
                        break;
                    case '*':
                        result *= nextNum;
                        break;
                    case '/':
                        if (nextNum != 0) {
                            result /= nextNum;
                        } else {
                            message.setMessage("Попытка деления на ноль");
                            divisionByZero = true;
                        }
                        break;
                    default:
                        message.setMessage("Неподдерживаемая операция");
                }
                if (divisionByZero) {
                    message.setMessage("На ноль делить нельзя");
                }
            }
        } else {
            message.setMessage("Список пуст");
        }
        storageData.setResult(result);
        storageData.save(result);
        storageData.getNumbers().clear();
        storageData.getOperations().clear();
        return storageData;
    }
}
