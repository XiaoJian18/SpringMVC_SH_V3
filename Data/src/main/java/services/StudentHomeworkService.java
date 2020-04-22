package services;

import dao.StudentHomeworkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.StudentHomework;

import java.util.List;

/**
 * @author XJ
 * @date 2020-4-12
 */

@Service
public class StudentHomeworkService {
    @Autowired
    private StudentHomeworkDao studentHomeworkDao;


    public void addStudentHomework(StudentHomework studentHomework)
    {
        studentHomeworkDao.addStudentHomework(studentHomework);
    }
    public List<StudentHomework> getAllSH()
    {
        return studentHomeworkDao.selectAll();
    }

    public List<StudentHomework> getMySH(String my_id)
    {
        return studentHomeworkDao.selectmy(my_id);
    }
    public List<StudentHomework> selectbystu(String stu_id)
    {
        return studentHomeworkDao.selectbystu(stu_id);
    }

    public List<StudentHomework> selectbyhome(String home_id)
    {
        return studentHomeworkDao.selectbyhome(home_id);
    }

    public List<StudentHomework> selectbycross(String stu_id,String home_id)
    {
        return studentHomeworkDao.selectbycross(stu_id,home_id);
    }

}

