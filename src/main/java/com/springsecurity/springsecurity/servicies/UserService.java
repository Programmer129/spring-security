package com.springsecurity.springsecurity.servicies;

import com.springsecurity.springsecurity.entities.Users;
import com.springsecurity.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findOne(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Transactional
    public void updateUserState(String userName) {
        Users user = userRepository.findByUserName(userName);
        int block=  user.getEnabled() ? 0 : 1;
        Query query = manager.createNativeQuery("update users set enabled=:block where username=:name");
        query.setParameter("name", userName);
        query.setParameter("block", block);
        query.executeUpdate();
    }

    @Transactional
    public void deleteUser(String userName) {
        Query query = manager.createNativeQuery("delete from users where username=:name");
        query.setParameter("name", userName);
        query.executeUpdate();
    }

    public String currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @Transactional
    public void editUser(Users user, String userName) {
        Query query = manager.createNativeQuery("update users set firstname=:fname,lastname=:lname where username=:uname");
        query.setParameter("fname", user.getFirstName());
        query.setParameter("lname", user.getLastName());
        query.setParameter("uname", userName);
        query.executeUpdate();
    }
}
