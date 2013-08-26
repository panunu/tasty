'use strict';

tasty.controller('TasteCtrl', function ($scope, $http) {
    $http.get('/tastes')
        .success(function(data) {
            // TODO: Assign data to view.
        })
        .error(function() {
            // TODO: Lus?
        });
});