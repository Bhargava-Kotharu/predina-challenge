package com.predina.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * View Controller - This provides the path to the htmls. Without the use of
 * this controller, we can also put the static html files in webapp folder.
 * 
 * Created By @author Bhargava Kotharu on 02 August, 2018
 *
 */
@Controller
@ApiIgnore
public class ViewController {

    /**
     * Renders Swagger UI
     * 
     * @return String
     */
    @RequestMapping("/swagger-ui")
    public String swaggerUi() {
	return "redirect:swagger-ui.html";
    }

    /**
     * Renders coordinates.html
     * 
     * @return String
     */
    @RequestMapping("/coordinates")
    public String loadCoordinates() {
	return "coordinates";
    }

    /**
     * Renders vehicleLocations.html
     * 
     * @return String
     */
    @RequestMapping("/vehicleLocations")
    public String loadVehicleLocations() {
	return "vehicleLocations";
    }

    /**
     * Renders coordinatesAndVehicles.html
     * 
     * @return String
     */
    @RequestMapping("/coordinatesAndVehicles")
    public String loadCoordinatesAndVehicles() {
	return "coordinatesAndVehicles";
    }

}
