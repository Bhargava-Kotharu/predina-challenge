'use strict'

angular.module('predina.controllers').controller("CoordinatesController", [ "$scope", "$interval", "CoordinatesService", "MapService",
		function($scope, $interval, CoordinatesService, MapService) {
			
			//Get Coordinates
			$scope.getCoordinates = function() {
				CoordinatesService.getCoordinates().then(function(value) {
					$scope.coordinates= value.data;
					MapService.loadMap($scope, $scope.coordinates, 12);
					MapService.markCoordinates($scope, $scope.coordinates, true, true);
					$scope.StartTimer();
				}, function(reason) {
					console.log("Error retrieving Coordinates.");
				}, function(value) {
					console.log("No Call back defined");
				});

			}
			
			//Timer start function.
			 $scope.StartTimer = function ( ) { 
			      $scope.Timer = $interval(function () {
			    	  MapService.markCoordinates($scope, $scope.coordinates, true, true);
			      }, 1000);
			  };

} ]);