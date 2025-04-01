package com.adopt.test.controllers;

import com.adopt.test.domain.dto.AdoptionDto;
import com.adopt.test.domain.dto.AdoptionDtoResponse;
import com.adopt.test.services.AdoptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/by-adopter-id/{id}")
    public ResponseEntity<List<AdoptionDto>> getAdoptionByAdopterId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAdoptionByAdopterId(id));
    }

    @PostMapping
    public ResponseEntity<AdoptionDtoResponse> addAdoption(@RequestParam Long animalId, @RequestParam Long adopterId) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAdoption(animalId, adopterId));

    }
    @PutMapping("/{id}")
    public ResponseEntity<AdoptionDtoResponse> updateAdoption(@PathVariable Long id, @RequestBody AdoptionDto adoptionDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateAdoption(id, adoptionDto));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdoption(@PathVariable Long id) {
        service.deleteAdoption(id);
    }

}
