package com.predina.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * Created By @author Bhargava Kotharu on 02 August, 2018
 *
 */
@Controller
@ApiIgnore
public class ViewController {

    @RequestMapping("/swagger-ui")
    public String swaggerUi() {
	return "redirect:swagger-ui.html";
    }
    
    @RequestMapping("/coordinates")
    public String loadCoordinates() {
	return "coordinates";
    }
    
    @RequestMapping("/vehicleLocations")
    public String loadVehicleLocations() {
	return "vehicleLocations";
    }
    
    @RequestMapping("/coordinatesAndVehicles")
    public String loadCoordinatesAndVehicles() {
	return "coordinatesAndVehicles";
    }

}
