'use strict';

angular.module('bathalaApp')
  .directive('switchMap', function () {
    return {
      restrict: 'EA',
      scope: {
      	switchMap: '='
      },
      link: function (scope, element, attrs) {      	
      	element.bind('click', function() {
      		var mainSelector = angular.element(document.querySelector('#main'));      		  	
      		mainSelector.addClass('animate-leave');   
      		// var mapSelector = angular.element(document.querySelector('#map'));    
      		// mapSelector.addClass('animate-en')
      		// mapSelector.removeClass('map-inactive');
      		// mapSelector.addClass('map-active');
      	})        
      }
    };
  });