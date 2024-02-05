package by.tms.server.web;

import by.tms.server.storage.StorageData;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerApplication {
    public static void main(String[] args) {
        StorageData storageData = new StorageData();
        CalculatorHttpHandler calculatorHttpHandler = new CalculatorHttpHandler(storageData);
        HistoryHttpHandler historyHttpHandler = new HistoryHttpHandler(storageData);
        try {
            HttpServer httpServer
                    = HttpServer.create(new InetSocketAddress("localhost", 8080), 1);
            httpServer.createContext("/calculate", calculatorHttpHandler);
            httpServer.createContext("/history", historyHttpHandler);
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
