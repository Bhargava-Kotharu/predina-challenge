package com.predina.app.service;

import java.io.IOException;
import java.util.List;

import com.predina.app.dto.Coordinate;

/**
 * 
 * Created By @author Bhargava Kotharu on 02 August, 2018
 *
 */
public interface CoordinatesService {

    public List<Coordinate> getCoordinates() throws IOException;
}
