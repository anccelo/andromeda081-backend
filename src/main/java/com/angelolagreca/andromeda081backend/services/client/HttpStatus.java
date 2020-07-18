package com.angelolagreca.andromeda081backend.services.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * I leave this class enum only as an example because I actually use the class provided by spring
 */
@AllArgsConstructor
public enum HttpStatus {

    HTTP_CODE_OK(200),
    HTTP_PAGE_NOT_FOUND(404);

    @Getter
    private final int code;

}
