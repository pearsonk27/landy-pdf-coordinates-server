package com.landy.pdfcoordinatesserver.feigns;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.landy.pdfcoordinatesserver.objects.RestCoordinate;

@FeignClient(name = "learner", url = "${learner.url}")
public interface LearnerFeignClient {

    @PostMapping("/coordinates")
    List<RestCoordinate> getExtrapolatedCoordinates(List<RestCoordinate> coordinates);
}
