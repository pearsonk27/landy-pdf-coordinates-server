package com.landy.landypdfcoordinatesserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.landy.landypdfcoordinatesserver.objects.Pdf;

@Repository
public interface PdfRepository extends JpaRepository<Pdf, Integer> {

    Pdf save(Pdf pdf);

}
