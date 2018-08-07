package com.predina.app.dto;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;

/**
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
public class VehicleLocation implements Serializable {

    private static final long serialVersionUID = -1260591748920493160L;

    @CsvBindByName(column = "Time")
    private String time;

    @CsvBindByName(column = "Vehicle")
    private String vehicle;

    @CsvBindByName(column = "Latitude")
    private Double latitude;

    @CsvBindByName(column = "Longitude")
    private Double longitude;

    public VehicleLocation() {

    }

    public VehicleLocation(String time, String vehicle, Double latitude, Double longitude) {
	this.time = time;
	this.vehicle = vehicle;
	this.longitude = longitude;
	this.latitude = latitude;
    }

    public String getTime() {
	return time;
    }

    public String getVehicle() {
	return vehicle;
    }

    public Double getLatitude() {
	return latitude;
    }

    public Double getLongitude() {
	return longitude;
    }

    public void setTime(String time) {
	this.time = time;
    }

    public void setVehicle(String vehicle) {
	this.vehicle = vehicle;
    }

    public void setLatitude(Double latitude) {
	this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
	this.longitude = longitude;
    }

    @Override
    public String toString() {
	return "VehicleLocation [time=" + time + ", vehicle=" + vehicle + ", latitude=" + latitude + ", longitude="
		+ longitude + "]";
    }

}
