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

    public File readCoordinatesAsFile() throws IOException;

    public File readLocationsAsFile() throws IOException;

    public BufferedReader readCoordinates() throws IOException;

    public BufferedReader readLocations() throws IOException;
}
