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

import com.predina.app.dto.VehicleLocation;
import com.predina.app.service.VehiclesLocationService;

public class VehicleLocationsControllerTest {

    @InjectMocks
    private VehicleLocationsController vehicleLocationsController;

    @Mock
    private VehiclesLocationService vehicleLocationsService;

    private List<VehicleLocation> vehicleLocationsList;

    private static final String TIME = "05:00";

    private static final String VEHICLE = "ABC123";

    @Before
    public void setup() {
	MockitoAnnotations.initMocks(this);
	vehicleLocationsList = new ArrayList<>();
	vehicleLocationsList.add(new VehicleLocation());
    }

    @Test
    public void testGetVehicleLocations() throws IOException {
	Mockito.when(vehicleLocationsService.getVehiclesLocation()).thenReturn(vehicleLocationsList);
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsController.getVehiclesLocation();
	assertNotNull(vehicleLocationsList);
	assertEquals(1, vehicleLocationsList.size());
    }

    @Test(expected = IOException.class)
    public void testGetCoordinatesForException() throws IOException {
	Mockito.when(vehicleLocationsService.getVehiclesLocation()).thenThrow(new IOException());
	@SuppressWarnings("unused")
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsController.getVehiclesLocation();
    }

    @Test
    public void testGetVehicleLocationsByTime() throws IOException {
	Mockito.when(vehicleLocationsService.getVehiclesLocation()).thenReturn(vehicleLocationsList);
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsController.getVehiclesLocation();
	assertNotNull(vehicleLocationsList);
	assertEquals(1, vehicleLocationsList.size());
    }

    @Test(expected = IOException.class)
    public void testGetCoordinatesForExceptionByTime() throws IOException {
	Mockito.when(vehicleLocationsService.getVehiclesLocationByTime(TIME)).thenThrow(new IOException());
	@SuppressWarnings("unused")
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsController.getVehiclesLocationByTime(TIME);
    }

    @Test
    public void testGetVehicleLocationsByVehicle() throws IOException {
	Mockito.when(vehicleLocationsService.getVehiclesLocationByVehicle(VEHICLE)).thenReturn(vehicleLocationsList);
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsController.getVehiclesLocationByVehicle(VEHICLE);
	assertNotNull(vehicleLocationsList);
	assertEquals(1, vehicleLocationsList.size());
    }

    @Test(expected = IOException.class)
    public void testGetCoordinatesForExceptionByVehicle() throws IOException {
	Mockito.when(vehicleLocationsService.getVehiclesLocationByVehicle(VEHICLE)).thenThrow(new IOException());
	@SuppressWarnings("unused")
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsController.getVehiclesLocationByVehicle(VEHICLE);
    }
}
