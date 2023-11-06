package frontendservice.employeegateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

public interface EmployeesClient {

    @GetExchange("/api/employees")
    List<EmployeeDto> employees();

    @GetExchange("/api/roles")
    List<RoleDto> roles();

    @PostExchange("/api/employees")
    EmployeeDto createEmployee(@RequestBody CreateEmployeeRequest request);
}
