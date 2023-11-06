package courseservice.course.controller;

import courseservice.course.dto.CourseResource;
import courseservice.course.service.CourseMapper;
import courseservice.course.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private CourseService courseService;

    private CourseMapper courseMapper;

    @GetMapping
    public List<CourseResource> findAllCourses() {
        return courseMapper.toResources(
                courseService.findAllCourses());
    }

    @GetMapping("/{id}")
    public CourseResource findCourseById(@PathVariable("id") long id) {
        return courseMapper.toResource(
                courseService.findCourseById(id));
    }

    @PostMapping // nem idempotens
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CourseResource> create(@RequestBody CourseResource courseResource, UriComponentsBuilder builder) {
        var command = courseMapper.toCommand(courseResource);
        var view = courseService.announceCourse(command);
        var result = courseMapper.toResource(view);

        return ResponseEntity.created(builder.path("/api/courses/{id}").buildAndExpand(result.getId()).toUri())
                .body(result);
    }


}
