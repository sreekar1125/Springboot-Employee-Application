package com.vsk.stsweb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vsk.stsweb.model.Employee;


public interface EmployeeRepo extends MongoRepository<Employee, String> {

}
