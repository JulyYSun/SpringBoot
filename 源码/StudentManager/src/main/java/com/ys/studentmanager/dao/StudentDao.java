package com.ys.studentmanager.dao;

import com.ys.studentmanager.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void createStudent(Student student){
        String sql="insert into student(name,id,age,sex) values(?,?,?,?)";
        int update = jdbcTemplate.update(sql, student.getName(), student.getId(), student.getAge(), student.getSex());
        if(update>0){
            //打印添加学生成功信息
            System.out.println("添加学生成功！");
        }
    }

    public void deleteStudent(String id){
        String sql="delete from student WHERE id=?";
        int update = jdbcTemplate.update(sql, id);
        if(update>0){
            //打印删除学生成功信息
            System.out.println("删除学生成功！");
        }
    }

    public void updateStudent(Student student){
        String sql="update student set name=?,age=?,sex=? where id=?";
        String id=student.getId();
        //获取修改之前的信息，如果提交表单中的消息为空，则还是设为原来的信息
        Student oldStudent=getAStudent(student.getId());
        int newAge=student.getAge();
        String newSex=student.getSex();
        String newName=student.getName();
        //判断提交表单中的信息是否为空
        if(newAge==0){
            student.setAge(oldStudent.getAge());
        }
        if(newSex==""){
            student.setSex(oldStudent.getSex());
        }
        if (newName=="") {
            student.setName(oldStudent.getName());
        }
        //更新数据
        jdbcTemplate.update(sql,student.getName(),student.getAge(),student.getSex(),id);
        System.out.println("更新数据成功");
    }

    //根据id获取一个学生对象
    public Student getAStudent(String id){
        String sql="select *from student where id=?";
        BeanPropertyRowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        Student student = jdbcTemplate.queryForObject(sql,rowMapper,id);
        return student;
    }
    public List<Student> getAllStudent(){
        String sql="select *from student";
        BeanPropertyRowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);

        List<Student> studentList = jdbcTemplate.query(sql, rowMapper);
        return studentList;
    }
}
