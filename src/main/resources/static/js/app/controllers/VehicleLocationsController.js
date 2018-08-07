'use strict'

angular.module('predina.controllers').controller("VehicleLocationsController", [ "$scope", "$interval", "VechicleLocationsService", "MapService", "CommonService",
		function($scope, $interval, VechicleLocationsService, MapService, CommonService) { 
			
		$scope.getVehicleLocations = function() {
				$scope.executeService(true);
		} 
			
		 //Timer start for every minute.
		 $scope.StartTimer = function () { 
		      $scope.Timer = $interval(function () { 
		    	  $scope.executeService(false);
		      }, 60000);
		  }; 
		  
		$scope.executeService = function(startTimer){
			  VechicleLocationsService.getVehicleLocations(CommonService.calculateTime()).then(function(value) {
					$scope.vehiclesLocation= value.data;
					MapService.loadMap($scope, $scope.vehiclesLocation, 8); 
					MapService.markCoordinates($scope, $scope.vehiclesLocation, false, true);
					if(startTimer)
						$scope.StartTimer(); 
				}, function(reason) {
					console.log("Error Occured retrieving Vehicle Locations.");
		}, function(value) {
			console.log("No Call back defined");
			});
}

} ]);