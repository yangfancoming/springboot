package com.goat.dxfl.repository;

import com.goat.dxfl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
