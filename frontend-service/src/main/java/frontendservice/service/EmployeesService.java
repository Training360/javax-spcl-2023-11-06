package frontendservice.service;

import frontendservice.employeegateway.CreateEmployeeRequest;
import frontendservice.employeegateway.EmployeeDto;
import frontendservice.employeegateway.EmployeesClient;
import frontendservice.employeegateway.RoleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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
