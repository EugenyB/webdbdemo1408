package com.example.webdbdemo1408.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "teacher")
@NamedQueries({
        @NamedQuery(name = "Teacher.findAll", query = "select t from Teacher t")
})
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "experience")
    private Integer experience;

    @ManyToOne
    @JoinColumn(name = "kafedra_id")
    private Kafedra kafedra;

    @ManyToMany
    @JoinTable(name = "teacher_courses",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id"))
    private Set<Course> courses = new LinkedHashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return getId() != null && Objects.equals(getId(), teacher.getId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
}