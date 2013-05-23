var urlBase = '/Start_JQuery';
var angularMVCApp = angular.module('angularMVCApp', []);

var mainController = function($scope){
	$scope.items = ['PHP', 'JavaScript'];
	$scope.item = $scope.items[0];
	$scope.index = -1;
	
	
	$scope.addItem = function(){
		var newItem = window.prompt('Add item:', '');
		if (newItem) {
			$scope.items.push(newItem);
		}
	};
	
	$scope.removeItem = function(){
		$scope.items.splice($scope.index, 1);
		// or
		//$scope.items.splice($scope.items.indexOf($scope.item), 1);
	};
	
	$scope.changeSelectedItem = function(){
		$scope.index = $('#list').prop("selectedIndex");
		console.log("index: " + $scope.index);
		console.log("item: " + $scope.item);
	};
};
angularMVCApp.controller(
		'mainController', mainController
);

//config navigation
function AppConfigurator($routeProvider){
	$routeProvider
		.when('/', {controller: mainController, templateUrl: 'angular-MVC-default.html'})
		.when('/additem', {controller: mainController, templateUrl: 'angular-MVC-additem.html'})
		.otherwise({redirectTo: '/'});
};
angularMVCApp.config(AppConfigurator);