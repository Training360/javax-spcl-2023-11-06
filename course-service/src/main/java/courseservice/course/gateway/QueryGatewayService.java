package courseservice.course.gateway;

import courseservice.events.CourseHasAnnouncedEvent;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QueryGatewayService {

    private StreamBridge streamBridge;

    @EventListener
    public void handleEvent(CourseHasAnnouncedEvent event) {
        streamBridge.send("course-events-topic", event);
    }
}
