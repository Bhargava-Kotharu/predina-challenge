'use strict'

angular.module('predina.controllers').controller("CoordinatesController", [ "$scope", "$interval", "CoordinatesService", "MapService",
		function($scope, $interval, CoordinatesService, MapService) {
			
			// Get Coordinates
			$scope.getCoordinates = function() {
				CoordinatesService.getCoordinates().then(function(value) {
					$scope.coordinates= value.data;
					MapService.loadMap($scope, $scope.coordinates, 12);
					MapService.markCoordinates($scope, $scope.coordinates, true, true);
					$scope.coordinatesTimer();
				}, function(reason) {
					$scope.errorMessage = "Error retrieving Coordinates."; 
				}, function(value) {
					$scope.errorMessage = "No Call back defined";
				});

			}
			
			// Timer start function.
			 $scope.coordinatesTimer = function ( ) { 
			      $scope.Timer = $interval(function () {
			    	  MapService.markCoordinates($scope, $scope.coordinates, true, true);
			      }, 1000);
			  };

} ]);