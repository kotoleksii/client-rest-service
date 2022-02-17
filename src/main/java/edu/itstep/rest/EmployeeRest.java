package edu.itstep.rest;

import edu.itstep.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class EmployeeRest {
    @Autowired
    private RestTemplate restTemplate;
    private static final String URL = "http://localhost:8080/api/employees";

    public List<Employee> getAllEmployees() {
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
                });
        List<Employee> employees = responseEntity.getBody();
        return employees;

    }

    public Employee getEmployeeById(int id) {
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<Employee> responseEntity = restTemplate.postForEntity(URL, employee, Employee.class);
            System.out.println(responseEntity.getBody());
        }
    }

    public void deleteEmployeeById(int id) {
        restTemplate.delete(URL + "/" + id);
    }
}
