package careerservice.saga;

import careerservice.enrollment.model.EnrollCommand;
import careerservice.enrollment.service.EnrollmentService;
import careerservice.enrollment.view.EnrollmentView;
import careerservice.gateway.CourseGateway;
import careerservice.gateway.EnrollRequest;
import lombok.AllArgsConstructor;
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
}
