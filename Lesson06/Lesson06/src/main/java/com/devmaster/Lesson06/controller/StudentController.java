package com.devmaster.Lesson06.controller;

import com.devmaster.Lesson06.dto.StudentDTO;
import com.devmaster.Lesson06.entity.Student;
import com.devmaster.Lesson06.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/student-list";
    }

    @GetMapping("/add-new")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "students/student-add";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable (value = "id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "students/student-edit";
    }

    @PostMapping("/")
    public String saveStudent(@ModelAttribute("student") StudentDTO studentDTO) {
        studentService.save(studentDTO);
        return "redirect:/students";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable (value = "id") Long id, @ModelAttribute("student") StudentDTO studentDTO) {
        studentService.update(id, studentDTO);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable (value = "id") Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
