package com.app.sports.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.sports.entity.SpoEntity;

public interface SpoRepo extends JpaRepository<SpoEntity, Integer> {
    
    List<SpoEntity> findByEventNameContainingIgnoreCase(String eventName);
}
