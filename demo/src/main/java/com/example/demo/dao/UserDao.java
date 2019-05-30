package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jams on 2019/5/27.
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
}
