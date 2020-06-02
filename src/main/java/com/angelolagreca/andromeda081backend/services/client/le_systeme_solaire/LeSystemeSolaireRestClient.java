package com.angelolagreca.andromeda081backend.services.client.le_systeme_solaire;

import com.angelolagreca.andromeda081backend.exception.Andromeda081Exception;
import com.angelolagreca.andromeda081backend.services.client.Gettable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static com.angelolagreca.andromeda081backend.services.client.HttpStatus.HTTP_CODE_OK;
import static com.angelolagreca.andromeda081backend.services.client.HttpStatus.HTTP_PAGE_NOT_FOUND;
import static java.net.http.HttpClient.Version.HTTP_2;

@Component
public class LeSystemeSolaireRestClient implements Gettable {

    private final Duration timeoutInSeconds = Duration.ofSeconds(5L);
    private final HttpClient client = HttpClient.newHttpClient();

    @Override
    public HttpResponse<String> get(final String uri) throws Andromeda081Exception {
        final HttpResponse<String> response;
        HttpRequest request = HttpRequest.newBuilder().version(HTTP_2).timeout(timeoutInSeconds).uri(URI.create(uri))
                .build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (final InterruptedException | IOException exception) {
            throw new Andromeda081Exception();
        }
        client.connectTimeout();
        final boolean somethingBadHappened = HTTP_CODE_OK.getCode() != response.statusCode();
        if (somethingBadHappened) {
            if (HTTP_PAGE_NOT_FOUND.getCode() == response.statusCode())
                throw new Andromeda081Exception();//todo create specific exception page not found
            else
                throw new Andromeda081Exception();
        }
        return response;
    }
}


