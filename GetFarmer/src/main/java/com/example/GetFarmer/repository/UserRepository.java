package com.example.GetFarmer.repository;

import com.example.GetFarmer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
