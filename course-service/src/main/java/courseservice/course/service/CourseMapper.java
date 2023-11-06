package courseservice.course.service;

import courseservice.course.dto.CourseDetailsView;
import courseservice.course.dto.CourseResource;
import courseservice.course.dto.AnnounceCourseCommand;
import courseservice.course.model.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDetailsView toView(Course course);

    AnnounceCourseCommand toCommand(CourseResource courseResource);

    CourseResource toResource(CourseDetailsView view);

    List<CourseDetailsView> toViews(List<Course> courses);

    List<CourseResource> toResources(List<CourseDetailsView> allCourses);
}
