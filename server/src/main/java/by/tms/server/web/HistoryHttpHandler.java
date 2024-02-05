package by.tms.server.web;

import by.tms.server.storage.StorageData;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class HistoryHttpHandler implements HttpHandler {
    private final Gson gson = new Gson();
    private final StorageData storageData;

    public HistoryHttpHandler(StorageData storageData) {
        this.storageData = storageData;
    }
    @Override
    public void handle(HttpExchange exchange){

        String jsonResponse = gson.toJson(storageData);

        try {
            exchange.sendResponseHeaders(200, jsonResponse.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        exchange.getResponseHeaders().add("Content-Type", "application/json");

        try (PrintWriter printWriter = new PrintWriter(exchange.getResponseBody())) {
            printWriter.print(jsonResponse);
            printWriter.flush();
        } finally {
            try {
                exchange.getResponseBody().close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
