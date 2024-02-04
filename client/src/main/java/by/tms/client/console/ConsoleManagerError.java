package by.tms.client.console;

public class ConsoleManagerError {
    ConsoleWriter consoleWriter = new ConsoleWriter();
    ConsoleReader consoleReader = new ConsoleReader();
    public void writeMessageClearScanner (){
        consoleWriter.write("Некоректный ввод, повторите попытку");
        consoleReader.clearScanner();
    }
}
