package com.fedormulashkin.changeusd.fiegnclients;

import com.fedormulashkin.changeusd.entity.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "exchange", url = "${address.exchange}")
public interface OpenExchangeRatesFeignClient {

    @GetMapping(value = "/{dateParam}.json?${address.exchange.id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Exchange getExchange(@RequestParam String name, @PathVariable String dateParam);
}