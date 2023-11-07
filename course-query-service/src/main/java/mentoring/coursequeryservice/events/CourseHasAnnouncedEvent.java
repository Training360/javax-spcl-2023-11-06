package mentoring.coursequeryservice.events;

import lombok.Data;

@Data
public class CourseHasAnnouncedEvent {

    private Long id;

    private String name;

    private String description;

    private String syllabus;
}
