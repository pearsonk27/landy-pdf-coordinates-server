package com.landy.landypdfcoordinatesserver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.landy.landypdfcoordinatesserver.objects.Coordinate;

public interface CoordinateRepository extends JpaRepository<Coordinate, Integer> {

    List<Coordinate> findByPdfId(int pdfId);
}
