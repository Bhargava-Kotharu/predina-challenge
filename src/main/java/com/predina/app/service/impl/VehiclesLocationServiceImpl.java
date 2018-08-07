package com.predina.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.predina.app.dto.VehicleLocation;
import com.predina.app.service.FileService;
import com.predina.app.service.VehiclesLocationService;

/**
 * 
 * Created By @author Bhargava Kotharu on 02 August, 2018
 * 
 * Vehicle Locations Service Implementation
 *
 */
@Service
public class VehiclesLocationServiceImpl implements VehiclesLocationService {

    @Autowired
    private FileService fileService;

    /** {@inheritDoc} */
    @Override
    public List<VehicleLocation> getVehiclesLocation() throws IOException {
	List<VehicleLocation> vehicleLocationsList = new ArrayList<VehicleLocation>();
	try {
	    BufferedReader br = fileService.readLocations();

	    Function<String, VehicleLocation> mapToItem = (line) -> {
		String[] p = line.split(",");
		VehicleLocation item = new VehicleLocation(p[0], p[1], Double.parseDouble(p[2]),
			Double.parseDouble(p[3]));
		return item;
	    };

	    vehicleLocationsList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
	    br.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return vehicleLocationsList;
    }

    /** {@inheritDoc} */
    @Override
    public List<VehicleLocation> getVehiclesLocationByTime(String time) throws IOException {
	return this.getVehiclesLocation().stream().filter(t -> t.getTime().equalsIgnoreCase(time))
		.collect(Collectors.toList());
    }

    /** {@inheritDoc} */
    @Override
    public List<VehicleLocation> getVehiclesLocationByVehicle(String vehicle) throws IOException {
	return this.getVehiclesLocation().stream().filter(t -> t.getVehicle().equalsIgnoreCase(vehicle))
		.collect(Collectors.toList());
    }

}
