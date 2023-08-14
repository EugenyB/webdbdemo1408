package com.example.webdbdemo1408.dao;

import com.example.webdbdemo1408.entities.Kafedra;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class KafedraDao {
    @PersistenceContext
    private EntityManager em;

    public List<Kafedra> findAll() {
        return em.createNamedQuery("Kafedra.findAll", Kafedra.class).getResultList();
    }
}
