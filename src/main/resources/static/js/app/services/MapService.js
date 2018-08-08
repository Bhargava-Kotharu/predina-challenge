'use strict'

angular.module('predina.services').service('MapService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			var markers = [];
			var mapCenter = new google.maps.LatLng(51.509865, -0.118092);
			
			// Load Map
			service.loadMap = function($scope, latLngList, zoomLevel) {
				//Setting the Map options.
			    $scope.MapOptions = {
			        center: mapCenter,
			        zoom: zoomLevel,
			        mapTypeId: google.maps.MapTypeId.ROADMAP
			    };

			    //Initializing the InfoWindow, Map and LatLngBounds objects.
			    $scope.InfoWindow = new google.maps.InfoWindow();
			    $scope.Latlngbounds = new google.maps.LatLngBounds();
			    $scope.Map = new google.maps.Map(document.getElementById("map"), $scope.MapOptions);
			}
			
			
			service.markCoordinates = function($scope, latLngList, calculateSeverity, deleteBeforeMarking) {
				// Clear existing markers
				if(deleteBeforeMarking)
					service.deleteAllMarkers();
				//Looping through the Array and adding Markers.
			    for (var i = 0; i < latLngList.length; i++) {
			        var data = latLngList[i];
			        var myLatlng = new google.maps.LatLng(data.latitude, data.longitude);
			        var severity = Math.floor((Math.random() * 10) + 1); 
			        //Initializing the Marker object.
			        var marker = new google.maps.Marker({
			            position: myLatlng,
			            map: $scope.Map,
			            icon: "images/car-icon.png"
			        });
			        
			        if(calculateSeverity){
			        	if (severity < 3) {
				        	 marker.icon="images/green-dot.png";
				        }else if (severity < 5) {
				        	 marker.icon="images/yellow-dot.png";
				        } else if (severity < 8) {
				        	 marker.icon="images/orange-dot.png";
				        } else{
				       	 	marker.icon="images/red-dot.png";	
				        }
			        } 

			        //Adding InfoWindow to the Marker.
			        if(data.vehicle){
			        	(function (marker, data) {
				            google.maps.event.addListener(marker, "click", function (e) {
				                $scope.InfoWindow.setContent("<div style = 'width:200px;min-height:40px'>" + data.vehicle + "</div>");
				                $scope.InfoWindow.open($scope.Map, marker);
				            });
				        })(marker, data);
			        }
		
			        //Plotting the Marker on the Map.
			        $scope.Latlngbounds.extend(marker.position);
			        //Add marker to the array.
		            markers.push(marker);
			    }
 
			}
			
			service.deleteAllMarkers = function(){
				//Loop through all the markers and remove
		        for (var i = 0; i < markers.length; i++) {
		            markers[i].setMap(null);
		        }
		        markers = [];
			}
			
			service.deleteMarker = function($scope, pos){
				return new google.maps.Marker({
		            map: $scope.map,
		            position: pos,
		            draggable: false,
		            animation: google.maps.Animation.DROP
		        });
			}
			 
			return service;
		} ]);