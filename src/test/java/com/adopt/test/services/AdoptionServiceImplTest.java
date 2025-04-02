package com.adopt.test.services;

import com.adopt.test.domain.dto.adoption.AdoptionDto;
import com.adopt.test.domain.model.adopter.Adopter;
import com.adopt.test.domain.model.adoption.Adoption;
import com.adopt.test.domain.model.animal.Animal;
import com.adopt.test.repositories.adopter.AdopterRepository;
import com.adopt.test.repositories.adoption.AdoptionRepository;
import com.adopt.test.repositories.animal.AnimalRepository;
import com.adopt.test.services.adoption.AdoptionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    void cancelAdoption() {
        Long adoptionId = 1L;
        Adoption adoption = new Adoption(animal, adopter);
        when(adoptionRepository.findById(adoptionId)).thenReturn(Optional.of(adoption));

        adoptionService.cancelAdoption(adoptionId);

        verify(adoptionRepository, times(1)).delete(adoption);


    }
}