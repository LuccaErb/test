package com.adopt.test.services;

import com.adopt.test.domain.dto.AdoptionDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdoptionService {
    List<AdoptionDto> listAllAdoptions();
    AdoptionDto getAdoptionById(Long id);
    AdoptionDto addAdoption(Long animalId, Long adopterId)throws Exception;
    AdoptionDto updateAdoption(Long id, AdoptionDto adoptionDto);
    void deleteAdoption(Long id);

}
