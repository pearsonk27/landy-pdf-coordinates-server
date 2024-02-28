package com.landy.pdfcoordinatesserver.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.landy.pdfcoordinatesserver.objects.Coordinate;
import com.landy.pdfcoordinatesserver.objects.RestCoordinate;
import com.landy.pdfcoordinatesserver.repositories.CoordinateRepository;
import com.landy.pdfcoordinatesserver.services.CoordinateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CoordinateController {

    private CoordinateRepository coordinateRepository;

    private CoordinateService coordinateService;

    public CoordinateController(CoordinateRepository coordinateRepository, CoordinateService coordinateService) {
        this.coordinateRepository = coordinateRepository;
        this.coordinateService = coordinateService;
    }

    @GetMapping("/coordinates/{pdfId}")
    public List<RestCoordinate> getCoordinatesByPdfId(@PathVariable int pdfId) {
        return coordinateRepository.findByPdfId(pdfId).stream().map(c -> coordinateService.convertCoordinate(c)).toList();
    }

    @CrossOrigin
    @PostMapping("/coordinates")
    public RestCoordinate addCoordinate(@RequestBody RestCoordinate restCoordinate) {
        return coordinateService.convertCoordinate(coordinateRepository.save(coordinateService.convertCoordinate(restCoordinate)));
    }

    @CrossOrigin
    @DeleteMapping("/coordinates/{coordiniteId}")
    public ResponseEntity<RestCoordinate> deleteCoordinate(@PathVariable int coordiniteId) {
        try {
            Coordinate coordinate = coordinateRepository.getReferenceById(coordiniteId);
            RestCoordinate restCoordinate = coordinateService.convertCoordinate(coordinate);
            coordinateRepository.deleteById(coordiniteId);
            return ResponseEntity.status(HttpStatus.OK).body(restCoordinate);
        } catch (Exception e) {
            log.error("Deletion failed", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RestCoordinate());
        }
    }
}
