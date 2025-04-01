package com.adopt.test.services;

import com.adopt.test.domain.dto.AdopterDto;
import com.adopt.test.domain.dto.AdopterDtoResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface AdopterService {
    List<AdopterDto> listAllAdoperts();
    AdopterDto getAdopterById(Long id);
    AdopterDtoResponse addAdopter(AdopterDto adopterDto);
    ResponseEntity<String> deleteAdopter(Long id);
    AdopterDtoResponse updateAdopter(Long id, AdopterDto adopterDto);
}
