package com.predina.app.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
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

    @Override
    public List<VehicleLocation> getVehiclesLocation() throws IOException {
	List<VehicleLocation> inputList = new ArrayList<VehicleLocation>();
	try {
	    BufferedReader br = fileService.readLocations();
	    inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
	    System.out.println(inputList.size());
	    br.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return inputList;
    }

    @Override
    public List<VehicleLocation> getVehiclesLocationByTime(String time) throws IOException {
	List<VehicleLocation> inputList = new ArrayList<VehicleLocation>();
	try {
	    BufferedReader br = fileService.readLocations();
	    inputList = br.lines().skip(1).map(mapToItem).filter(t -> t.getTime().equalsIgnoreCase(time))
		    .collect(Collectors.toList());
	    System.out.println(inputList.size());
	    br.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return inputList;
    }

    @Override
    public List<VehicleLocation> getVehiclesLocationByVehicle(String time) throws IOException {
	return this.getVehiclesLocation().stream().filter(t -> t.getVehicle().equalsIgnoreCase(time))
		.collect(Collectors.toList());
    }

    /**
     * Common method to parse csv file to return vehicle locations
     * 
     * @return CsvToBean<VehicleLocation>
     * @throws FileNotFoundException
     * @throws IOException
     */
    private CsvToBean<VehicleLocation> getVechileLocations() throws FileNotFoundException, IOException {
	CSVReader csvReader = new CSVReader(fileService.readLocations());
	HeaderColumnNameMappingStrategy<VehicleLocation> mappingStrategy = new HeaderColumnNameMappingStrategy<>();
	mappingStrategy.setType(VehicleLocation.class);
	CsvToBean<VehicleLocation> ctb = new CsvToBean<>();
	ctb.setMappingStrategy(mappingStrategy);
	ctb.setCsvReader(csvReader);
	return ctb;
    }

    private Function<String, VehicleLocation> mapToItem = (line) -> {
	String[] p = line.split(",");// a CSV has comma separated lines
	VehicleLocation item = new VehicleLocation(p[0], p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]));

	return item;
    };

}
