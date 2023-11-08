package careerservice.enrollment.service;

import careerservice.enrollment.model.EnrollmentStatus;
import careerservice.enrollment.view.EnrollmentView;
import careerservice.enrollment.model.EnrollCommand;
import careerservice.enrollment.model.Enrollment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EnrollmentService {

    private EnrollmentRepository enrollmentRepository;

    private EnrollmentMapper enrollmentMapper;

    public List<EnrollmentView> findAllByEmployee(long employeeId) {
        return enrollmentMapper.toViews(enrollmentRepository.findAllByEmployeeId(employeeId));
    }

    public EnrollmentView enrollToCourse(EnrollCommand command) {
        var enrolled = enrollmentRepository.findByCourseIdAndEmployeeId(command.getCourseId(), command.getEmployeeId());
        if (enrolled.isEmpty()) {
            var enrollment = Enrollment.enrollToCourse(command);
            enrollmentRepository.save(enrollment);
            return enrollmentMapper.toView(enrollment);
        }
        else {
            return enrollmentMapper.toView(enrolled.get());
        }
    }

    @Transactional
    public void complete(long courseId, long employeeId) {
        enrollmentRepository.findByCourseIdAndEmployeeId(courseId, employeeId).ifPresent(
                Enrollment::complete
        );
    }

    @Transactional
    public void cancel(long courseId, long employeeId) {
        enrollmentRepository.findByCourseIdAndEmployeeId(courseId, employeeId).ifPresent(
                Enrollment::cancel
        );
    }
}
