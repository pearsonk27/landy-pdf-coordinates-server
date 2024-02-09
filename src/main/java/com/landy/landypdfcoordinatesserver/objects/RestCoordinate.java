package com.landy.landypdfcoordinatesserver.objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestCoordinate {
    private int id;

    private String name;

    private int pdfId;

    private int x;

    private int y;

    private int convertedX;

    private int convertedY;
}
