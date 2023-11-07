package mentoring.coursequeryservice.coursequery;

import mentoring.coursequeryservice.events.CourseHasAnnouncedEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseDocumentMapper {
    CourseDocument toDocument(CourseHasAnnouncedEvent event);
}
