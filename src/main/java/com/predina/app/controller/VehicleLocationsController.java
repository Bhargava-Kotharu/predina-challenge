package com.predina.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.predina.app.dto.VehicleLocation;
import com.predina.app.service.VehiclesLocationService;

/**
 * Vehicle Locations Controller
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
@RestController
@RequestMapping("/api/v1/vehicleLocations")
public class VehicleLocationsController {

    @Autowired
    private VehiclesLocationService vehicleLocations;

    /**
     * This method returns the list of all vehiclelocaitons from
     * realtimelocations.csv file at the classpath
     * 
     * @return List<VehicleLocation>
     * @throws IOException
     */
    @GetMapping
    public List<VehicleLocation> getVehiclesLocation() throws IOException {
	return vehicleLocations.getVehiclesLocation();
    }

    /**
     * This method returns the list of all vehiclelocaitons for the given time from
     * realtimelocations.csv file at the classpath
     * 
     * @return List<VehicleLocation>
     * @throws IOException
     */
    @GetMapping("/time/{time}")
    public List<VehicleLocation> getVehiclesLocationByTime(@PathVariable String time) throws IOException {
	return vehicleLocations.getVehiclesLocationByTime(time);
    }

    /**
     * This method returns the list of all vehiclelocaitons for the given vehicle
     * from realtimelocations.csv file at the classpath
     * 
     * @return List<VehicleLocation>
     * @throws IOException
     */
    @GetMapping("/vehicle/{vehicle}")
    public List<VehicleLocation> getVehiclesLocationByVehicle(@PathVariable String vehicle) throws IOException {
	return vehicleLocations.getVehiclesLocationByVehicle(vehicle);
    }
}
