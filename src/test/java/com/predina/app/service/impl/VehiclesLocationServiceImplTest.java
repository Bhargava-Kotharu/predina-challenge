package com.predina.app.service.impl;

import static org.junit.Assert.assertEquals;
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
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.predina.app.dto.VehicleLocation;
import com.predina.app.service.FileService;

public class VehiclesLocationServiceImplTest {

    @Mock
    private FileService fileService;

    @InjectMocks
    private VehiclesLocationServiceImpl vehicleLocationsService;

    public Function<String, VehicleLocation> mapToItem = (line) -> {
	String[] p = line.split(",");
	VehicleLocation item = new VehicleLocation(p[0], p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]));
	return item;
    };

    private static final String TIME = "5:00";

    private static final String VEHICLE = "Vehicle_1289";

    @Before
    public void setup() throws NoSuchFieldException, SecurityException {
	MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetVehicleLocationsByTime() throws IOException {
	Mockito.when(fileService.readLocations()).thenReturn(this.getBufferedReaderFromFile());
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsService.getVehiclesLocationByTime(TIME);
	assertNotNull(vehicleLocationsList);
	assertNotEquals(0, vehicleLocationsList.size());
    }

    /**
     * Empty BufferedReaderStream
     * 
     * @throws IOException
     */
    @Test
    public void testGetCoordinatesByTimeForException() throws IOException {
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsService.getVehiclesLocationByTime(TIME);
	assertEquals(0, vehicleLocationsList.size());
    }

    @Test
    public void testGetVehicleLocationsByVehicle() throws IOException {
	Mockito.when(fileService.readLocations()).thenReturn(this.getBufferedReaderFromFile());
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsService.getVehiclesLocationByVehicle(VEHICLE);
	assertNotNull(vehicleLocationsList);
	assertNotEquals(0, vehicleLocationsList.size());
    }

    /**
     * Empty BufferedReaderStream
     * 
     * @throws IOException
     */
    @Test
    public void testGetCoordinatesByVehicleForException() throws IOException {
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsService.getVehiclesLocationByVehicle(VEHICLE);
	assertEquals(0, vehicleLocationsList.size());
    }

    @Test
    public void testGetVehicleLocations() throws IOException {
	Mockito.when(fileService.readLocations()).thenReturn(this.getBufferedReaderFromFile());
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsService.getVehiclesLocation();
	assertNotNull(vehicleLocationsList);
	assertNotEquals(0, vehicleLocationsList.size());
    }

    /**
     * Empty BufferedReaderStream
     * 
     * @throws IOException
     */
    @Test
    public void testGetCoordinatesForException() throws IOException {
	List<VehicleLocation> vehicleLocationsList = vehicleLocationsService.getVehiclesLocation();
	assertEquals(0, vehicleLocationsList.size());
    }

    /**
     * This method reads the actual file from class path
     * 
     * @return
     * @throws FileNotFoundException
     */
    private BufferedReader getBufferedReaderFromFile() throws FileNotFoundException {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("data/realtimelocation_small.csv").getFile());
	InputStream inputFS = new FileInputStream(file);
	BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	return br;
    }
}
