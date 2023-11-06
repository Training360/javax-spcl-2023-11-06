package courseservice.course.dto;

import lombok.Data;

import java.util.List;

@Data
public class EnrolledEmployeesResource {

    private List<Long> employeeIds;
}
