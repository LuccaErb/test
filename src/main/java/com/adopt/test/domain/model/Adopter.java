package com.adopt.test.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "adopters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Adopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String birth;

    private String address;
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "adopter",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adoption> adoptions;


    public Adopter(  String name, String cpf, String birth, String address, String email, String phone) {

        this.name = name;
        this.cpf = cpf;
        this.birth = birth;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Adopter adopter = (Adopter) o;
        return Objects.equals(id, adopter.id) && Objects.equals(name, adopter.name) && Objects.equals(cpf, adopter.cpf) && Objects.equals(birth, adopter.birth) && Objects.equals(address, adopter.address) && Objects.equals(email, adopter.email) && Objects.equals(phone, adopter.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, birth, address, email, phone);
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birth='" + birth + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
