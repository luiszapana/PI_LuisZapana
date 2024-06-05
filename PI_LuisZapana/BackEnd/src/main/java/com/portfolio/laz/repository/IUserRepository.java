package com.portfolio.laz.repository;

import com.portfolio.laz.entities.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
