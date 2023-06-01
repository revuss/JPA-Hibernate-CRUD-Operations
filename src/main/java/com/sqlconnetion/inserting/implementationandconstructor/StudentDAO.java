package com.sqlconnetion.inserting.implementationandconstructor;
import com.sqlconnetion.inserting.main.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findbyId(Integer id);

    List<Student> findall();

    List<Student> findbylastname(String Thelastname);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
 }
