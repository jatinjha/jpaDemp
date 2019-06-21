package com.gfg.jatin.SpringDataJpaDemo.repository;

import com.gfg.jatin.SpringDataJpaDemo.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User,Long>{
    List<User>findUserByFirstname(String fN);
    List<User>findUserByFirstnameAndLastname(String fN,String lN);


}
