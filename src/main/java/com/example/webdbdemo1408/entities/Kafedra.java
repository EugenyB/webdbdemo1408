package com.example.webdbdemo1408.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "kafedra")
@NamedQueries({
        @NamedQuery(name = "Kafedra.findAll", query = "select k from Kafedra k")
})
public class Kafedra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "kafedra", orphanRemoval = true)
    private Set<Teacher> teachers = new LinkedHashSet<>();

}