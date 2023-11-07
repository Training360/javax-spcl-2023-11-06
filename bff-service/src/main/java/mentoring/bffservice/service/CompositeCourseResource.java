package mentoring.bffservice.service;

import lombok.Data;
import mentoring.bffservice.employeegateway.EmployeeDto;

import java.util.List;

@Data
public class CompositeCourseResource {

    private Long id;

    private String name;

    private String description;

    private String syllabus;

    private int limit;

    private List<EmployeeDto> enrolledEmployees;

    private List<EmployeeDto> completedEmployees;
}
