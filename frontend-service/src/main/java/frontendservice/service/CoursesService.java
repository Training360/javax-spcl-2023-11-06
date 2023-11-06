package frontendservice.service;

import frontendservice.coursegateway.CourseResource;
import frontendservice.coursegateway.CoursesClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private CoursesClient coursesClient;
//
//    private EmployeesService employeesService;
//
//    private CourseMapper courseMapper;
//
    public List<CourseResource> findAllCourses() {
        return coursesClient.findAllCourses();
    }
//
//    public CourseDetailsDto findCourseById(long id) {
//    }
}
