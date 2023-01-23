package com.twitero.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.twitero.api.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
