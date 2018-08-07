package com.predina.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * 
 * Created By @author Bhargava Kotharu on 03 August, 2018
 *
 */
@Configuration
@PropertySources({ @PropertySource(name = "application", value = {
	"classpath:application.properties" }, ignoreResourceNotFound = false) })
public class PredinaAppConfiguration {

}
