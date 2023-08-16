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

    public Kafedra add(Kafedra kafedra) {
        em.persist(kafedra);
        return kafedra;
    }

    public void remove(int id) {
        Kafedra kafedra = em.find(Kafedra.class, id);
        em.remove(kafedra);
    }

    public Kafedra find(int id) {
        return em.find(Kafedra.class, id);
    }

    public void update(Kafedra selected) {
        em.merge(selected);
    }
}
