package com.angelolagreca.andromeda081backend.services.client.le_systeme_solaire;

import com.angelolagreca.andromeda081backend.exception.Andromeda081Exception;
import com.angelolagreca.andromeda081backend.exception.ApiException;
import com.angelolagreca.andromeda081backend.exception.GenericException;
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

    private static final String PAGE_NOT_FOUND_MESSAGE = "received a 404 code in response, page not found.";
    private static final String OTHER_PROBLEM = "other problem";//todo refactoring exceptions

    private final Duration timeoutInSeconds = Duration.ofSeconds(5L);
    private final HttpClient client = HttpClient.newHttpClient();

    @Override
    public HttpResponse<String> get(final String uri) throws Andromeda081Exception, IllegalArgumentException {

        final HttpResponse<String> response;

        try {
            HttpRequest request = HttpRequest.newBuilder().version(HTTP_2).timeout(timeoutInSeconds).
                    uri(URI.create(uri)).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (final InterruptedException | IOException exception) {
            throw new GenericException(OTHER_PROBLEM, exception.getCause().fillInStackTrace());
        }
        client.connectTimeout();
        final boolean somethingBadHappened = HTTP_CODE_OK.getCode() != response.statusCode();
        if (somethingBadHappened) {
            if (HTTP_PAGE_NOT_FOUND.getCode() == response.statusCode()) {
                throw new ApiException(PAGE_NOT_FOUND_MESSAGE);
            } else
                throw new GenericException(OTHER_PROBLEM); // todo more specific message
        }
        return response;
    }

}


