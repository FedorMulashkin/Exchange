package com.fedormulashkin.changeusd.controller;

import com.fedormulashkin.changeusd.entity.Gif;
import com.fedormulashkin.changeusd.fiegnclients.GiphyFeignClient;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
public class GifController {
    private final GiphyFeignClient giphyFeignClient;

    public GifController(GiphyFeignClient giphyFeignClient) {
        this.giphyFeignClient = giphyFeignClient;
    }

    @GetMapping("/gifs/")
    @ResponseBody
    public ResponseEntity<Void> getGif(@RequestParam String q, @RequestParam int offset) {
        Gif gif = giphyFeignClient.getGif(q, offset);
        JSONObject jsonObject = new JSONObject(gif);
        JSONObject jsonObject1 = (JSONObject) jsonObject.getJSONArray("data").get(0);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create((String) jsonObject1.get("embed_url"))).build();
    }
}