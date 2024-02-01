package com.landy.landypdfcoordinatesserver.services;

import org.springframework.stereotype.Service;

import com.landy.landypdfcoordinatesserver.repositories.CoordinateRepository;

@Service
public class CoordinateService {

    private CoordinateRepository coordinateRepository;

    public CoordinateService(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }
}
