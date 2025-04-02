package com.adopt.test.repositories.adoption;

import com.adopt.test.domain.model.adoption.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    long countByAdopterIdAndDateReturnIsNull(Long adopterId);
    boolean existsByAnimalId(Long animalId);
    List<Adoption> findByAdopterId(Long id);
}

