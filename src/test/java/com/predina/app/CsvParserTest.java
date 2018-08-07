package com.predina.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

import com.predina.app.dto.VehicleLocation;

public class CsvParserTest {

    public void test() {
	List<VehicleLocation> inputList = new ArrayList<VehicleLocation>();
	try {
	    String thisLine;
	    ClassLoader classLoader = getClass().getClassLoader();
	    File file = new File(classLoader.getResource("data/realtimelocation.csv").getFile());
	    // File inputF = new File("resources/data/realtimelocation.csv");
	    InputStream inputFS = new FileInputStream(file);
	    BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	    int counter = 0;
	    while ((thisLine = br.readLine()) != null) { // while loop begins here
		System.out.println(thisLine);
		counter++;
	    }
	    System.out.println(counter);
	    br.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void test2() {
	List<VehicleLocation> inputList = new ArrayList<VehicleLocation>();
	try {
	    ClassLoader classLoader = getClass().getClassLoader();
	    File file = new File(classLoader.getResource("data/realtimelocation.csv").getFile());
	    // File inputF = new File("resources/data/realtimelocation.csv");
	    InputStream inputFS = new FileInputStream(file);
	    BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	    inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
	    System.out.println(inputList.size());
	    br.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    private Function<String, VehicleLocation> mapToItem = (line) -> {
	String[] p = line.split(",");// a CSV has comma separated lines
	VehicleLocation item = new VehicleLocation(p[0], p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]));

	return item;
    };

    public static void main(String[] args) {
	new CsvParserTest().test2();
    }
}
