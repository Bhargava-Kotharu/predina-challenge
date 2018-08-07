'use strict'

angular.module('predina.services').service('CommonService', 
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {}; 
			 
			service.calculateTime = function(){
			  	var date = new Date();
				var hour = (date.getHours() < 12) ? date.getHours() : date.getHours();
				var minute = (date.getMinutes()<10?'0':'') + date.getMinutes();
				var time = hour + ':' + minute;  
				return time;
			};
			
			return service;
		} ]);