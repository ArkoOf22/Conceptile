package com.Conceptile.Conceptile_Project.repository;

import com.Conceptile.Conceptile_Project.model.App_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<App_User, Long> {}
