package com.example.gateway.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api/v1/rating")
public class RatingGatewayController {

//    @Value("${services.ports.rating}")
//    private String ratingPort;

    public static final String ratingUrl = "http://rating:8050/api/v1/rating";

    @GetMapping
    public ResponseEntity<Integer> getUserRating(@RequestHeader("X-User-Name") String username) {
        RestTemplate restTemplate = new RestTemplate();
        String url = ratingUrl + "?username=" + username;
        Integer result = restTemplate.getForObject(ratingUrl, Integer.class);
        return ResponseEntity.ok(result);
    }

}
