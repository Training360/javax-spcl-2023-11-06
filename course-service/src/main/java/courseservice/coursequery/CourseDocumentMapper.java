package courseservice.coursequery;

import courseservice.events.CourseHasAnnouncedEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseDocumentMapper {
    CourseDocument toDocument(CourseHasAnnouncedEvent event);
}
