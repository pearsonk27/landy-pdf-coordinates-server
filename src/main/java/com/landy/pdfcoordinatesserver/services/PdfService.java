package com.landy.pdfcoordinatesserver.services;

import java.io.IOException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.landy.pdfcoordinatesserver.objects.Pdf;
import com.landy.pdfcoordinatesserver.repositories.PdfRepository;

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

    public Pdf save(Pdf pdf) {
        return pdfRepository.save(pdf);
    }

    public Pdf getPdf(int id) {
        return pdfRepository.getReferenceById(id);
    }

    public Page<Pdf> getAllPdfs(Pageable pageable) {
        return pdfRepository.findAll(pageable);
    }
}
