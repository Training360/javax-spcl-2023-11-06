package careerservice.gateway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollResponse {

    public enum EnrollResult {SUCCESS, FULL}

    private long employeeId;

    private long courseId;

    private EnrollResult enrollResult;

    public static EnrollResponse successResponse(long employeeId, long courseId) {
        return new EnrollResponse(employeeId, courseId, EnrollResult.SUCCESS);
    }

    public static EnrollResponse errorResponse(long employeeId, long courseId) {
        return new EnrollResponse(employeeId, courseId, EnrollResult.FULL);
    }
}
