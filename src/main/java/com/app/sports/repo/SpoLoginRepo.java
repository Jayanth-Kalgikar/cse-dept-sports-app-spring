package com.app.sports.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.sports.entity.SpoLogin;

public interface SpoLoginRepo extends JpaRepository<SpoLogin, String>{

}
