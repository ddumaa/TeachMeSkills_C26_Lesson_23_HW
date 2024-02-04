package by.tms.server.web;

import by.tms.server.service.OperationService;
import by.tms.server.storage.StorageData;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class CalculatorHttpHandler implements HttpHandler {
    private final OperationService service = new OperationService();
    private final Gson gson = new Gson();

    public void handle(HttpExchange exchange) throws IOException {
//TODO доработать метод
        InputStream requestBody = exchange.getRequestBody();
        byte[] bytes = requestBody.readAllBytes();

        StringBuilder s = new StringBuilder();

        for (byte aByte : bytes) {
            char aByte1 = (char) aByte;
            s.append(aByte1);
        }

        StorageData storageData = gson.fromJson(s.toString(), StorageData.class);
        StorageData calculate = service.calculate(storageData);
        String json = gson.toJson(calculate);

        exchange.sendResponseHeaders(200, json.length());
        exchange.getResponseHeaders().add("Content-Type", "application/json");

        PrintWriter printWriter = new PrintWriter(exchange.getResponseBody());
        printWriter.print(json);
        printWriter.flush();
    }
}
