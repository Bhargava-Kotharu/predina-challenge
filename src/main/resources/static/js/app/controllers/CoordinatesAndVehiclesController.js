'use strict'

angular.module('predina.controllers').controller("CoordinatesAndVehiclesController", [ "$scope", "$interval", "VechicleLocationsService", "CoordinatesService", "MapService", "CommonService",
		function($scope, $interval, VechicleLocationsService, CoordinatesService, MapService, CommonService) { 
			
			$scope.getCoordinatesAndVehicles = function() {
				VechicleLocationsService.getVehicleLocations(CommonService.calculateTime()).then(function(value) {
					$scope.vehiclesLocation= value.data;
					MapService.loadMap($scope, $scope.vehiclesLocation, 11); 
					MapService.markCoordinates($scope, $scope.vehiclesLocation, false);
					 
					CoordinatesService.getCoordinates().then(function(value) {
					$scope.coordinates= value.data;
					MapService.markCoordinates($scope, $scope.coordinates, true);
					$scope.vehileLocationsTimer();
					$scope.coordinatesTimer();
					}, function(reason) {
						$scope.errorMessage = "Error retrieving Coordinates."; 
					}, function(value) {
						$scope.errorMessage = "No Call back defined";
					}); 
					
					$scope.StartTimer(); 
				}, function(reason) {
					$scope.errorMessage = "Error retrieving vehicle locations."; 
				}, function(value) {
					$scope.errorMessage = "No Call back defined";
				});

			}
			
		  
		  $scope.vehileLocationsTimer = function () { 
		      $scope.Timer = $interval(function () { 
		    	  VechicleLocationsService.getCarCoordinates(CommonService.calculateTime()).then(function(value) {
						$scope.vehiclesLocation= value.data; 
						VechicleLocationsService.deleteAllMarkers();
						VechicleLocationsService.markCoordinates($scope, $scope.vehiclesLocation);
					}, function(reason) {
						$scope.errorMessage = "Error retrieving vehicle locations."; 
					}, function(value) {
						$scope.errorMessage = "No Call back defined";
					});
		      }, 60000);
		  }; 
		   
		 $scope.coordinatesTimer = function ( ) { 
		      $scope.Timer = $interval(function () {
		    	  MapService.markCoordinates($scope, $scope.coordinates, true, true);
		    	  MapService.markCoordinates($scope, $scope.vehiclesLocation, false, false);
		      }, 1000);
		  };

} ]);