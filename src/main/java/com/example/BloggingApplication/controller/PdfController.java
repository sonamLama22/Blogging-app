package com.example.BloggingApplication.controller;

import com.example.BloggingApplication.entity.Comments;
import com.example.BloggingApplication.exception.ResourceNotFoundException;
import com.example.BloggingApplication.service.implementation.CommentServiceImpl;
import com.example.BloggingApplication.service.implementation.PdfServiceImpl;
import com.example.BloggingApplication.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfServiceImpl pdfService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/create-pdf/comments/{userId}")
    public ResponseEntity<InputStreamResource> createPdf(@PathVariable int userId) throws ResourceNotFoundException {
        userService.userExists(userId);
        List<Comments> comments = commentService.getCommentsByUserId(userId);
        ByteArrayInputStream pdf = pdfService.createPdf(comments);
        HttpHeaders httpHeaders = new HttpHeaders(); //contains file information
        httpHeaders.add("Content-Disposition", "inline;file=lcwd.pdg");

        return ResponseEntity.ok().headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
