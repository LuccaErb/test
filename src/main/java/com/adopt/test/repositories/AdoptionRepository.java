package com.adopt.test.repositories;

import com.adopt.test.domain.dto.AdoptionDto;
import com.adopt.test.domain.dto.AnimalDto;
import com.adopt.test.domain.model.Adoption;
import com.adopt.test.domain.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    long countByAdopterIdAndDateReturnIsNull(Long adopterId);
    boolean existsByAnimalId(Long animalId);

    List<Adoption> findByAdopterId(Long id);
}

