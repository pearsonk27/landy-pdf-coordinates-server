package com.landy.landypdfcoordinatesserver.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin
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
    public ResponseEntity<Page<Pdf>> getPdfs(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            @RequestParam(defaultValue = "id,desc") String[] sort) {
        try {
            List<Order> orders = new ArrayList<Order>();

            if (sort[0].contains(",")) {
                // will sort more than 2 fields
                // sortOrder="field, direction"
                for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Order(Direction.fromString(_sort[1]), _sort[0]));
                }
            } else {
                // sort=[field, direction]
                orders.add(new Order(Direction.fromString(sort[1]), sort[0]));
            }
            Pageable pageable = PageRequest.of(page, size, Sort.by(orders));
            return ResponseEntity.status(HttpStatus.OK).body(pdfService.getAllPdfs(pageable));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("pdfs/{id}")
    public ResponseEntity<Pdf> getPdf(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(pdfService.getPdf(id));
    }
}
