package edu.itstep;

import edu.itstep.configuration.MyConfig;
import edu.itstep.model.Employee;
import edu.itstep.rest.EmployeeRest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        EmployeeRest employeeRest = context.getBean("employeeRest", EmployeeRest.class);
//        List<Employee> employees = employeeRest.getAllEmployees();
//        for (Employee employee : employees) {
//            System.out.println(employee.getFirstName());
//        }

//        Employee employee = employeeRest.getEmployeeById(1);
//        System.out.println(employee.getSalary());
//
//        Employee employee = new Employee("test1", "test1", "test1", 666);
//        employeeRest.saveEmployee(employee);

        employeeRest.deleteEmployeeById(3);

        context.close();
    }
}
