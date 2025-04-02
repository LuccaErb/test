package com.adopt.test.services.adoption;

import com.adopt.test.domain.dto.adoption.AdoptionDto;
import com.adopt.test.domain.dto.adoption.AdoptionDtoResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdoptionService {
    List<AdoptionDto> listAllAdoptions();
    AdoptionDto getAdoptionById(Long id);
    AdoptionDtoResponse addAdoption(Long animalId, Long adopterId)throws Exception;
    ResponseEntity<String> cancelAdoption(Long id);
    List<AdoptionDto> getAdoptionByAdopterId(Long id);
}
