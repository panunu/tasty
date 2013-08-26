'use strict';

tasty.controller('TasteCtrl', function ($scope, $http) {
    $http.get('/tastes')
        .success(function(data) {
            $scope.list = data;
        })
        .error(function(){
            $scope.list = [];
        });
});