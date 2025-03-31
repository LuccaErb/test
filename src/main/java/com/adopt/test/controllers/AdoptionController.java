package com.adopt.test.controllers;

import com.adopt.test.domain.dto.AdoptionDto;
import com.adopt.test.domain.model.Adopter;
import com.adopt.test.domain.model.Adoption;
import com.adopt.test.domain.model.Animal;
import com.adopt.test.services.AdopterService;
import com.adopt.test.services.AdoptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adoption")
public class AdoptionController {
    private final AdoptionService service;



    public AdoptionController(AdoptionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity <List<AdoptionDto>> getAllAdoptions() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllAdoptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity <AdoptionDto> getAdoptionById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAdoptionById(id));
    }

    @PostMapping
    public ResponseEntity<AdoptionDto> addAdoption(@RequestParam Long animalId, @RequestParam Long adopterId) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAdoption(animalId, adopterId));

    }
    @PutMapping("/{id}")
    public ResponseEntity<AdoptionDto> updateAdoption(@PathVariable Long id, @RequestBody AdoptionDto adoptionDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateAdoption(id, adoptionDto));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdoption(@PathVariable Long id) {
        service.deleteAdoption(id);
    }

}
