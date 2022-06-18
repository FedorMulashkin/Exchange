package com.fedormulashkin.changeusd.fiegnclients;

import com.fedormulashkin.changeusd.entity.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "gif", url = "${address.giphy}?${address.giphy.id}")
public interface GiphyFeignClient {

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    Gif getGif(@RequestParam String q, @RequestParam int offset);
}