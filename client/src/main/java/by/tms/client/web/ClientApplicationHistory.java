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
import java.util.Arrays;

public class ClientApplicationHistory {
    public void clientAppHistory(StorageData storageData, ConsoleWriter consoleWriter) {
        Gson gson = new Gson();

        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:8080/history"))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        StorageData result = gson.fromJson(response.body(), StorageData.class);
        String s = Arrays.toString(StorageData.getOperationsStories().toArray());
        consoleWriter.write(s);
    }
}
