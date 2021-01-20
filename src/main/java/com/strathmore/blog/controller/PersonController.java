/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.strathmore.blog.controller;

import com.strathmore.blog.dto.ResponseDto;
import com.strathmore.blog.model.Person;
import com.strathmore.blog.service.PersonService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ekaranja
 */
@RestController
@RequestMapping("/blog")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/addPerson")
    public ResponseDto addPerson(
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "dob") LocalDate dob,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "mobile_no") String mobileNumber
    ) {
        return personService.addPerson(surname, firstName, dob, email, mobileNumber);
    }

    @RequestMapping("/updatePerson")
    public ResponseDto updatePerson(
            @RequestParam(name = "id") long id,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "dob") LocalDate dob,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "mobile_no") String mobileNumber
    ) {
        return personService.updatePerson(id, surname, firstName, dob, email, mobileNumber);
    }

    @RequestMapping("/getPerson")
    public Person getPerson(
            @RequestParam(name = "id") long id
    ) {
        return personService.getPerson(id);
    }

}
