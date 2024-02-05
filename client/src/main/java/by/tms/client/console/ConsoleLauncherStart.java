package by.tms.client.console;

import by.tms.client.storage.StorageData;

public class ConsoleLauncherStart {
    ConsoleReceptionOperation consoleApplication = new ConsoleReceptionOperation();
    ConsoleReader consoleReader = new ConsoleReader();
    ConsoleWriter consoleWriter = new ConsoleWriter();
    ConsoleManagerError consoleManagerError = new ConsoleManagerError();
    HistoryOutput historyOutput = new HistoryOutput();
    StorageData storageData = new StorageData();

    public void launcherStart() {
        while (true) {
            consoleWriter.write("""
                    Выберите операцию:
                    1: Произвести расчёт.
                    2: Посмотреть историю результатов предыдущих расчётов.
                    3: Завершить работу.""");
            int op = (int) consoleReader.readNum();
            String work = "Y";
            if (op == 1) {
                while (true) {
                    if (work.equals("N")) {
                        break;
                    } else if (work.equals("Y")) {
                        consoleApplication.run(storageData);
                        consoleWriter.write("Хотите продолжить? Да - 'Y', Нет - 'N'");
                        work = consoleReader.readOperationType().toUpperCase();
                    } else {
                        consoleManagerError.writeMessageClearScanner();
                    }
                }
            } else if (op == 2) {
                historyOutput.run(storageData);
            } else if (op == 3) {
                break;
            } else {
                consoleManagerError.writeMessageClearScanner();
            }
        }
    }
}
