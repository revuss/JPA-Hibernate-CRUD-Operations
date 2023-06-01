package com.sqlconnetion.inserting.implementationandconstructor;

import com.sqlconnetion.inserting.main.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;


    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findbyId(Integer id)
    {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findall() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findbylastname(String Thelastname)
    {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastname =:theData",Student.class);

        theQuery.setParameter("theData",Thelastname);
        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Transactional
    @Override
    public int deleteAll()
    {
        int items = entityManager.createQuery("Delete from Student").executeUpdate();
        return items;
    }

}