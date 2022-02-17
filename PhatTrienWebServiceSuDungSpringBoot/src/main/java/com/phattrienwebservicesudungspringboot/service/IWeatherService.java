package com.phattrienwebservicesudungspringboot.service;

import com.phattrienwebservicesudungspringboot.model.Weather;

public interface IWeatherService extends IGeneralService<Weather> {
    Weather findByLocation(String location);
}
