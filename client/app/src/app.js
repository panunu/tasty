'use strict';

var tasty = angular.module('tasty', ['restangular']);

tasty.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/taste/list.html',
            controller: 'TasteCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
});
