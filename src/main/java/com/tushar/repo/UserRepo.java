package com.tushar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
