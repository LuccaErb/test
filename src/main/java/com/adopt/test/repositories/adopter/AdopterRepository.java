package com.adopt.test.repositories.adopter;
import com.adopt.test.domain.model.adopter.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Long> {
}
