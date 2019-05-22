package com.stackroute.muzixapplication.Respository;

import com.stackroute.muzixapplication.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MuzixRepository extends JpaRepository<Album,Integer> {
}
