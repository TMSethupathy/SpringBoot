package com.costom.sec.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.costom.sec.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

	Optional<User> finfindByUserName(String username);
}
