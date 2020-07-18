package com.angelolagreca.andromeda081backend.services.collector;

import com.angelolagreca.andromeda081backend.exception.Andromeda081Exception;
import com.angelolagreca.andromeda081backend.model.entities.Planet;
import com.angelolagreca.andromeda081backend.services.client.le_systeme_solaire.LeSystemeSolaireRestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

import static java.lang.String.format;

@AllArgsConstructor
@Component
public class PlanetCollector {

    private static final String URL_PLANET = "https://api.le-systeme-solaire.net/rest/bodies/%s";

    private final ObjectMapper mapper;

    @Autowired
    LeSystemeSolaireRestClient leSystemeSolaireRestClient;

    public Planet collect(String franceNamePlanet) throws JsonProcessingException, Andromeda081Exception {
        final String formattedUrl = format(URL_PLANET, franceNamePlanet);
        final HttpResponse<String> response = leSystemeSolaireRestClient.get(formattedUrl);
        final String jsonResponse = response.body();
        return mapper.readValue(jsonResponse, Planet.class);
    }

}
