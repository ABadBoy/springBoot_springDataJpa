package com.badboy.springboot.dao;

import com.badboy.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by peter zhao on 2/27/2017.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
