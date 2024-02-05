package by.tms.server.web;

import by.tms.server.service.OperationService;
import by.tms.server.storage.StorageData;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CalculatorHttpHandler implements HttpHandler {
    private final OperationService service = new OperationService();
    private final Gson gson = new Gson();
    private StorageData storageData;

    public CalculatorHttpHandler(StorageData storageData) {
        this.storageData = storageData;
    }

    public void handle(HttpExchange exchange) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String requestBody = sb.toString();

            storageData = gson.fromJson(requestBody, StorageData.class);
            StorageData calculate = service.calculate(storageData);
            String json = gson.toJson(calculate);

            exchange.sendResponseHeaders(200, json.length());
            exchange.getResponseHeaders().add("Content-Type", "application/json");

            PrintWriter printWriter = new PrintWriter(exchange.getResponseBody());
            printWriter.print(json);
            printWriter.flush();
        }
    }
}
