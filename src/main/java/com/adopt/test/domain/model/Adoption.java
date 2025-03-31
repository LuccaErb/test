package com.adopt.test.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import java.util.Objects;

@Entity
@Table(name = "adoptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Adoption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private LocalDate dateAdoption;

    private LocalDate dateReturn;


    // Garante que um animal só pode estar em uma adoção ativa
    @OneToOne
    @JoinColumn(name = "animal_id", nullable = false, unique = true)
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "adopter_id", nullable = false)
    private Adopter adopter;

    public Adoption( Animal animal, Adopter adopter) {

        this.dateAdoption = LocalDate.now();

        this.animal = animal;
        this.adopter = adopter;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Adoption adoption = (Adoption) o;
        return Objects.equals(id, adoption.id) && Objects.equals(dateAdoption, adoption.dateAdoption) && Objects.equals(dateReturn, adoption.dateReturn) && Objects.equals(animal, adoption.animal) && Objects.equals(adopter, adoption.adopter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateAdoption, dateReturn, animal, adopter);
    }

    @Override
    public String toString() {
        return "Adoption{" +
                "id=" + id +
                ", dateAdoption=" + dateAdoption +
                ", dateReturn=" + dateReturn +
                ", animal=" + animal +
                ", adopter=" + adopter +
                '}';
    }
}

