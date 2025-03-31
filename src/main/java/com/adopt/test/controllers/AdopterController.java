package com.adopt.test.controllers;

import com.adopt.test.domain.dto.AdopterDto;
import com.adopt.test.services.AdopterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopter")
public class AdopterController {

    private final AdopterService service;

    public AdopterController(AdopterService service) {
        this.service = service;
    }

    //get
    @GetMapping
    public ResponseEntity<List<AdopterDto>> getAllAdopters() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllAdoperts());
    }

    //get by id
    @GetMapping("/{id}")
    public ResponseEntity<AdopterDto> getAdopterById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAdopterById(id));
    }
    //post
    @PostMapping
    public ResponseEntity<AdopterDto> addAdopter(@RequestBody AdopterDto adopterDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAdopter(adopterDto));
    }
    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdopter(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteAdopter(id).getBody());
    }

    //put
    @PutMapping("/{id}")
    public ResponseEntity<AdopterDto> updateAdopter(@PathVariable Long id, @RequestBody AdopterDto adopterDto){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateAdopter(id, adopterDto));

    }

}
