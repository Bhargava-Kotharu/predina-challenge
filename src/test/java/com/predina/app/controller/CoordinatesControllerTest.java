package com.predina.app.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.predina.app.dto.Coordinate;
import com.predina.app.service.CoordinatesService;

public class CoordinatesControllerTest {

    @InjectMocks
    private CoordinatesController coordinatesController;

    @Mock
    private CoordinatesService coordinatesService;

    private List<Coordinate> coordinatesList;

    @Before
    public void setup() {
	MockitoAnnotations.initMocks(this);
	coordinatesList = new ArrayList<>();
	coordinatesList.add(new Coordinate());
    }

    @Test
    public void testGetCoordinates() throws IOException {
	Mockito.when(coordinatesService.getCoordinates()).thenReturn(coordinatesList);
	List<Coordinate> coordinatesList = coordinatesController.getCoordinates();
	assertNotNull(coordinatesList);
	assertEquals(1, coordinatesList.size());
    }

    @Test(expected = IOException.class)
    public void testGetCoordinatesForException() throws IOException {
	Mockito.when(coordinatesService.getCoordinates()).thenThrow(new IOException());
	@SuppressWarnings("unused")
	List<Coordinate> coordinatesList = coordinatesController.getCoordinates();
    }
}
