package hackathon.controller;

import hackathon.exception.TestDataEntityNotFoundException;
import hackathon.model.TestData;
import hackathon.model.TestResponse;
import hackathon.processor.TestDataProcessor;
import hackathon.processor.TestProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * test controller for application
 *
 * @author Dmitriy
 * @since 28.05.2019
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private final TestProcessor testProcessor;
    private final TestDataProcessor testDataProcessor;

    public TestController(TestProcessor testProcessor, TestDataProcessor testDataProcessor) {
        this.testProcessor = testProcessor;
        this.testDataProcessor = testDataProcessor;
    }

    @GetMapping("/hi")
    public String sayHi() {
        return testProcessor.getHiMessage();
    }

    @GetMapping(value = "/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<TestResponse> ping() {
        return ResponseEntity.ok(testProcessor.ping());
    }

    @GetMapping("/data/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<TestData> getTestData(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(testDataProcessor.findDataById(id));
        } catch (TestDataEntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
