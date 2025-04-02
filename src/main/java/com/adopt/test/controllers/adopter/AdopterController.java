package com.adopt.test.controllers.adopter;

import com.adopt.test.domain.dto.adopter.AdopterDto;
import com.adopt.test.domain.dto.adopter.AdopterDtoResponse;
import com.adopt.test.services.adopter.AdopterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopter")
public class AdopterController  implements AdopterControllerAPI {


    private final AdopterService service;

    public AdopterController(AdopterService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<AdopterDto>> getAllAdopters() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllAdoperts());
    }


    @GetMapping("/{id}")
    public ResponseEntity<AdopterDto> getAdopterById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAdopterById(id));
    }

    @PostMapping
    public ResponseEntity<AdopterDtoResponse> addAdopter(@RequestBody AdopterDto adopterDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAdopter(adopterDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdopter(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteAdopter(id).getBody());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdopterDtoResponse> updateAdopter(@PathVariable Long id, @RequestBody AdopterDto adopterDto){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateAdopter(id, adopterDto));

    }

}
