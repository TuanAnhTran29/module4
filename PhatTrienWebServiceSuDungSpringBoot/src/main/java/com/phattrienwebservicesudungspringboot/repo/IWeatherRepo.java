package com.phattrienwebservicesudungspringboot.repo;

import com.phattrienwebservicesudungspringboot.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeatherRepo extends JpaRepository<Weather,Long> {
    Weather findByLocation(String location);
}
