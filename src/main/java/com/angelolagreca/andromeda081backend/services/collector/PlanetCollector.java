package com.angelolagreca.andromeda081backend.services.collector;

import com.angelolagreca.andromeda081backend.model.entities.Planet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.lang.String.format;

@AllArgsConstructor
@Component
public class PlanetCollector {

    private static final String URL_PLANET = "https://api.le-systeme-solaire.net/rest/bodies/%s?data=englishName," +
            "perihelion,aphelion,equaRadius";
    private final ObjectMapper mapper;

    public Planet collect(String franceNamePlanet) throws JsonProcessingException {
        return mapper.readValue(LeSolarSystemHttpClientGet(franceNamePlanet), Planet.class);
    }

    //the client (to send into a particulary class)
    public String LeSolarSystemHttpClientGet(String franceNamePlanet) {
        final String formattedUrl = format(URL_PLANET, franceNamePlanet);

        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(formattedUrl)).build();
        String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).
                join();
        System.out.println("the answer is :" + response);
        client.connectTimeout();
        return response;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        PlanetCollector planetCollector = new PlanetCollector(mapper);
        Planet venus = planetCollector.collect("venus");
        Planet earth = planetCollector.collect("terre");

        System.out.println(venus);
        System.out.println(earth);
    }
}
