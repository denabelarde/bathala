'use strict';

angular.module('bathalaApp')
  .controller('MainCtrl', function ($scope, $http) {
	$scope.awesomeThings = [];

	$http.get('/api/things').success(function(awesomeThings) {
	  $scope.awesomeThings = awesomeThings;
	});

	$scope.shit = true;

	console.log("all of you shits", $scope.shit);

	$scope.fuckyou = function() {
		$scope.shit = false;
		console.log($scope.shit);
	}

	angular.extend($scope, {
		center: {
			lat: 14.5833,
			lng: 120.9667,
			zoom: 8
		}
	});

  });
