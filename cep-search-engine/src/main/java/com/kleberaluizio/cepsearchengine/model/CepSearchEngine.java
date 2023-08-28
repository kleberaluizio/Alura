package com.kleberaluizio.cepsearchengine.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepSearchEngine {

    public CepSearchEngine() {
    }

    public Address createAddressFromJson(String cep){

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), Address.class);
        }catch (Exception e){
            throw new RuntimeException("Não foi possível obter o endereço associado ao CEP fornecido!");
        }
    }
}
