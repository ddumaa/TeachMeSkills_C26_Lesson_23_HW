package by.tms.client.console;

import by.tms.client.web.ClientApplicationCalculate;
import by.tms.client.storage.StorageData;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class ConsoleReceptionOperation {

    private final ConsoleManagerError consoleManagerError = new ConsoleManagerError();
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final ConsoleWriter consoleWriter = new ConsoleWriter();
    ClientApplicationCalculate clientApplication = new ClientApplicationCalculate();
    int count = 1;
    public void run(StorageData storageData){
        while (true) {
            try {
                if (count % 2 != 0) {
                    consoleWriter.write("Введите число");
                    double num = consoleReader.readNum();
                    storageData.addNumbers(num);
                    count++;
                }
                if (count % 2 == 0) {
                    consoleWriter.write("Введите знак операции: '+,-,*,/' для вывода результата нажмите '='");
                    String str = consoleReader.readOperationType();
                    if (Pattern.matches(".*[\\+\\-\\*\\/\\=].*", str)) {
                        char op = str.charAt(0);
                        if (op == '=') {
                            break;
                        } else {
                            storageData.addOperations(op);
                            count++;
                        }
                    } else {
                        consoleManagerError.writeMessageClearScanner();
                    }
                }
            } catch (InputMismatchException e) {
                consoleManagerError.writeMessageClearScanner();
            }
        }
        count = 1;
        clientApplication.clientAppCalculate(storageData, consoleWriter);
    }
}
