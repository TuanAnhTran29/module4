package com.phattrienwebservicesudungspringboot.controller;

import com.phattrienwebservicesudungspringboot.model.Weather;
import com.phattrienwebservicesudungspringboot.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/weather/{username}/{password}/{location}")
    public ResponseEntity<Weather> weatherOfLocation(@PathVariable String username, @PathVariable String password, @PathVariable String location){
        if (username.equals("tuananh") && password.equals("12345")){
            Weather weather= weatherService.findByLocation(location);
            if (weather != null){
                return new ResponseEntity<>(weather, HttpStatus.FOUND);
            }else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
