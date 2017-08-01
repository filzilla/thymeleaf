package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.demo.Grade.Twelfth;

@Controller
public class StudentController {

    @RequestMapping("/new_student")
    public String newStudent(Model model) {

        model.addAttribute("grades", Grade.values() /* call the method on the Grade enum to get all the grades */);
        return "new_student";
    }

    @RequestMapping("/create_student")
    public String createStudent(@RequestParam(value="first_name") String firstName, @RequestParam(value="last_name") String lastName, @RequestParam(value="grade") Grade grade, Model model) {
        Student student = new Student();

        /* set student firstName, lastName and grade using the http request parameters */

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGrade(grade );

        /* add the student to the model that will be used by the view_student html file */
        model.addAttribute("student", student);

        return "view_student";
    }
}
