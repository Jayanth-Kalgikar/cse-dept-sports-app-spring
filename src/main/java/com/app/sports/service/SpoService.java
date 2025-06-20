package com.app.sports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.sports.entity.SpoEntity;
import com.app.sports.entity.SpoLogin;
import com.app.sports.repo.SpoLoginRepo;
import com.app.sports.repo.SpoRepo;

@Service
public class SpoService {
    @Autowired
    private SpoRepo spoEntityRepository;
    
    @Autowired
    private SpoLoginRepo sportsLoginRepo;

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

    public boolean isUserValid(SpoLogin loginRequest) {
        try {
            SpoLogin dbAccount = sportsLoginRepo.findById(loginRequest.getEmail()).get();
            if(dbAccount.getPassword().contentEquals(loginRequest.getPassword())) {
                return true;
            }
        } catch(Exception e) {
            return false;
        }
        return false;
    }

    public String saveUser(SpoLogin spoLogin) {
        sportsLoginRepo.save(spoLogin);
        return "successfully added new user";
    }

    // Updated method for partial search returning multiple results
    public List<SpoEntity> getEventsByName(String eventName) {
        return spoEntityRepository.findByEventNameContainingIgnoreCase(eventName);
    }
}
