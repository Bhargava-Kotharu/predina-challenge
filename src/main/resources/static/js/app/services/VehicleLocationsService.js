'use strict'

angular.module('predina.services').service('VechicleLocationsService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			
			service.getVehicleLocations = function(time) {
				if(!time){
					var url = CONSTANTS.ROUTE_VEHICLE_LOCATIONS+"/"+time;
				}else{
				var url = CONSTANTS.ROUTE_VEHICLE_LOCATIONS+"/"+time;
			}
				return $http.get(url);
			}
			 
			return service;
		} ]);