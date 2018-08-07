package com.predina.app.dto;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;
import com.predina.app.utils.NumberUtils;

/**
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
public class Coordinate implements Serializable {

    private static final long serialVersionUID = 9185440238303922284L;

    @CsvBindByName(column = "Latitude")
    private Double latitude;

    @CsvBindByName(column = "Longitude")
    private Double longitude;

    private Integer severity;

    public Coordinate() {
	this.severity = NumberUtils.getRandomInteger(1, 10);
    }

    public Coordinate(Double latitude, Double longitude, Integer severity) {
	this.latitude = latitude;
	this.longitude = longitude;
	this.severity = NumberUtils.getRandomInteger(1, 10);
    }

    public Double getLatitude() {
	return latitude;
    }

    public Double getLongitude() {
	return longitude;
    }

    public Integer getSeverity() {
	return severity;
    }

    public void setLatitude(Double latitude) {
	this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
	this.longitude = longitude;
    }

    public void setSeverity(Integer severity) {
	this.severity = severity;
    }

    @Override
    public String toString() {
	return "Coordinate [latitude=" + latitude + ", longitude=" + longitude + ", severity=" + severity + "]";
    }

}
