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
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
@RestController
@RequestMapping("/api/v1/vehicleLocations")
public class VehicleLocationsController {

    @Autowired
    private VehiclesLocationService vehicleLocations;

    @GetMapping
    public List<VehicleLocation> getVehiclesLocation() throws IOException {
	return vehicleLocations.getVehiclesLocation();
    }

    @GetMapping("/time/{time}")
    public List<VehicleLocation> getVehiclesLocationByTime(@PathVariable String time) throws IOException {
	System.out.println("time is " + time);
	return vehicleLocations.getVehiclesLocationByTime(time);
    }

    @GetMapping("/vehicle/{vehicle}")
    public List<VehicleLocation> getVehiclesLocationByVehicle(@PathVariable String vehicle) throws IOException {
	return vehicleLocations.getVehiclesLocationByVehicle(vehicle);
    }
}
