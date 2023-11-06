package courseservice.coursequery;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course-documents")
@AllArgsConstructor
public class CourseQueryController {

    private CourseDocumentService service;

    @GetMapping
    public List<CourseDocument> findByWord(@RequestParam String word) {
        return service.findByWord(word);
    }
}
