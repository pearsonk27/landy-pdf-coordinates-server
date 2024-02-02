package com.landy.landypdfcoordinatesserver.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.landy.landypdfcoordinatesserver.objects.Coordinate;
import com.landy.landypdfcoordinatesserver.repositories.CoordinateRepository;

@Controller
public class CoordinateController {

    private CoordinateRepository coordinateRepository;

    public CoordinateController(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }

    @GetMapping("/coordinates/{pdfId}")
    public List<Coordinate> getCoordinatesByPdfId(@PathVariable int pdfId) {
        return coordinateRepository.findByPdfId(pdfId);
    }

    
}
