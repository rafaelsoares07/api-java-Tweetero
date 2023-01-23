package com.twitero.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitero.api.model.Twitter;

public interface TwitterRepository extends JpaRepository<Twitter,Long>{
    List<Twitter> findByUsername(String username); 
}
