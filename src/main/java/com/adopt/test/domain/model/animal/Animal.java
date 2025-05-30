package com.adopt.test.domain.model.animal;

import com.adopt.test.domain.model.adoption.Adoption;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String race;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private Boolean status;


    @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private Adoption adoption;

    public Animal( String name, String species, String race, String age, Boolean status) {

        this.name = name;
        this.species = species;
        this.race = race;
        this.age = age;
        this.status = status;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) && Objects.equals(name, animal.name) && Objects.equals(species, animal.species) && Objects.equals(race, animal.race) && Objects.equals(age, animal.age) && Objects.equals(status, animal.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, species, race, age, status);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + name + '\'' +
                ", specie='" + species + '\'' +
                ", race='" + race + '\'' +
                ", age='" + age + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
