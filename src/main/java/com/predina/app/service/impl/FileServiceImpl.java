package com.predina.app.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.predina.app.service.FileService;

import static com.predina.app.constants.Constants.*;

/**
 * File Service for reading files from classpath
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
@Service
public class FileServiceImpl implements FileService {

    /** {@inheritDoc} */
    @Override
    public File readCoordinatesAsFile() throws IOException {
	return ResourceUtils.getFile(CLASSPATH_KEY + COORDINATES_FILE_PATH);
    }

    /** {@inheritDoc} */
    @Override
    public File readLocationsAsFile() throws IOException {
	return ResourceUtils.getFile(CLASSPATH_KEY + VEHICLE_LOCATIONS_FILE_PATH);
    }

    /** {@inheritDoc} */
    @Override
    public BufferedReader readCoordinates() throws IOException {
	InputStream inputStream = getClass().getResourceAsStream(COORDINATES_FILE_PATH);
	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	return reader;
    }

    /** {@inheritDoc} */
    @Override
    public BufferedReader readLocations() throws IOException {
	InputStream inputStream = getClass().getResourceAsStream(VEHICLE_LOCATIONS_FILE_PATH);
	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	return reader;
    }

}
