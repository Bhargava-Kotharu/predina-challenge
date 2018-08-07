package com.predina.app.service;

import java.io.IOException;
import java.util.List;

import com.predina.app.dto.VehicleLocation;

/**
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
public interface VehiclesLocationService {

    public List<VehicleLocation> getVehiclesLocation() throws IOException;

    public List<VehicleLocation> getVehiclesLocationByTime(String time) throws IOException;

    public List<VehicleLocation> getVehiclesLocationByVehicle(String time) throws IOException;
}
