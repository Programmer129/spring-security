package com.springsecurity.springsecurity.repositories;

import com.springsecurity.springsecurity.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {

    List<Users> findAll();
    Users findByUserName(String userName);
}
