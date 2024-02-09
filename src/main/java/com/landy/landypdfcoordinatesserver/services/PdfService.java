package com.landy.landypdfcoordinatesserver.services;

import java.io.IOException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.landy.landypdfcoordinatesserver.objects.Pdf;
import com.landy.landypdfcoordinatesserver.repositories.PdfRepository;

@Service
public class PdfService {

    private PdfRepository pdfRepository;

    public PdfService(PdfRepository pdfRepository) {
        this.pdfRepository = pdfRepository;
    }

    public Pdf storePdf(MultipartFile file) throws IOException {
        Pdf pdf = new Pdf();
        pdf.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        pdf.setData(file.getBytes());
        pdfRepository.save(pdf);
        return pdf;
    }

    public Pdf getPdf(int id) {
        return pdfRepository.findById(id).get();
    }

    public Page<Pdf> getAllPdfs(Pageable pageable) {
        return pdfRepository.findAll(pageable);
    }
}
