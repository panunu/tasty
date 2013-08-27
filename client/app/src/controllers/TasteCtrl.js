'use strict';

tasty.controller('TasteCtrl', function ($scope, $http) {
    $http.get('/tastes')
        .success(function(data) {
            $scope.tastes = data;
        })
        .error(function() {
            // TODO: Lus?
        });
});