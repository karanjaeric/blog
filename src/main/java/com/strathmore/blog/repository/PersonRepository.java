/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.strathmore.blog.repository;

import com.strathmore.blog.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ekaranja
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String email);

    Person findById(long id);

    Person findByMobileNumber(String mobileNumber);

}
