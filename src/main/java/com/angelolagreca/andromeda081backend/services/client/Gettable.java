package com.angelolagreca.andromeda081backend.services.client;

import com.angelolagreca.andromeda081backend.exception.Andromeda081Exception;

import java.net.http.HttpResponse;

@FunctionalInterface
public interface Gettable<R> {
    HttpResponse<String> get(final String uri) throws Andromeda081Exception;
}
