package com.predina.app.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
public interface FileService {

    /**
     * This method reads the coordinates.csv as file
     * 
     * @return File
     * @throws IOException
     */
    public File readCoordinatesAsFile() throws IOException;

    /**
     * This method reads the realtimelocations.csv as file
     * 
     * @return File
     * @throws IOException
     */
    public File readLocationsAsFile() throws IOException;

    /**
     * This method reads the coordinates.csv file and returns as BufferedReader
     * 
     * @return BufferedReader
     * @throws IOException
     */
    public BufferedReader readCoordinates() throws IOException;

    /**
     * This method reads the realtimelocations.csv file and returns as
     * BufferedReader
     * 
     * @return BufferedReader
     * @throws IOException
     */
    public BufferedReader readLocations() throws IOException;
}
