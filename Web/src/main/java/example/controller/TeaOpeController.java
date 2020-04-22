package example.controller;


import pojo.NeedHomework;
import pojo.Student;
import pojo.StudentHomework;
import services.NeedHomeworkService;
import services.StudentHomeworkService;
import services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class TeaOpeController {
    @Autowired
   private NeedHomeworkService needHomeworkService;
    @Autowired
   private StudentService studentService;
    @Autowired
   private StudentHomeworkService studentHomeworkService;



    @RequestMapping("/teaOperation")
    public String teaOpe() {
        return "Teacher/TeacherOperation";
    }

    @RequestMapping("/AddNeedHomework")
    public String AddNeed() {
        return "Teacher/AddNeedHomework";
    }

    @RequestMapping("/afterAddNeed")
    public String afterAddneed(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        /**
         * 赋值
         */
        Date create_t = null;

        List<NeedHomework> temp = needHomeworkService.getAllNeed();
        int allid=temp.size();
        allid+=1;
        String allidstr=String.valueOf(allid);
        Long id =Long.parseLong(allidstr);

        String h_id_str=req.getParameter("h_id");
        Long h_id=Long.parseLong(h_id_str);



        String h_titile=req.getParameter("h_title");
        String h_content=req.getParameter("h_content");


        Timestamp dateNow=new Timestamp(System.currentTimeMillis());

        NeedHomework needHomework = new NeedHomework(h_id,h_titile,h_content,dateNow,dateNow);



        needHomeworkService.AddNeed(needHomework);

        List<NeedHomework> list = needHomeworkService.getAllNeed();

        System.out.println(list);

        req.setAttribute("list", list);//在请求里面放了一个list,里面的值是list

        return "Teacher/ShowNeedSub";
    }


    @RequestMapping("/AddStudent")
    public String AddStu() {
        return "Teacher/AddStudent";
    }

    @RequestMapping("/afterAddStu")
    public String afterAddstu(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");



        List<Student> temp = studentService.getAllStu();
        /**
         * 赋值
         */
        Date create_t = null;


        int allid=temp.size();
        allid+=1;

        String allidstr=String.valueOf(allid);

        Long id =Long.parseLong(allidstr);

        String s_id_str=req.getParameter("s_id");
        Long s_id=Long.parseLong(s_id_str);
        String s_name=req.getParameter("s_name");



        Timestamp dateNow=new Timestamp(System.currentTimeMillis());

        Student student = new Student(s_id,s_name,dateNow,dateNow);

        studentService.AddStu(student);


        List<Student> list = studentService.getAllStu();


        req.setAttribute("list", list);//在请求里面放了一个list,里面的值是list

        return "Teacher/ShowAllStu";
    }


    @RequestMapping("/SearchByCond")
    public String SearchByCond() {
        return "Teacher/SearchByCond";
    }

    @RequestMapping("/aftersearch")
    public String aftersearch(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {



        List<StudentHomework> list=null;
        req.setCharacterEncoding("UTF-8");
        String seastu_id=req.getParameter("seastu_id");
        String seahome_id=req.getParameter("seahome_id");

        if(seastu_id=="")
        {
            list= studentHomeworkService.selectbyhome(seahome_id);

        }else if(seahome_id=="")
        {
            list = studentHomeworkService.selectbystu(seastu_id);
        }
        else
        {
            list = studentHomeworkService.selectbycross(seastu_id,seahome_id);
        }


        req.setAttribute("list", list);//在请求里面放了一个list,里面的值是list

        if(null == list || list.size() <= 0)
        {
            req.setAttribute("error", "没有查询到指定数据");//在请求里面放了一个list,里面的值是list
        }
        else
        {
            req.setAttribute("error", "");//在请求里面放了一个list,里面的值是list
        }

        return "ShowAllHome";
    }

    @RequestMapping("/allhomework")
    public String allhomework(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {


        List<StudentHomework> list = studentHomeworkService.getAllSH();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("list", list);//在请求里面放了一个list,里面的值是list

        if(null == list || list.size() <= 0)
        {
            req.setAttribute("error", "没有查询到指定数据");//在请求里面放了一个list,里面的值是list
        }
        else
        {
            req.setAttribute("error", "");//在请求里面放了一个list,里面的值是list
        }

        return "ShowAllHome";
    }

}