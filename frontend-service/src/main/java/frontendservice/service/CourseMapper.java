package frontendservice.service;

import ch.qos.logback.core.model.ComponentModel;
import frontendservice.coursegateway.CourseResource;
import frontendservice.employeegateway.EmployeeDto;
import org.apache.catalina.webresources.CachedResource;
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
