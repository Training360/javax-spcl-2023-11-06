package mentoring.bffservice.service;

import mentoring.bffservice.coursegateway.CourseResource;
import mentoring.bffservice.employeegateway.EmployeeDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CourseMapperDecorator implements CourseMapper {

    @Autowired
    @Qualifier("delegate")
    private CourseMapper courseMapper;

    @Override
    public CompositeCourseResource toComposite(CourseResource course, List<EmployeeDto> employees) {
        var composite = courseMapper.toComposite(course, employees);

        var map = employees.stream().collect(Collectors.toMap(EmployeeDto::getId, Function.identity()));

        composite.setEnrolledEmployees(course.getEnrolledEmployees().stream().map(map::get).toList());
        composite.setCompletedEmployees(course.getCompletedEmployees().stream().map(map::get).toList());

        return composite;
    }
}
