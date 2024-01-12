package com.panda.Let.sTalk.repo;

import com.panda.Let.sTalk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional findByUserEmail(String userEmail);
}
