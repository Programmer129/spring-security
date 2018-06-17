package com.springsecurity.springsecurity.repositories;

import com.springsecurity.springsecurity.entities.Authorities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authorities, Integer> {

    Authorities getByUserName(String userName);
}
