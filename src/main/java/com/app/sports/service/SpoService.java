package com.app.sports.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.sports.entity.SpoEntity;
import com.app.sports.repo.SpoRepo;

@Service
public class SpoService {
    @Autowired
    private SpoRepo spoEntityRepository;

    public SpoEntity saveSpoEntity(SpoEntity spoEntity) {
        return spoEntityRepository.save(spoEntity);
    }

    public SpoEntity getSpoEntity(int id) {
        return spoEntityRepository.findById(id).orElse(null);
    }

    public List<SpoEntity> getAllSpoEntities() {
        return spoEntityRepository.findAll();
    }

    public void deleteSpoEntity(int id) {
        spoEntityRepository.deleteById(id);
    }
}
