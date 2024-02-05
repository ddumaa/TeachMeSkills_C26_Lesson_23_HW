package by.tms.server.web;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerApplication {
    public static void main(String[] args) {
        try {
            HttpServer httpServer
                    = HttpServer.create(new InetSocketAddress("localhost", 8080), 1);
            httpServer.createContext("/calculate", new CalculatorHttpHandler());
            httpServer.createContext("/history", new HistoryHttpHandler());
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
