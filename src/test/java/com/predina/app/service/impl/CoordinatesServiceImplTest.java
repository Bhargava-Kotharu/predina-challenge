package com.predina.app.service.impl;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.predina.app.dto.Coordinate;
import com.predina.app.service.FileService;

public class CoordinatesServiceImplTest {

    @Mock
    private FileService fileService;

    @InjectMocks
    private CoordinatesServiceImpl coordinatesService;

    @Before
    public void setup() {
	MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCoordinates() throws IOException {
	Mockito.when(fileService.readCoordinates()).thenReturn(this.getBufferedReaderFromFile());
	List<Coordinate> coordinatesList = coordinatesService.getCoordinates();
	assertNotNull(coordinatesList);
	assertNotEquals(0, coordinatesList.size());

    }

    /**
     * Empty BufferedReaderStream
     * 
     * @throws IOException
     */
    @Test(expected = NullPointerException.class)
    public void testGetCoordinatesForException() throws IOException {
	coordinatesService.getCoordinates();

    }

    /**
     * This method reads the actual file from class path
     * 
     * @return
     * @throws FileNotFoundException
     */
    private BufferedReader getBufferedReaderFromFile() throws FileNotFoundException {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("data/coordinates.csv").getFile());
	InputStream inputFS = new FileInputStream(file);
	BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	return br;
    }
}
