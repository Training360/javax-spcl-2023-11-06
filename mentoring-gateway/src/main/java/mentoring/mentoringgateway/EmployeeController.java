package mentoring.mentoringgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/dummy-employees")
public class EmployeeController {

    @GetMapping
    public Flux<EmployeeDto> employees() {
        return Flux.fromIterable(List.of(new EmployeeDto(0L, "Dummy Employee", new RoleDto(0L, "Dummy Role"))));
    }
}
