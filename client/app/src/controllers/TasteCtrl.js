'use strict';

tasty.controller('TasteCtrl', function ($scope, $http, TasteService) {
    $scope.tastes = TasteService.all();

    $scope.add = function(taste) {
        console.log(TasteService.add(taste));
    };
});