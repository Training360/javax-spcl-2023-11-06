package courseservice.coursequery;

import courseservice.events.CourseHasAnnouncedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CourseDocumentService {

    CourseDocumentRepository repository;

    CourseDocumentMapper mapper;

    @EventListener
    public void handleEvent(CourseHasAnnouncedEvent event) {
        log.info("Event has come: {}", event);

        var document = mapper.toDocument(event);
        repository.save(document);
    }

    public List<CourseDocument> findByWord(String word) {
        return repository.findByWord(word);
    }
}
