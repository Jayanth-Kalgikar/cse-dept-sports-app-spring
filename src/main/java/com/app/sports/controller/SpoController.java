package com.app.sports.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.app.sports.entity.SpoEntity;
import com.app.sports.entity.SpoLogin;
import com.app.sports.service.SpoService;


//http://localhost:8080/cse/dept/sports/login//


@RestController
@CrossOrigin("*")
public class SpoController {
    @Autowired
    private SpoService spoEntityService;
    
    @GetMapping("/cse/dept/sports/search")
    public SpoEntity getEventByName(@RequestParam String eventName) {
    	
    	return spoEntityService.getEventName(eventName);
    	
    }

    @PostMapping("/cse/dept/sports/")
    public SpoEntity createEvent(@RequestBody SpoEntity spoEntity) {
        return spoEntityService.saveSpoEntity(spoEntity);
    }
    
    @PostMapping("/cse/dept/sports/users/add")
    public String  createEvent(@RequestBody SpoLogin spoLogin) {
        return spoEntityService.saveUser(spoLogin);
    }
    
    @PostMapping("/cse/dept/sports/login")
    public boolean login(@RequestBody SpoLogin loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
        return spoEntityService.isUserValid(loginRequest);
        
       // return true;
    }

    @GetMapping("/cse/dept/sports/{id}")
    public ResponseEntity<?> getEvent(@PathVariable String id) {
        try {
            int parsedId = Integer.parseInt(id);
            SpoEntity spoEntity = spoEntityService.getSpoEntity(parsedId);
            return ResponseEntity.ok(spoEntity);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid ID format");
        }
    }

    @GetMapping("/cse/dept/sports")
    public List<SpoEntity> getAllEvents() {
        return spoEntityService.getAllSpoEntities();
    }

    @DeleteMapping("/cse/dept/sports/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable String id) {
        try {
            int parsedId = Integer.parseInt(id);
            spoEntityService.deleteSpoEntity(parsedId);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid ID format");
        }
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.badRequest().body("Type mismatch error: " + ex.getMessage());
    }
}