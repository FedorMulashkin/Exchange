package com.fedormulashkin.changeusd.controller;

import com.fedormulashkin.changeusd.entity.Exchange;
import com.fedormulashkin.changeusd.fiegnclients.OpenExchangeRatesFeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.Random;


@RestController
public class ExchangeController {
    private final OpenExchangeRatesFeignClient openExchangeRatesFeignClient;
    private final LocalDate today = LocalDate.now();
    private final LocalDate yesterday = LocalDate.now().minusDays(1);


    public ExchangeController(OpenExchangeRatesFeignClient openExchangeRatesFeignClient) {
        this.openExchangeRatesFeignClient = openExchangeRatesFeignClient;
    }

    @GetMapping("/exchange/")
    @ResponseBody
    public ResponseEntity<Void> getExchange(@RequestParam String name) {
        Exchange exchangeToday = openExchangeRatesFeignClient.getExchange(name, today.toString());
        Exchange exchangeYesterday = openExchangeRatesFeignClient.getExchange(name, yesterday.toString());
        String result = Double.doubleToLongBits(exchangeToday.getRates().get(name) - exchangeYesterday.getRates().get(name)) > 0 ? "rich" : "broke";
        int offset = new Random().nextInt(0, 50);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:3333/gif/?q=" + result + "&offset=" + offset)).build();
    }
}