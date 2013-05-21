var urlBase = '/Start_JQuery';
var angularMVCApp = angular.module('angularMVCApp', []);

angularMVCApp.controller(
		'mainController',
		function($scope){
			$scope.items = ['PHP', 'JavaScript'];
			$scope.index = -1;
			
			
			$scope.addItem = function(){
				var newItem = window.prompt('Add item:', '');
				if (newItem) {
					$scope.items.push(newItem);
				}
			};
			
			$scope.removeItem = function(){
				//$scope.items.splice($scope.index, 1);
			};
			
			$scope.changeSelectedItem = function(){
				$scope.index = this.selectedIndex;
				console.log("index: " + $scope.index);
				console.log("slectedItem " + $scope.selectedItem);
			};
		}
);

