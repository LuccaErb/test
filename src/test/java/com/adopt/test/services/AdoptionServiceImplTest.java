package com.adopt.test.services;

import com.adopt.test.domain.dto.AdopterDto;
import com.adopt.test.domain.dto.AdoptionDto;
import com.adopt.test.domain.dto.AdoptionDtoResponse;
import com.adopt.test.domain.model.Adopter;
import com.adopt.test.domain.model.Adoption;
import com.adopt.test.domain.model.Animal;
import com.adopt.test.repositories.AdopterRepository;
import com.adopt.test.repositories.AdoptionRepository;
import com.adopt.test.repositories.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)

class AdoptionServiceImplTest {
    @Mock
    private AdoptionRepository adoptionRepository;

    @Mock
    private AdopterRepository adopterRepository;

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AdoptionServiceImpl adoptionService;

    private Adopter adopter;
    private Animal animal;
    private Adoption adoption;
    @BeforeEach
    void setup() {


        adopter = new Adopter("nome", "cpf", "birth", "address", "email", "phone");
        animal = new Animal("nome", "espécie", "raça", "idade", true);
        adoption = new Adoption(animal, adopter);
    }
    @Test
    void listAllAdoptions() {
        List<Adoption> adoptions = new ArrayList<>();
        adoptions.add(adoption);
        when(adoptionRepository.findAll()).thenReturn(adoptions);


        List<AdoptionDto> result = adoptionService.listAllAdoptions();


        assertEquals(1, result.size());

        assertEquals(adoption.getAdopter().getId(), result.get(0).getAdopterId());
    }

    @Test
    void getAdoptionById() {
        when(adoptionRepository.findById(any())).thenReturn(Optional.of(adoption));

        AdoptionDto result = adoptionService.getAdoptionById(adoption.getAnimal().getId());

        assertNotNull(result);
        assertEquals(adoption.getAnimal().getId(), result.getAnimalId());
        assertEquals(adoption.getAdopter().getId(), result.getAdopterId());
        assertEquals(adoption.getDateAdoption(), result.getDateAdoption());
        assertEquals(adoption.getDateReturn(), result.getDateReturn());

    }

    @Test
    void getAdoptionByAdopterId() {


    }


    @Test
    void addAdoption() {
        when(animalRepository.findById(any())).thenReturn(Optional.of(animal));
        when(adopterRepository.findById(any())).thenReturn(Optional.of(adopter));
        when(adoptionRepository.save(any())).thenReturn(adoption);

        AdoptionDtoResponse result = adoptionService.addAdoption(animal.getId(), adopter.getId());

        assertEquals(adoption.getId(), result.getId());
        assertEquals(adoption.getDateAdoption(), result.getDateAdoption());
        assertEquals(adoption.getDateReturn(), result.getDateReturn());
        assertEquals(adoption.getAnimal().getId(), result.getAnimalId());
        assertEquals(adoption.getAdopter().getId(), result.getAdopterId());
    }

    @Test
    void updateAdoption() {
        when(adoptionRepository.findById(any())).thenReturn(Optional.of(adoption));
        when(adoptionRepository.save(any())).thenReturn(adoption);

        AdoptionDto adoptionDto = new AdoptionDto(adoption);
        AdoptionDtoResponse result = adoptionService.updateAdoption(1L, adoptionDto);

        assertEquals(adoption.getId(), result.getId());
        assertEquals(adoption.getDateAdoption(), result.getDateAdoption());
        assertEquals(adoption.getDateReturn(), result.getDateReturn());
        assertEquals(adoption.getAnimal().getId(), result.getAnimalId());
        assertEquals(adoption.getAdopter().getId(), result.getAdopterId());
    }

    @Test
    void cancelAdoption() {
        Long adoptionId = 1L;
        Adoption adoption = new Adoption(animal, adopter);
        when(adoptionRepository.findById(adoptionId)).thenReturn(Optional.of(adoption));

        adoptionService.cancelAdoption(adoptionId);

        verify(adoptionRepository, times(1)).delete(adoption);


    }
}