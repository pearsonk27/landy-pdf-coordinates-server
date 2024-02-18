package com.landy.pdfcoordinatesserver.objects;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "pdf_id", foreignKey = @ForeignKey(name = "coordinate_pdf_id_fkey"))
    private Pdf pdf;

    private int x;

    private int y;

    private int convertedX;

    private int convertedY;
}
