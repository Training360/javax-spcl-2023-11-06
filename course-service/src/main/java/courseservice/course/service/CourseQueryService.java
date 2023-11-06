package courseservice.course.service;

import courseservice.course.dto.CourseResource;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseQueryService {

    private CourseRepository courseRepository;

    public List<CourseResource> findCourseResources() {
        return courseRepository.findCourseResources();
    }
}
