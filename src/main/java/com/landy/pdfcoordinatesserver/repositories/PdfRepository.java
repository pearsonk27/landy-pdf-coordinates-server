package com.landy.pdfcoordinatesserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.landy.pdfcoordinatesserver.objects.Pdf;

@Repository
public interface PdfRepository extends JpaRepository<Pdf, Integer> {

    Pdf save(Pdf pdf);

}
