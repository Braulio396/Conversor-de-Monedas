package com.aluracursos.conversor.principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {

    private static final String API_KEY = "7ed352f5571b4f2630e47ad6";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double obtenerTasaConversion(String monedaOrigen, String monedaDestino) {
        String urlStr = BASE_URL + monedaOrigen;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlStr))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().create();
            ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);
            return apiResponse.conversion_rates.get(monedaDestino);
        } catch (NullPointerException | IOException | InterruptedException e) {
            e.printStackTrace();
            return -1; //
        }
    }

    private class ApiResponse {
        public String base_code;
        public java.util.Map<String, Double> conversion_rates;
    }
}
