package com.landy.pdfcoordinatesserver.objects;

import lombok.Data;

@Data
public class RestCoordinate {
    private int id;

    private String name;

    private int pdfId;

    private int x;

    private int y;

    private int convertedX;

    private int convertedY;
}
