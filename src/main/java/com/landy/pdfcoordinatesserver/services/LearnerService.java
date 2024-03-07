package com.landy.pdfcoordinatesserver.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.landy.pdfcoordinatesserver.feigns.LearnerFeignClient;
import com.landy.pdfcoordinatesserver.objects.RestCoordinate;

@Service
public class LearnerService {

    private LearnerFeignClient learnerFeignClient;

    public LearnerService(LearnerFeignClient learnerFeignClient) {
        this.learnerFeignClient = learnerFeignClient;
    }

    public List<RestCoordinate> getExtrapolatedCoordinates(List<RestCoordinate> coordinates) {
        return learnerFeignClient.getExtrapolatedCoordinates(coordinates);
    }
}
