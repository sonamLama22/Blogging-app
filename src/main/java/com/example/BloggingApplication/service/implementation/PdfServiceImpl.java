package com.example.BloggingApplication.service.implementation;

import com.example.BloggingApplication.entity.Comments;
import com.example.BloggingApplication.service.PdfService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfServiceImpl implements PdfService {

    private Logger logger = LoggerFactory.getLogger(PdfServiceImpl.class);

    @Override
    public ByteArrayInputStream createPdf(List<Comments> comments) {
        logger.info("Generate PDF");
        String title = "Blogging Application";

        ByteArrayOutputStream output = new ByteArrayOutputStream(); // write data in byte array form.

        Document document = new Document();
        PdfWriter.getInstance(document,output); //write document to output stream.

        document.open();

        // Add heading
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20 );
        Paragraph heading = new Paragraph(title, titleFont);
        heading.setAlignment(Element.ALIGN_CENTER);
        heading.setSpacingAfter(20);
        document.add(heading);

        // Add data
        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 14);
        Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
        for(Comments c : comments){
            String OP = c.getPost().getUser().getName();
            String postTitle = OP.toUpperCase() + ": "+ c.getPost().getTitle();
            Paragraph p2 = new Paragraph(postTitle, boldFont);
            p2.setSpacingAfter(10);
            document.add(p2);
            
            String post = c.getPost().getContent();
            Paragraph p3 = new Paragraph(post, contentFont);
            p3.setSpacingAfter(10);
            document.add(p3);
            
            String commenter = c.getUser().getName();
            String comment = commenter.toUpperCase() + ": " + c.getComment();
            Paragraph p5 = new Paragraph(comment, contentFont);
            p5.setSpacingAfter(10);
            document.add(p5);
        }

        document.close();

        return new ByteArrayInputStream(output.toByteArray()); //converts output stream data to array to read the file.
    }
}
