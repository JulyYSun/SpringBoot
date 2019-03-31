package com.ys.studentmanager.controller;

import com.ys.studentmanager.dao.StudentDao;
import com.ys.studentmanager.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @PostMapping("/createStudent")
    public String createStudent(Student student){
        studentDao.createStudent(student);
        return "redirect:student";
    }
    @GetMapping("/student")
    public String studentPage(ModelMap map){
        List<Student> studentList = studentDao.getAllStudent();
        map.addAttribute("studentList",studentList);
        return "student";
    }
    @PostMapping("/deleteStudent")
    public String deleteStudent(String id){
        studentDao.deleteStudent(id);
        return "redirect:student";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(String age,String name,String sex,String id){
        int ageInt=0;
        if(age!=""){
            ageInt= Integer.parseInt(age);
        }
        Student student=new Student(name,id,ageInt,sex);
        studentDao.updateStudent(student);
        return "redirect:student";
    }

}
