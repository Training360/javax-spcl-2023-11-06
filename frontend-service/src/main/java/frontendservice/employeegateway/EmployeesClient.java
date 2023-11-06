package frontendservice.employeegateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface EmployeesClient {

    @GetExchange("/api/employees")
    List<EmployeeDto> employees();

    @GetExchange("/api/roles")
    List<RoleDto> roles();
}
