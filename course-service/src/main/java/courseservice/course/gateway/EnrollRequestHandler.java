package courseservice.course.gateway;

import courseservice.course.dto.EnrollCommand;
import courseservice.course.service.CourseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;

@Configuration
public class EnrollRequestHandler {

    @Bean
    public Function<EnrollRequest, EnrollResponse> handleEnrollRequest(CourseService courseService) {
        return request -> {
            var view = courseService.enroll(new EnrollCommand(request.getCourseId(), List.of(request.getEmployeeId())));
            if (view.containsEmployee(request.getEmployeeId())) {
                return EnrollResponse.successResponse(request.getEmployeeId(), request.getCourseId());
            }
            else {
                return EnrollResponse.errorResponse(request.getEmployeeId(), request.getCourseId());
            }
        };
    }
}
