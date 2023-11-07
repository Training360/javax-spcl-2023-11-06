package mentoring.bffservice.service;

import mentoring.bffservice.coursegateway.CourseResource;
import mentoring.bffservice.employeegateway.EmployeeDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
@DecoratedWith(CourseMapperDecorator.class)
public interface CourseMapper {

    @Mapping(target = "enrolledEmployees", ignore = true)
    @Mapping(target = "completedEmployees", ignore = true)
    CompositeCourseResource toComposite(CourseResource course, List<EmployeeDto> employees);

}
