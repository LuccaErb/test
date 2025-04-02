package com.adopt.test.controllers.adoption;

import com.adopt.test.domain.dto.adoption.AdoptionDto;
import com.adopt.test.domain.dto.adoption.AdoptionDtoResponse;
import com.adopt.test.services.adoption.AdoptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adoption")
public class AdoptionController implements AdoptionControllerAPI {
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> cancelAdoption(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.cancelAdoption(id).getBody());
    }

}
