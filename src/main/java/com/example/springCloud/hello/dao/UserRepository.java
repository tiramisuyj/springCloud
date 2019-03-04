package com.example.springCloud.hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springCloud.hello.entity.User;

/** 
* @author yj 
* @date 2019-03-03 
*/

public interface UserRepository extends JpaRepository<User, Long>{

}
