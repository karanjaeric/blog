/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.strathmore.blog.service;

import com.strathmore.blog.dao.PersonDao;
import com.strathmore.blog.dto.ResponseDto;
import com.strathmore.blog.model.Person;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ekaranja
 */
@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public ResponseDto addPerson(String surname, String firstname, LocalDate dob, String email, String mobileNumber) {
        ResponseDto responseDto = new ResponseDto();
        try {
            if (personDao.findByEmail(email) != null) {
                responseDto.setMessage("Person With Email " + email + " Already Exist");
                responseDto.setStatus(false);
                return responseDto;
            }
            if (personDao.findByMobileNumber(mobileNumber) != null) {
                responseDto.setMessage("Person With MobileNumber " + mobileNumber + " Already Exist");
                responseDto.setStatus(false);
                return responseDto;
            }

            Person person = new Person();
            if (dob != null) {
                person.setDob(dob);
            }
            if (email != null) {
                person.setEmail(email);
            }
            if (firstname != null) {
                person.setFirstName(firstname);
            }
            if (mobileNumber != null) {
                person.setMobileNumber(mobileNumber);
            }
            if (surname != null) {
                person.setSurname(surname);
            }

            personDao.save(person);
            responseDto.setMessage("Person Saved Successfully");
            responseDto.setStatus(true);
            return responseDto;
        } catch (Exception exception) {
            responseDto.setStatus(false);
            return responseDto;

        }

    }

    public ResponseDto updatePerson(long id, String surname, String firstname, LocalDate dob, String email, String mobileNumber) {
        Person person = personDao.findId(id);
        ResponseDto responseDto = new ResponseDto();
        try {
            person.setDob(dob);
            person.setEmail(email);
            person.setFirstName(firstname);
            person.setMobileNumber(mobileNumber);
            person.setSurname(surname);
            personDao.save(person);
            responseDto.setMessage("Person Updated Successfully");
            responseDto.setStatus(true);
            return responseDto;
        } catch (Exception exception) {
            responseDto.setStatus(false);
            return responseDto;

        }

    }

    public Person getPerson(long id) {

        return personDao.findId(id);

    }

}
