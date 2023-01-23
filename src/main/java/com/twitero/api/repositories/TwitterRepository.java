package com.twitero.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitero.api.model.Tweet;

public interface TwitterRepository extends JpaRepository<Tweet,Long>{

    List<Tweet> findByUsername(String username);
    
}
