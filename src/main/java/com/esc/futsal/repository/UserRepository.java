package com.esc.futsal.repository;

import com.esc.futsal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    Iterable<User> getByFirstName(String firstName);

    List<User> findUserByUsername(String username);


}


