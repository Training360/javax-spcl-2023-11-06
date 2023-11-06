package courseservice.course.service;

import courseservice.course.dto.CourseResource;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseQueryService {

    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public List<CourseResource> findCourseResources() {
        return courseRepository.findCourseResources();
    }
}
