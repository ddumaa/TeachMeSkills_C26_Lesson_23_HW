package by.tms.client.console;

import by.tms.client.storage.StorageData;

public class ConsoleLauncherStart {
    ConsoleReceptionOperation consoleApplication = new ConsoleReceptionOperation();
    ConsoleReader consoleReader = new ConsoleReader();
    ConsoleWriter consoleWriter = new ConsoleWriter();
    HistoryOutput historyOutput = new HistoryOutput();

    public void launcherStart(StorageData storageData) {
        while (true) {
            consoleWriter.write("""
                    Выберите операцию:
                    1: Произвести расчёт.
                    2: Посмотреть историю результатов предыдущих расчётов.
                    3: Завершить работу.""");
            int op = (int) consoleReader.readNum();
            String work = "Y";
            if (op == 1) {
                while (!work.equals("N")) {
                    if (work.equals("Y")) {
                        consoleApplication.run(storageData);
                    } else {
                        consoleWriter.write("Ошибка ввода");
                    }
                    consoleWriter.write("Хотите продолжить? Да - 'Y', Нет - 'N'");
                    work = consoleReader.readOperationType().toUpperCase();
                }
            } else if (op == 2) {
                historyOutput.run(storageData);
            } else if (op == 3) {
                break;
            } else {
                consoleWriter.write("Ошибка ввода");
            }
        }
    }
}
