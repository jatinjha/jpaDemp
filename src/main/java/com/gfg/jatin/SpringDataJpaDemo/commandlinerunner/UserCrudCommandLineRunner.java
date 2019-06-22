package com.gfg.jatin.SpringDataJpaDemo.commandlinerunner;

import com.gfg.jatin.SpringDataJpaDemo.module.User;
import com.gfg.jatin.SpringDataJpaDemo.repository.UserRepository;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//@Component

@Service
@Slf4j
public class UserCrudCommandLineRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;


    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            log.debug("user for id {} is {} ",id,user.get());
        }else{
            throw new IllegalIdentifierException("id not found");
        }
        return user.get();
    }

    public User updateUser(User user){
        userRepository.save(user);
        return user;
    }

    @Override
    public void run(String... args) throws Exception {

        // create
        User us = new User("job","rob");
        userRepository.save(us);

        User us2 = new User("jj","fab");
        userRepository.save(us2);

        User us3 = new User("jj","fab1");
        userRepository.save(us3);

        User us4 = new User("jjsdf","fabsdfs");
        userRepository.save(us4);


        List<User> users1 = userRepository.findUserByFirstname("jj");
        System.out.println("user by first name jj is "+users1);

        List<User> users2 = userRepository.findUserByFirstnameAndLastname("jj","fab");
        System.out.println("user by first name jj and last name fab is "+users2);


       /*
        //view
        List<User> list_of_user = userRepository.findAll();
        System.out.println("before updation " +list_of_user);


        //update

        us2.setFirst_name("jatin");
        userRepository.save(us2);

        //delete

        userRepository.delete(us);


        list_of_user = userRepository.findAll();
        System.out.println("after updation " +list_of_user);


        */



    }
}
