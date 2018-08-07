package com.predina.app.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.predina.app.dto.Coordinate;
import com.predina.app.service.CoordinatesService;
import com.predina.app.service.FileService;

/**
 * 
 * Created By @author Bhargava Kotharu on 02 August, 2018
 *
 */
@Service
public class CoordinatesServiceImpl implements CoordinatesService {

    @Autowired
    private FileService fileService;

    /** {@inheritDoc} */
    @Override
    public List<Coordinate> getCoordinates() throws IOException {
	CSVReader csvReader = new CSVReader(fileService.readCoordinates());
	HeaderColumnNameMappingStrategy<Coordinate> mappingStrategy = new HeaderColumnNameMappingStrategy<>();
	mappingStrategy.setType(Coordinate.class);
	CsvToBean<Coordinate> ctb = new CsvToBean<>();
	ctb.setMappingStrategy(mappingStrategy);
	ctb.setCsvReader(csvReader);
	return ctb.parse();
    }

}
