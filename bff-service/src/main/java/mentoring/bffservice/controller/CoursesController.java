package mentoring.bffservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mentoring.bffservice.coursegateway.CourseResource;
import mentoring.bffservice.service.CoursesService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import mentoring.bffservice.service.CompositeCourseResource;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class CoursesController {

    private CoursesService coursesService;

    @QueryMapping
    public List<CourseResource> courses() {
        return coursesService.findAllCourses();
    }

    @SchemaMapping(typeName = "Course", field = "courseDetails")
    public CompositeCourseResource courseDetails(CourseResource resource) {
        log.info("Call courseDetails: {}", resource);
        return coursesService.findCourseById(resource.getId());
    }

    // http://localhost:8085/api/courses/details?id=1,5,8
}
