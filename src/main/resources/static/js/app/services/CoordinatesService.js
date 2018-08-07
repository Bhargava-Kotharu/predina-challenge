'use strict'

angular.module('predina.services').service('CoordinatesService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			
			service.getCoordinates = function(userId) {
				var url = CONSTANTS.ROUTE_COORDINATES;
				return $http.get(url);
			}
			
			return service;
		} ]);