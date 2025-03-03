package com.app.sports.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.sports.entity.SpoEntity;

public interface SpoRepo extends JpaRepository<SpoEntity, Integer> {
}
