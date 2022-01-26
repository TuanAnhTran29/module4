package com.service;

import com.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ITrackService {
    Iterable<Track> findAll();

    void save(Track track);

    void remove(Long id);

    Optional<Track> findById(Long id);
}
