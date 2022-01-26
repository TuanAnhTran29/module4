package com.repo;

import com.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrackRepo extends JpaRepository<Track,Long> {
}
