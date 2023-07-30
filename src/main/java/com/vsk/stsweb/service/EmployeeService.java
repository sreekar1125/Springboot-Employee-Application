package com.vsk.stsweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vsk.stsweb.model.Employee;
import com.vsk.stsweb.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	

	@Autowired
	private JavaMailSender javaMailSender;
	

//	EmailSenderService emailSenderService = new EmailSenderService();

	public ResponseEntity<String> addEmployee(Employee employee) {
		try {
			String uuid = UUID.randomUUID().toString();
			employee.setId(uuid);
			employeeRepo.save(employee);
			String res = sendMail(employee.getReportsTo(), employee);  //Advanced Level
			if(res != "Mail sent") {
				return new ResponseEntity<String>(res, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<String>("Employee created", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Exception : " + e, HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<Employee>> getAllEmployees() {
		try {
			return new ResponseEntity<List<Employee>>(employeeRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Employee>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		} 
	}

	public ResponseEntity<String> deleteEmployeeById(String id) {
		try {
			employeeRepo.deleteById(id);
			return new ResponseEntity<>("Employee Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception : " + e, HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Employee> updateEmployeeById(String id, Employee employee) {
		try {
			if(employeeRepo.existsById(id)) {
				Employee existingEmployee = employeeRepo.findById(id).get();
				Employee updatedEmployee = updateEmployee(employee, existingEmployee);
				
				employeeRepo.deleteById(id); //Deleting the previous data
				employeeRepo.save(updatedEmployee);  //Saving the updated details

				return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
			}
			
			else {
				return new ResponseEntity<>(new Employee(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(new Employee(), HttpStatus.BAD_REQUEST);
		}
	}


	public ResponseEntity<String> getNthManager(String id, int n) {
		try {
			if(n == 0 || id == null || !employeeRepo.existsById(id) ) {
				return new ResponseEntity<>("n or id is invalid", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(getNManager(id, n), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception : " + e, HttpStatus.BAD_REQUEST);
		}
	}
	
	

	public ResponseEntity<List<Employee>> getEmpsWithSort(String field) {
		try {
			return new ResponseEntity<List<Employee>>(employeeRepo.findAll(Sort.by(Sort.Direction.ASC, field)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Employee>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
	}
	

	public ResponseEntity<List<Employee>> getAllEmployeesByPagingAndSorting(int pageNo, int pageSize,
			String field) {
		try {
			List<Employee> employees = employeeRepo.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.by(field))).getContent();
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Employee>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		}
	}

	private String getNManager(String id, int n) {
		while (n > 0) {
			if(employeeRepo.findById(id).get().getReportsTo() == "ceo") {
				return "The max n :" + n + " is CEO of Company";
			}
			id = employeeRepo.findById(id).get().getReportsTo();
			n--;
		}
		return employeeRepo.findById(id).get().getName();
	}

	private Employee updateEmployee(Employee employee, Employee existingEmployee) {
		Employee updatedEmployee = new Employee();
		
		updatedEmployee.setId(existingEmployee.getId());
		
		if(employee.getName() != null && employee.getName() != existingEmployee.getName()) {
			updatedEmployee.setName(employee.getName());
		}else {
			updatedEmployee.setName(existingEmployee.getName());
		}

		if(employee.getPhone() != null && employee.getPhone() != existingEmployee.getPhone()) {
			updatedEmployee.setPhone(employee.getPhone());
		}else {
			updatedEmployee.setPhone(existingEmployee.getPhone());
		}

		if(employee.getEmail() != null && employee.getEmail() != existingEmployee.getEmail()) {
			updatedEmployee.setEmail(employee.getEmail());
		}else {
			updatedEmployee.setEmail(existingEmployee.getEmail());
		}
		
		if(employee.getReportsTo() != null && employee.getReportsTo() != existingEmployee.getReportsTo()) {
			updatedEmployee.setReportsTo(employee.getReportsTo());
		}else {
			updatedEmployee.setReportsTo(existingEmployee.getReportsTo());
		}


		if(employee.getImage() != null && employee.getImage() != existingEmployee.getImage()) {
			updatedEmployee.setImage(employee.getImage());
		}else {
			updatedEmployee.setImage(existingEmployee.getImage());
		}
		
		return updatedEmployee;
		
	}



	private String sendMail(String id, Employee employee) {
		String toEmail = employeeRepo.findById(id).get().getEmail();
		String body = employee.getName() + " will now work under you. "
				+ " Mobile number is " + employee.getPhone()
				+  " and email is " + employee.getEmail();
		String subject = "New Employee Details";
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setFrom("globalgroupware5@gmail.com");
			message.setTo(toEmail);
			message.setSubject(subject);
			message.setText(body);
			
			javaMailSender.send(message);
			return "Mail sent";
			
		} catch (Exception e) {
			return "Exception in mail : "+e;
		}
	}






}
