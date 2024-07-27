package com.vansh.EmailSender.controller.api;

import com.vansh.EmailSender.model.CustomResponse;
import com.vansh.EmailSender.model.EmailRequest;
import com.vansh.EmailSender.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/email")
@CrossOrigin(origins = "http://localhost:5173")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("send")
    public ResponseEntity<CustomResponse> sendEmail(@RequestBody EmailRequest request){
        emailService.sendEmailWithHtml(request.getTo(), request.getSubject(), request.getMessage());
        return ResponseEntity.ok(
                CustomResponse.builder()
                        .message("Email Send Successfully...")
                        .httpStatus(HttpStatus.OK)
                        .success(true)
                        .build()
        );
    }

    @PostMapping("send-with-file")
    public ResponseEntity<CustomResponse> sendWithFile(@RequestPart("emailRequest") EmailRequest emailRequest, @RequestPart("file") MultipartFile multipartFile) throws IOException {
        emailService.sendEmailWithFile(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage(), multipartFile.getInputStream());
        return ResponseEntity.ok(
                CustomResponse.builder()
                        .message("Email Send Successfully...")
                        .httpStatus(HttpStatus.OK)
                        .success(true)
                        .build()
        );
    }
}
