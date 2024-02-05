package by.tms.client;

import by.tms.client.console.ConsoleLauncherStart;
import by.tms.client.storage.StorageData;

public class Main {
    public static void main(String[] args) {
        StorageData storageData = new StorageData();
        ConsoleLauncherStart consoleLauncherStart = new ConsoleLauncherStart();
        consoleLauncherStart.launcherStart(storageData);
    }
}
