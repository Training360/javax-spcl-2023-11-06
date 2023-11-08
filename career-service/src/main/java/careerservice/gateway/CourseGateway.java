package careerservice.gateway;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CourseGateway {

    private StreamBridge streamBridge;

    public void sendEnrollRequest(EnrollRequest enrollRequest) {
        streamBridge.send("course-request-topic", enrollRequest);
    }
}
