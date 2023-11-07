package mentoring.bffservice.controller;

import lombok.AllArgsConstructor;
import mentoring.bffservice.coursegateway.CourseResource;
import mentoring.bffservice.service.CoursesService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CoursesController {

    private CoursesService coursesService;

    @QueryMapping
    public List<CourseResource> courses() {
        return coursesService.findAllCourses();
    }
}
