package com.example.BloggingApplication.service;


import com.example.BloggingApplication.entity.Comments;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface PdfService {
    public ByteArrayInputStream createPdf(List<Comments> comments) ;
}
