package mentoring.bffservice.service;

import lombok.AllArgsConstructor;
import mentoring.bffservice.employeegateway.CreateEmployeeRequest;
import mentoring.bffservice.employeegateway.EmployeeDto;
import mentoring.bffservice.employeegateway.EmployeesClient;
import mentoring.bffservice.employeegateway.RoleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesService {

    private EmployeesClient employeesClient;

    public List<EmployeeDto> listEmployees() {
        return employeesClient.employees();
    }

    public List<RoleDto> listRoles() {
        return employeesClient.roles();
    }

    public void createEmployee(CreateEmployeeRequest command) {
        employeesClient.createEmployee(command);
    }

}
