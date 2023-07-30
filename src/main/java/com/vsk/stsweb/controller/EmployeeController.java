package com.vsk.stsweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vsk.stsweb.model.Employee;
import com.vsk.stsweb.service.EmailSenderService;
import com.vsk.stsweb.service.EmployeeService;

@RestController
@RequestMapping("v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	//Entry Level
	@PostMapping("addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable String id){
		return employeeService.deleteEmployeeById(id);
	}
	
	@PutMapping("updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable String id, @RequestBody Employee employee){
		return employeeService.updateEmployeeById(id, employee);
	}
	
	
	//Intermediate Level
	
	@GetMapping("getNthManager/{id}/{n}")
	public ResponseEntity<String> getNthManager(@PathVariable("id") String id, @PathVariable("n") int n){
		return employeeService.getNthManager(id, n);
	}
	
	@GetMapping("getAllEmployees/{field}")
	public ResponseEntity<List<Employee>> getEmpWithSort(@PathVariable String field){
		return employeeService.getEmpsWithSort(field);
	}
	
	@GetMapping("getAllEmployees/pageNo={pageNo}/pageSize={pageSize}/sortBy={field}")
	public ResponseEntity<List<Employee>> getAllEmployeesByPagingAndSorting(@PathVariable int pageNo, @PathVariable int pageSize, @PathVariable String field){
		return employeeService.getAllEmployeesByPagingAndSorting(pageNo, pageSize, field);
	}
	
	//Advanced Level also implemented
}
