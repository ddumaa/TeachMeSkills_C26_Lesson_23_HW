package by.tms.client.web;

import by.tms.client.console.ConsoleWriter;
import by.tms.client.storage.StorageData;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;

public class ClientApplicationCalculate {
    public void clientAppCalculate(StorageData storageData, ConsoleWriter consoleWriter) {
        Gson gson = new Gson();
        String json = gson.toJson(storageData);

        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/calculate"))
                    .headers("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        StorageData result = gson.fromJson(response.body(), StorageData.class);
        result.save(result.getResult());
        consoleWriter.write(String.valueOf(result.getResult()));
        storageData.getNumbers().clear();
        storageData.getOperations().clear();
    }
}
