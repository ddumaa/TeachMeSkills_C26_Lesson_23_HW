package by.tms.server.web;

import by.tms.server.storage.StorageData;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HistoryHttpHandler implements HttpHandler {
    private final Gson gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String requestBody = sb.toString();

            StorageData storageData = gson.fromJson(requestBody, StorageData.class);
            String jsonResponse = gson.toJson(storageData);

            exchange.sendResponseHeaders(200, jsonResponse.length());
            exchange.getResponseHeaders().add("Content-Type", "application/json");

            try (PrintWriter printWriter = new PrintWriter(exchange.getResponseBody())) {
                printWriter.print(jsonResponse);
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            exchange.getResponseBody().close();
        }
    }
}
