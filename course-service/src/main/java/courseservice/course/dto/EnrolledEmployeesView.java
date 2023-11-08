package courseservice.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrolledEmployeesView {

    private List<Long> employeeIds;

    public boolean containsEmployee(long employeeId) {
        return employeeIds.contains(employeeId);
    }
}
