package courseservice.course.model;

import courseservice.course.dto.AnnounceCourseCommand;
import courseservice.course.dto.EnrollCommand;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    @Lob
    private String syllabus;

    @Column(name = "attendee_limit")
    private int limit;

    @ElementCollection(fetch = FetchType.EAGER)
    List<Long> enrolledEmployees;

    @ElementCollection(fetch = FetchType.EAGER)
    List<Long> completedEmployees;

    public static Course announceCourse(AnnounceCourseCommand command) {
        if (command.getLimit() <= 0) {
            throw new IllegalArgumentException("Limit must be positive!");
        }
        var course = new Course();
        course.setName(command.getName());
        course.setDescription(command.getDescription());
        course.setSyllabus(command.getSyllabus());
        course.setLimit(command.getLimit());
        return course;
    }

    public void enroll(EnrollCommand command) {
        for (var employeeId: command.getEmployeeIds()) {
            boolean found = enrolledEmployees.contains(employeeId);
            if (!found && enrolledEmployees.size() < limit) {
                enrolledEmployees.add(employeeId);
            }
        }
    }
}
