package com.projectSpring.userdept.repositories;

import com.projectSpring.userdept.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
