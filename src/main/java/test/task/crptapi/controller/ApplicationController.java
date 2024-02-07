package test.task.crptapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
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

    @Operation(
            tags = "Документы",
            summary = "Отправка документа в формате JSON",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = DocumentRequest.class
                            )
                    ),
                    required = true
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = Void.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = Void.class
                                    )
                            )
                    )
            }
    )
    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody DocumentRequest documentRequest, HttpServletRequest request) {
        String signature = request.getHeader("X-Signature");
        boolean result = applicationService.create(documentRequest, signature);
        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }
}
