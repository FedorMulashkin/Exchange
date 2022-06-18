package com.fedormulashkin.changeusd.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.Errors;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.github.tomakehurst.wiremock.matching.UrlPattern;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.serverError;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.*;

@WireMockTest
class GifControllerTest {

    static WireMockServer wireMockServer = new WireMockServer(wireMockConfig().dynamicPort().dynamicHttpsPort());
    static UrlPattern urlPattern = urlEqualTo("http://localhost:3333/gif/?q=rich&offset=1");

    @BeforeAll
    static void setUp() {
        wireMockServer.start();

        wireMockServer.stubFor(WireMock.get(urlPattern)
                .willReturn(aResponse().withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)));
    }

    @AfterAll
    static void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void wireMockTest() {
        wireMockServer.isRunning();
        assertEquals(wireMockServer.getStubMappings().size(), 1);
    }

    @Test
    void getExchangeCheckInternalServerErrorStatus() {
        wireMockServer.stubFor(WireMock.get(urlPathMatching(String.valueOf(urlPattern))).willReturn(serverError()));
        assertEquals(500, wireMockServer.getStubMappings().get(0).getResponse().getStatus());
    }

    @Test
    void getExchangeCheckOKStatus() {
        wireMockServer.getStubMappings().get(0).setResponse(ResponseDefinition.ok());
        assertEquals(200, wireMockServer.getStubMappings().get(0).getResponse().getStatus());
    }

    @Test
    void getExchangeCheckBadRequestStatus() {
        wireMockServer.getStubMappings().get(0).setResponse(ResponseDefinition.badRequest(Errors.single(400, "Check bad request")));
        assertEquals(400, wireMockServer.getStubMappings().get(0).getResponse().getStatus());
    }

    @Test
    void getExchangeCheckNotFoundStatus() {
        wireMockServer.getStubMappings().get(0).setResponse(ResponseDefinition.notFound());
        assertEquals(404, wireMockServer.getStubMappings().get(0).getResponse().getStatus());
    }

}