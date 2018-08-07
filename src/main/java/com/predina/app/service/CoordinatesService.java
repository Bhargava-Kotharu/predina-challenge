package com.predina.app.service;

import java.io.IOException;
import java.util.List;

import com.predina.app.dto.Coordinate;

/**
 * Service class for Coordinates
 * 
 * Created By @author Bhargava Kotharu on 02 August, 2018
 *
 */
public interface CoordinatesService {

    /**
     * This method returns the List<Coordinate> from the coordinates.csv file at
     * classpath
     * 
     * @return List<Coordinate>
     * @throws IOException
     */
    public List<Coordinate> getCoordinates() throws IOException;
}
