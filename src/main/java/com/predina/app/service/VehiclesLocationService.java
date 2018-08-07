package com.predina.app.service;

import java.io.IOException;
import java.util.List;

import com.predina.app.dto.VehicleLocation;

/**
 * Service Class for Vehicle Locations
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
public interface VehiclesLocationService {

    /**
     * This method returns the List<VehicleLocation> from the coordinates.csv file
     * at classpath
     * 
     * @return List<VehicleLocation>
     * @throws IOException
     */
    public List<VehicleLocation> getVehiclesLocation() throws IOException;

    /**
     * This method returns the List<VehicleLocation> matching the given time from
     * the coordinates.csv file at classpath
     * 
     * @return List<VehicleLocation>
     * @throws IOException
     */
    public List<VehicleLocation> getVehiclesLocationByTime(String time) throws IOException;

    /**
     * This method returns the List<VehicleLocation> matching the given vehicle from
     * the coordinates.csv file at classpath
     * 
     * @return List<VehicleLocation>
     * @throws IOException
     */
    public List<VehicleLocation> getVehiclesLocationByVehicle(String time) throws IOException;
}
