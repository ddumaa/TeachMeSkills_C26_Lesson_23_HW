package by.tms.client.console;

import by.tms.client.storage.StorageData;
import by.tms.client.web.ClientApplicationHistory;

public class HistoryOutput {
    ClientApplicationHistory clientApplicationHistory = new ClientApplicationHistory();
    ConsoleWriter consoleWriter = new ConsoleWriter();
    public void run(StorageData storageData){
        clientApplicationHistory.clientAppHistory(storageData, consoleWriter);
    }
}
