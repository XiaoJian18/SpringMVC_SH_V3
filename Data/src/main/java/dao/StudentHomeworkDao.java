package dao;




import pojo.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XJ
 * @date 2020-4-12
 */
@Scope("singleton")
@Repository
public class StudentHomeworkDao {
    @Autowired
    private DatabasePool databasePool;


    public  void addStudentHomework(StudentHomework studentHomework){



        Connection conn= null;
        try {
            conn = databasePool.getHikariDataSource().getConnection();
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into s_student_homework values (?,?,?,?,?,?,?)";

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);

            ps.setLong(1,studentHomework.getId());
            ps.setLong(2,studentHomework.getStudentId());
            ps.setLong(3,studentHomework.getHomeworkId());
            ps.setString(4,studentHomework.getHomeworkTitle());
            ps.setString(5,studentHomework.getHomeworkContent());
            ps.setTimestamp(6,studentHomework.getCreateTime());
            ps.setTimestamp(7,studentHomework.getUpdateTime());

            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public List<StudentHomework> selectAll()
    {

        Connection conn= null;

        String sqlString = "SELECT * FROM s_student_homework";


        try {
            conn = databasePool.getHikariDataSource().getConnection();
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<StudentHomework> list = new ArrayList<>();
        try
        {
            ps=conn.prepareStatement(sqlString);
            rs=ps.executeQuery(sqlString);
            // 获取执行结果
            while (rs.next()){
                StudentHomework sh = new StudentHomework();
                sh.setId(rs.getLong("id"));
                sh.setStudentId(rs.getLong("student_id"));
                sh.setHomeworkId(rs.getLong("homework_id"));
                sh.setHomeworkTitle(rs.getString("homework_title"));
                sh.setHomeworkContent(rs.getString("homework_content"));
                sh.setCreateTime(rs.getTimestamp("create_time"));
                sh.setUpdateTime(rs.getTimestamp("update_time"));
                list.add(sh);
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return list;

    }
    public List<StudentHomework> selectmy(String my_id)
    {



        String sqlString = "SELECT * FROM s_student_homework WHERE student_id="+my_id;

        Connection conn= null;
        try {
            conn = databasePool.getHikariDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<StudentHomework> list = new ArrayList<>();
        try
        {
            ps=conn.prepareStatement(sqlString);
            rs=ps.executeQuery(sqlString);
            // 获取执行结果
            while (rs.next()){
                StudentHomework sh = new StudentHomework();
                sh.setId(rs.getLong("id"));
                sh.setStudentId(rs.getLong("student_id"));
                sh.setHomeworkId(rs.getLong("homework_id"));
                sh.setHomeworkTitle(rs.getString("homework_title"));
                sh.setHomeworkContent(rs.getString("homework_content"));
                sh.setCreateTime(rs.getTimestamp("create_time"));
                list.add(sh);
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return list;

    }
    public List<StudentHomework> selectbystu(String stu_id)
    {



        String sqlString = "SELECT * FROM s_student_homework WHERE student_id="+stu_id;

        Connection conn= null;
        try {
            conn = databasePool.getHikariDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<StudentHomework> list = new ArrayList<>();
        try
        {
            ps=conn.prepareStatement(sqlString);
            rs=ps.executeQuery(sqlString);
            // 获取执行结果
            while (rs.next()){
                StudentHomework sh = new StudentHomework();
                sh.setId(rs.getLong("id"));
                sh.setStudentId(rs.getLong("student_id"));
                sh.setHomeworkId(rs.getLong("homework_id"));
                sh.setHomeworkTitle(rs.getString("homework_title"));
                sh.setHomeworkContent(rs.getString("homework_content"));
                sh.setCreateTime(rs.getTimestamp("create_time"));
                list.add(sh);
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return list;

    }
    public List<StudentHomework> selectbyhome(String home_id)
    {

        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id="+home_id;

        Connection conn= null;
        try {
            conn = databasePool.getHikariDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<StudentHomework> list = new ArrayList<>();
        try
        {
            ps=conn.prepareStatement(sqlString);
            rs=ps.executeQuery(sqlString);
            // 获取执行结果
            while (rs.next()){
                StudentHomework sh = new StudentHomework();
                sh.setId(rs.getLong("id"));
                sh.setStudentId(rs.getLong("student_id"));
                sh.setHomeworkId(rs.getLong("homework_id"));
                sh.setHomeworkTitle(rs.getString("homework_title"));
                sh.setHomeworkContent(rs.getString("homework_content"));
                sh.setCreateTime(rs.getTimestamp("create_time"));
                list.add(sh);
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return list;

    }

    public List<StudentHomework> selectbycross(String stu_id,String home_id)
    {



        String sqlString = "SELECT * FROM s_student_homework WHERE student_id="+stu_id+" AND homework_id="+home_id;



        Connection conn= null;
        try {
            conn = databasePool.getHikariDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<StudentHomework> list = new ArrayList<>();
        try
        {
            ps=conn.prepareStatement(sqlString);
            rs=ps.executeQuery(sqlString);
            // 获取执行结果
            while (rs.next()){
                StudentHomework sh = new StudentHomework();
                sh.setId(rs.getLong("id"));
                sh.setStudentId(rs.getLong("student_id"));
                sh.setHomeworkId(rs.getLong("homework_id"));
                sh.setHomeworkTitle(rs.getString("homework_title"));
                sh.setHomeworkContent(rs.getString("homework_content"));
                sh.setCreateTime(rs.getTimestamp("create_time"));
                list.add(sh);
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;

    }
}
