package com.phattrienwebservicesudungspringboot.service;

import com.phattrienwebservicesudungspringboot.model.Weather;
import com.phattrienwebservicesudungspringboot.repo.IWeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService implements IWeatherService{
    @Autowired
    private IWeatherRepo weatherRepo;
    @Override
    public Iterable<Weather> findAll() {
        return weatherRepo.findAll();
    }

    @Override
    public Optional<Weather> findById(Long id) {
        return weatherRepo.findById(id);
    }

    @Override
    public void save(Weather weather) {
        weatherRepo.save(weather);
    }

    @Override
    public void remove(Long id) {
        weatherRepo.deleteById(id);
    }

    @Override
    public Weather findByLocation(String location) {
        return weatherRepo.findByLocation(location);
    }
}
