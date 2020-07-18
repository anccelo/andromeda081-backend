package com.angelolagreca.andromeda081backend.controllers;

import com.angelolagreca.andromeda081backend.exception.Andromeda081Exception;
import com.angelolagreca.andromeda081backend.exception.GenericException;
import com.angelolagreca.andromeda081backend.model.CelestialObject;
import com.angelolagreca.andromeda081backend.model.entities.Planet;
import com.angelolagreca.andromeda081backend.services.PlanetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlanetCtrlTest {

    private static final Long NOT_EXISTING_ID = 99L;

    private PlanetCtrl planetCtrl;

    @Mock
    private PlanetService planetServiceMock;
    @Mock
    private Planet earthMock;
    @Mock
    private Planet jupiterMock;

    List<Planet> planetsForTest = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        this.planetCtrl = new PlanetCtrl(planetServiceMock);
        planetsForTest.add(earthMock);
        planetsForTest.add(jupiterMock);

    }

    @Test
    void should_return_a_list_of_planets_when_all_the_planets_are_asked() {
        //AAA arrang
        when(planetServiceMock.getPlanetsService()).thenReturn(planetsForTest);
        // act
        List<Planet> actual = planetCtrl.getPlanetsController();
        // assert
        assertThat(actual).isEqualTo(planetsForTest);
    }

    @Test
    void should_return_null_when_an_inexisting_plent_id_is_asked() throws Andromeda081Exception {

        when(planetServiceMock.getPlanetService(NOT_EXISTING_ID)).thenReturn(null);

        Optional<CelestialObject> actual = planetCtrl.getPlanetController(NOT_EXISTING_ID);

        assertThat(actual).isNull();

    }

    @Test
    void should_throw_a_GenericException_when_an_inexisting_plent_id_is_asked() throws Andromeda081Exception {
        //arrange
        when(planetServiceMock.getPlanetService(NOT_EXISTING_ID)).thenReturn(null);
        // act and assert
        assertThatThrownBy(() -> {
            planetCtrl.getPlanetController(NOT_EXISTING_ID);
        }).isInstanceOf(GenericException.class);

    }

}
