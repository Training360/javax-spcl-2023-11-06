package frontendservice.coursegateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface CoursesClient {

    @GetExchange("/api/courses")
    List<CourseResource> findAllCourses();

    @GetExchange("/api/courses/{id}")
    CourseResource findCourseById(@PathVariable("id") long id);

}
