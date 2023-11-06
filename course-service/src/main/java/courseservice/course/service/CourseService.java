package courseservice.course.service;

import courseservice.course.dto.CourseDetailsView;
import courseservice.course.dto.AnnounceCourseCommand;
import courseservice.course.dto.EnrollCommand;
import courseservice.course.model.Course;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseService {

    private CourseRepository courseRepository;

    private CourseMapper courseMapper;

    public CourseDetailsView announceCourse(AnnounceCourseCommand command) {
        var course = Course.announceCourse(command);
        courseRepository.save(course);
        return courseMapper.toView(course);
    }

    public CourseDetailsView findCourseById(long id) {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: %s".formatted(id)));
        return courseMapper.toView(course);
    }

    public List<CourseDetailsView> findAllCourses() {
        var courses = courseRepository.findAll();
        return courseMapper.toViews(courses);
    }

    public Object enroll(EnrollCommand command) {
        // Ha az adott alkalmazott már jelentkezett, ne jelentkezzen még egyszer
        // A limitnél nem jelentkezhet több alkalmazott
        var course = courseRepository.findById(command.getCourseId()).orElseThrow(() -> new IllegalArgumentException("Course not found with id: %s".formatted(command.getCourseId())));
        course.enroll(command);

        return
    }
}
