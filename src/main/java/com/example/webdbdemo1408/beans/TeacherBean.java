package com.example.webdbdemo1408.beans;

import com.example.webdbdemo1408.dao.TeacherDao;
import com.example.webdbdemo1408.entities.Teacher;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
@Getter
public class TeacherBean implements Serializable {

    @EJB
    private TeacherDao teacherDao;

    private Teacher selected;

    public List<Teacher> getTeachers() {
        return teacherDao.findAll();
    }

    public String showCourses(int id) {
        selected = teacherDao.find(id);
        return "courses_by_teacher";
    }
}
