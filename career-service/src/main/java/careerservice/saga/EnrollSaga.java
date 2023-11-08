package careerservice.saga;

import careerservice.enrollment.model.EnrollCommand;
import careerservice.enrollment.service.EnrollmentService;
import careerservice.enrollment.view.EnrollmentView;
import careerservice.gateway.CourseGateway;
import careerservice.gateway.EnrollRequest;
import careerservice.gateway.EnrollResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnrollSaga {

    private EnrollmentService enrollmentService;

    private CourseGateway courseGateway;

    public EnrollmentView enroll(EnrollCommand command) {
        var view = enrollmentService.enrollToCourse(command);
        courseGateway.sendEnrollRequest(new EnrollRequest(command.getEmployeeId(), command.getCourseId()));
        return view;
    }

    @EventListener
    public void handleEnrollResponse(EnrollResponse enrollResponse) {
        if (enrollResponse.getEnrollResult() == EnrollResponse.EnrollResult.SUCCESS) {
            enrollmentService.complete(enrollResponse.getCourseId(), enrollResponse.getEmployeeId());
        }
        else {
            enrollmentService.cancel(enrollResponse.getCourseId(), enrollResponse.getEmployeeId());
        }
    }
}
