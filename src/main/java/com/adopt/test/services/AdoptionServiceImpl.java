package com.adopt.test.services;

import com.adopt.test.domain.dto.AdoptionDto;
import com.adopt.test.domain.model.Adopter;
import com.adopt.test.domain.model.Adoption;
import com.adopt.test.domain.model.Animal;
import com.adopt.test.repositories.AdopterRepository;
import com.adopt.test.repositories.AdoptionRepository;
import com.adopt.test.repositories.AnimalRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {
    private final AdoptionRepository adoptionRepository;
    private final AnimalRepository animalRepository;
    private final AdopterRepository adopterRepository;



    @Override
    public List<AdoptionDto> listAllAdoptions() {
        return adoptionRepository.findAll().stream().map(AdoptionDto::new).toList();
    }

    @Override
    public AdoptionDto getAdoptionById(Long id) {
        return adoptionRepository.findById(id).map(AdoptionDto::new).orElseThrow(() -> new RuntimeException("Adoption não encontrado"));
    }

    @Override
    @Transactional
    public AdoptionDto addAdoption(Long animalId, Long adopterId) throws Exception{
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new Exception("Animal não encontrado!"));

        Adopter adopter = adopterRepository.findById(adopterId)
                .orElseThrow(() -> new Exception("Adotante não encontrado!"));

        long activeAdoptionsCount = adoptionRepository.countByAdopterIdAndDateReturnIsNull(adopterId);

        if (activeAdoptionsCount >= 3) {
            throw new Exception("O adotante já tem 3 adoções ativas e não pode adotar mais.");
        }
        if (adoptionRepository.existsByAnimalId(animalId)) {
            throw new Exception("Este animal já está adotado!");
        }
        Adoption adoption = new Adoption(animal, adopter);
        adoption.setDateAdoption(LocalDate.now());

        animal.setStatus(true);
        animalRepository.save(animal);
        adoptionRepository.save(adoption);

        return new AdoptionDto(adoption);
    }

    @Override
    @Transactional
    public AdoptionDto updateAdoption(Long id, AdoptionDto adoptionDto) {
        Adoption adoption = adoptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adoção não encontrada!"));

        adoption.setDateReturn(adoptionDto.getDateReturn());

        if (adoptionDto.getDateReturn() != null) {
            adoption.getAnimal().setStatus(true);
            animalRepository.save(adoption.getAnimal());
        }

        adoptionRepository.save(adoption);
        return new AdoptionDto(adoption);
    }

    @Override
    @Transactional
    public void deleteAdoption(Long id) {
        Adoption adoption = adoptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adoção não encontrada!"));

        adoption.getAnimal().setStatus(true);
        animalRepository.save(adoption.getAnimal());

        adoptionRepository.delete(adoption);
    }

}
