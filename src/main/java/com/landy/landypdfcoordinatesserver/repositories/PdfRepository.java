package com.landy.landypdfcoordinatesserver.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.landy.landypdfcoordinatesserver.objects.Pdf;

@Repository
public interface PdfRepository extends PagingAndSortingRepository<Pdf, Integer> {

    Pdf save(Pdf pdf);

    Optional<Pdf> findById(int id);

}
