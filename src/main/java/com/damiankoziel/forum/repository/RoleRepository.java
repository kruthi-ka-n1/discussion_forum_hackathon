package com.damiankoziel.forum.repository;


import com.damiankoziel.forum.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(final String name);
}

