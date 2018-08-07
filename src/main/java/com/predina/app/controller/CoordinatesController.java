package com.predina.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.predina.app.dto.Coordinate;
import com.predina.app.service.CoordinatesService;

/**
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
@RestController
@RequestMapping("/api/v1/coordinates")
public class CoordinatesController {

    @Autowired
    private CoordinatesService coordinatesService;

    @GetMapping
    public List<Coordinate> getCoordinates() throws IOException {
	return coordinatesService.getCoordinates();
    }

}
