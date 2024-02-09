package com.landy.landypdfcoordinatesserver.services;

import org.springframework.stereotype.Service;

import com.landy.landypdfcoordinatesserver.objects.Coordinate;
import com.landy.landypdfcoordinatesserver.objects.RestCoordinate;
import com.landy.landypdfcoordinatesserver.repositories.CoordinateRepository;

@Service
public class CoordinateService {

    private CoordinateRepository coordinateRepository;

    private PdfService pdfService;

    public CoordinateService(CoordinateRepository coordinateRepository, PdfService pdfService) {
        this.coordinateRepository = coordinateRepository;
        this.pdfService = pdfService;
    }

    public Coordinate convertCoordinate(RestCoordinate restCoordinate) {
        Coordinate coordinate = new Coordinate();
        coordinate.setId(restCoordinate.getId());
        coordinate.setName(restCoordinate.getName());
        coordinate.setX(restCoordinate.getX());
        coordinate.setY(restCoordinate.getY());
        coordinate.setConvertedX(restCoordinate.getConvertedX());
        coordinate.setConvertedY(restCoordinate.getConvertedY());
        coordinate.setPdf(pdfService.getPdf(restCoordinate.getPdfId()));
        return coordinate;
    }
    
    public RestCoordinate convertCoordinate(Coordinate coordinate) {
        RestCoordinate restCoordinate = new RestCoordinate();
        restCoordinate.setId(coordinate.getId());
        restCoordinate.setName(coordinate.getName());
        restCoordinate.setX(coordinate.getX());
        restCoordinate.setY(coordinate.getY());
        restCoordinate.setConvertedX(coordinate.getConvertedX());
        restCoordinate.setConvertedY(coordinate.getConvertedY());
        restCoordinate.setPdfId(coordinate.getPdf().getId());
        return restCoordinate;
    }
}
