package services;


import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;

import java.util.List;

/**
 * @author XJ
 * @date 2020-4-12
 */

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> getAllStu()
    {
        return studentDao.selectAllStu();
    }

    public void AddStu(Student student)
    {
        studentDao.addStudent(student);
    }

}

