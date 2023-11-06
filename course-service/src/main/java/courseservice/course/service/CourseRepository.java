package courseservice.course.service;

import courseservice.course.dto.CourseResource;
import courseservice.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select new courseservice.course.dto.CourseResource(c.id, c.name, c.description, c.syllabus, c.limit) from Course c")
    List<CourseResource> findCourseResources();

}
