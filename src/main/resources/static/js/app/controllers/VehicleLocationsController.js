'use strict'

angular.module('predina.controllers').controller("VehicleLocationsController", [ "$scope", "$interval", "VechicleLocationsService", "MapService", "CommonService",
		function($scope, $interval, VechicleLocationsService, MapService, CommonService) { 
			
		$scope.getVehicleLocations = function() {
				$scope.executeService(true);
		} 
			
		 $scope.vehicleLocationsTimer = function () { 
		      $scope.Timer = $interval(function () { 
		    	  $scope.executeService(false);
		      }, 60000);
		  }; 
		  
		$scope.executeService = function(startTimer){
			  VechicleLocationsService.getVehicleLocations(CommonService.calculateTime()).then(function(value) {
					$scope.vehiclesLocation= value.data;
					if($scope.vehiclesLocation.length == 0){
						$scope.errorMessage = "Server returned empty response. There might be no data for the time " + CommonService.calculateTime() + " in realtimelocations.csv"
					}
					MapService.loadMap($scope, $scope.vehiclesLocation, 8); 
					MapService.markCoordinates($scope, $scope.vehiclesLocation, false, true);
					if(startTimer)
						$scope.vehicleLocationsTimer(); 
				}, function(reason) {
					$scope.errorMessage = "Error retrieving vehicle locations."; 
				}, function(value) {
					$scope.errorMessage = "No Call back defined";
				});
}

} ]);