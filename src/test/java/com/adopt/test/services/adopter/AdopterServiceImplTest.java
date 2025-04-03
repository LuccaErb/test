package com.adopt.test.services.adopter;

import com.adopt.test.domain.dto.adopter.AdopterDto;
import com.adopt.test.domain.dto.adopter.AdopterDtoResponse;
import com.adopt.test.domain.model.adopter.Adopter;
import com.adopt.test.repositories.adopter.AdopterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdopterServiceImplTest {
    @Mock
    private AdopterRepository repository;

    @InjectMocks
    private AdopterServiceImpl adopterService;

    private AdopterDto adopterDto;
    private Adopter adopter;
    private AdopterDtoResponse adopterDtoResponse;

    @BeforeEach
    void setUp() {
        adopter = new Adopter("Adopter", "111.111.111-11", "1999-01-01", "Rua 1", "email", "1111111111");
        adopterDto = new AdopterDto("Adopter", "111.111.111-11", "1999-01-01", "Rua 1", "email", "1111111111");
        adopterDtoResponse = new AdopterDtoResponse(1L, "Adopter", "111.111.111-11", "1999-01-01", "Rua 1", "email", "1111111111");
    }

    @Test
    void listAllAdoperts() {
        when(repository.findAll()).thenReturn(List.of(adopter));
        List<AdopterDto> result = adopterService.listAllAdoperts();
        assertEquals(1, result.size());
        assertEquals("Adopter", result.get(0).getName());
        repository.findAll();

    }

    @Test
    void getAdopterById() {
        Optional<Adopter> optionalAdopter = repository.findById(1L);
        if (optionalAdopter.isPresent()) {
            Adopter adopter = optionalAdopter.get();
            when(repository.findById(1L)).thenReturn(java.util.Optional.of(adopter));
            AdopterDto result = adopterService.getAdopterById(1L);
            verify(repository, times(1)).findById(1L);
        }
    }

    @Test
    void addAdopter() {
        when(repository.save(adopter)).thenReturn(adopter);
        adopterDtoResponse = adopterService.addAdopter(adopterDto);
        assertEquals(adopterDto.getName(), adopterDtoResponse.getName());
    }

    @Test
    void deleteAdopter() {
        Optional<Adopter> optionalAdopter = repository.findById(1L);
        if (optionalAdopter.isPresent()) {
            Adopter adopter = optionalAdopter.get();
            when(repository.findById(1L)).thenReturn(java.util.Optional.of(adopter));
            adopterService.deleteAdopter(1L);
            verify(repository, times(1)).deleteById(1L);
        }
    }

    @Test
    void updateAdopter() {
        when(repository.findById(1L)).thenReturn(Optional.of(adopter));
        adopterService.updateAdopter(1L, adopterDto);
        verify(repository, times(1)).save(adopter);
    }
}