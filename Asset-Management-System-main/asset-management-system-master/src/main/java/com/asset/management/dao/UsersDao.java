package com.asset.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asset.management.entity.Users;
import org.springframework.data.jpa.repository.Query;

public interface UsersDao extends JpaRepository<Users,Long>{
    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    Users findByEmail(String email);
}
