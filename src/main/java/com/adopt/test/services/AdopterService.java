package com.adopt.test.services;

import com.adopt.test.domain.dto.AdopterDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface AdopterService {
    List<AdopterDto> listAllAdoperts();
    AdopterDto getAdopterById(Long id);
    AdopterDto addAdopter(AdopterDto adopterDto);
    ResponseEntity<String> deleteAdopter(Long id);
    AdopterDto updateAdopter(Long id, AdopterDto adopterDto);
}
