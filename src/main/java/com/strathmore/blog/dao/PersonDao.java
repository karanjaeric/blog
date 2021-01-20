/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.strathmore.blog.dao;

import com.strathmore.blog.model.Person;
import com.strathmore.blog.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ekaranja
 */
@Service
public class PersonDao {
    
    @Autowired
    private PersonRepository personRepository;
    
    public Person findId(long id) {
        return personRepository.findById(id);
    }
    
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }
    
    public Person save(Person person) {
        return personRepository.save(person);
    }
    
    public Person findByMobileNumber(String mobileNumber) {
        return personRepository.findByMobileNumber(mobileNumber);
    }
    
}
