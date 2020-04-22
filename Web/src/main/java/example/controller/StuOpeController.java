package example.controller;


import pojo.NeedHomework;
import pojo.StudentHomework;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import services.NeedHomeworkService;
import services.StudentHomeworkService;
import services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class StuOpeController {
    @Autowired
    private NeedHomeworkService needHomeworkService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentHomeworkService studentHomeworkService;



    @RequestMapping("/stuLogin")
    public String stuLogin() {
        return "Student/StudentLogin";
    }

    @RequestMapping("/stuOperation")
    public String stuOpe() {
        return "Student/StudentOperation";
    }


    @RequestMapping("/submithome")
    public String submithome() {
        return "Student/SubmitHome";
    }

    @RequestMapping("/aftersubmithome")
    public String aftersubmithome(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        /**
         * 赋值
         */
        Date create_t = null;

        List<StudentHomework> temp = studentHomeworkService.getAllSH();
        int allid=temp.size();
        allid+=1;

        String allidstr=String.valueOf(allid);

        Long id =Long.parseLong(allidstr);

        String s_id_str=req.getParameter("s_id");
        Long s_id=Long.parseLong(s_id_str);
        String h_id_str=req.getParameter("h_id");
        Long h_id=Long.parseLong(h_id_str);


        String h_titile=req.getParameter("h_title");
        String h_content=req.getParameter("h_content");

        Timestamp dateNow=new Timestamp(System.currentTimeMillis());

        StudentHomework SubNewHomework=new StudentHomework(id,s_id,h_id,h_titile,h_content,dateNow,dateNow);

        studentHomeworkService.addStudentHomework(SubNewHomework);
        List<StudentHomework> list=studentHomeworkService.getMySH(s_id_str);

        req.setAttribute("list", list);
        //在请求里面放了一个list,里面的值是list
        if(null == list || list.size() <= 0)
        {
            req.setAttribute("error", "没有查询到指定数据");
            //在请求里面放了一个list,里面的值是list
        }
        else
        {
            req.setAttribute("error", "");
            //在请求里面放了一个list,里面的值是list
        }

        return "ShowAllHome";
    }

    @RequestMapping("/needhomework")
    public String needhomw(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");



        List<NeedHomework> list = needHomeworkService.getAllNeed();



        req.setAttribute("list", list);//在请求里面放了一个list,里面的值是list


        if(null == list || list.size() <= 0)
        {
            req.setAttribute("error", "没有查询到指定数据");//在请求里面放了一个list,里面的值是list
        }
        else
        {
            req.setAttribute("error", "");//在请求里面放了一个list,里面的值是list
        }

        return "Teacher/ShowNeedSub";
    }

    @RequestMapping("/myhomework")
    public String myhomework(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String my_id=req.getParameter("my_id");

        List<StudentHomework> list = studentHomeworkService.getMySH(my_id);


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
