package mentoring.coursequeryservice.gateway;

import mentoring.coursequeryservice.events.CourseHasAnnouncedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class CommandEventHandlerConfiguration {

    @Bean
    public Consumer<CourseHasAnnouncedEvent> handleEvent(ApplicationEventPublisher publisher) {
        return publisher::publishEvent;
    }
}
