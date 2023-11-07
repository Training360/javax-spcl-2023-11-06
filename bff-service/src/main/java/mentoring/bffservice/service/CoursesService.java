package mentoring.bffservice.service;

import lombok.AllArgsConstructor;
import mentoring.bffservice.coursegateway.CourseResource;
import mentoring.bffservice.coursegateway.CoursesClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private CoursesClient coursesClient;

    private EmployeesService employeesService;

    private CourseMapper courseMapper;

    public List<CourseResource> findAllCourses() {
        return coursesClient.findAllCourses();
    }

    public CompositeCourseResource findCourseById(long id) {
        // Courses Service - kurzusok - employee id
        var course = coursesClient.findCourseById(id);

        // Employees Service - alkalmazottak - employee name
        var employees = employeesService.listEmployees();

        return courseMapper.toComposite(course, employees);
    }
}
