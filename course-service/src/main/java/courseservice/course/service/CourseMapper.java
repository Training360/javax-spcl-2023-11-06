package courseservice.course.service;

import courseservice.course.dto.*;
import courseservice.course.model.Course;
import courseservice.events.CourseHasAnnouncedEvent;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDetailsView toView(Course course);

    AnnounceCourseCommand toCommand(CourseResource courseResource);

    CourseResource toResource(CourseDetailsView view);

    List<CourseDetailsView> toViews(List<Course> courses);

    List<CourseResource> toResources(List<CourseDetailsView> allCourses);

    EnrolledEmployeesResource toResource(EnrolledEmployeesView view);

    CourseHasAnnouncedEvent toEvent(Course course);
}
