package com.service;

import com.model.Track;
import com.repo.ITrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrackService implements ITrackService{
    @Autowired
    private ITrackRepo trackRepo;
    @Override
    public Iterable<Track> findAll() {
        return trackRepo.findAll();
    }

    @Override
    public void save(Track track) {
        trackRepo.save(track);
    }

    @Override
    public void remove(Long id) {
        trackRepo.deleteById(id);
    }

    @Override
    public Optional<Track> findById(Long id) {
        return trackRepo.findById(id);
    }
}
