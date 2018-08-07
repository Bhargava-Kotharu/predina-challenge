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
						alert('ss');
						MapService.markCoordinates($scope, $scope.coordinates, true);
						$scope.StartTimer();
					}, function(reason) {
						console.log("Error retrieving Coordinates.");
					}, function(value) {
						console.log("No Call back defined");
					}); 
					
					$scope.StartTimer(); 
				}, function(reason) {
					console.log("Error Occured retrieving Vehicle Locations.");
				}, function(value) {
					console.log("No Call back defined");
				});

			}
			
		 //Timer start for every minute.
		  $scope.StartTimer = function () { 
		      $scope.Timer = $interval(function () { 
		    	  VechicleLocationsService.getCarCoordinates(CommonService.calculateTime()).then(function(value) {
						$scope.vehiclesLocation= value.data; 
						VechicleLocationsService.deleteAllMarkers();
						VechicleLocationsService.markCoordinates($scope, $scope.vehiclesLocation);
					}, function(reason) {
						console.log("Error Occured retrieving Vehicle Locations.");
					}, function(value) {
						console.log("No Call back defined");
					});
		      }, 60000);
		  }; 

} ]);