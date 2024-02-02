package com.landy.landypdfcoordinatesserver.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.landy.landypdfcoordinatesserver.objects.Pdf;
import com.landy.landypdfcoordinatesserver.services.PdfService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PdfController {

    private PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Pdf> uploadPdf(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pdfService.storePdf(file));
        } catch (Exception e) {
            log.error("Could not upload the file: " + file.getOriginalFilename() + "!", e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new Pdf());
        }
    }

    @GetMapping("pdfs")
    public ResponseEntity<List<Pdf>> getPdfs() {
        return ResponseEntity.status(HttpStatus.OK).body(pdfService.getAllPdfs());
    }

    @GetMapping("pdfs/{id}")
    public ResponseEntity<Pdf> getPdf(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(pdfService.getPdf(id));
    }
}
