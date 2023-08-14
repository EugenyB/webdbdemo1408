package com.example.webdbdemo1408.beans;

import com.example.webdbdemo1408.dao.KafedraDao;
import com.example.webdbdemo1408.entities.Kafedra;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class KafedraBean implements Serializable {

    @EJB
    private KafedraDao kafedraDao;

    public List<Kafedra> getKafedras() {
        return kafedraDao.findAll();
    }
}
