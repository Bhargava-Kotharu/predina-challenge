'use strict'

var predinaApp = angular.module('predina', [ 'ui.bootstrap', 'predina.controllers',
		'predina.services' ]);
predinaApp.constant("CONSTANTS", {
	ROUTE_COORDINATES : "/api/v1/coordinates",
	ROUTE_VEHICLE_LOCATIONS : "/api/v1/vehicleLocations/time"
});