package test.task.crptapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.task.crptapi.model.DocumentRequest;
import test.task.crptapi.service.impl.ApplicationServiceImpl;

@RestController
@RequestMapping(path = "/api/v3/lk/documents")
public class ApplicationController {
    private final ApplicationServiceImpl applicationService;

    public ApplicationController(ApplicationServiceImpl applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody DocumentRequest documentRequest) {
        boolean result = applicationService.createXMLFile(documentRequest);
        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }
}
