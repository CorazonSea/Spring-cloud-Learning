package com.example.paddington.repository;

import com.example.paddington.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
* 可以根据方法名来自动的生成 SQL，
* 比如findByUserName 会自动生成一个以 userName 为参数的查询方法，
* 比如 findAll 自动会查询表里面的所有数据，
* 比如自动分页等等。
* */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}
