package com.predina.app.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.predina.app.service.FileService;

/**
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public File readCoordinatesAsFile() throws IOException {
	return ResourceUtils.getFile("classpath:data/coordinates.csv");
    }

    @Override
    public File readLocationsAsFile() throws IOException {
	return ResourceUtils.getFile("classpath:data/realtimelocation.csv");
    }

    @Override
    public BufferedReader readCoordinates() throws IOException {
	InputStream inputStream = getClass().getResourceAsStream("/data/coordinates.csv");
	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	return reader;
    }

    @Override
    public BufferedReader readLocations() throws IOException {
	InputStream inputStream = getClass().getResourceAsStream("/data/realtimelocation.csv");
	BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	return reader;
    }

}
