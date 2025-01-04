package com.costom.sec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.costom.sec.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {

	Role findByName(String roleName);
}
