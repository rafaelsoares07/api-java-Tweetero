package com.twitero.api.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitero.api.model.Tweet;

public interface TwitterRepository extends JpaRepository<Tweet,Long>{

    List<Tweet> findByUsernameOrderByIdDesc(String username);

    Page<Tweet> findAllByOrderByIdDesc(org.springframework.data.domain.Pageable pageable);
    
}
