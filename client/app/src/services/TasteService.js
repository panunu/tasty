'use strict';

tasty.service('TasteService', ['Restangular', function(Restangular) {
    var tastes = Restangular.all('tastes');

    this.all = function() {
        return tastes.getList();
    }

    this.add = function(taste) {
        tastes.post(angular.toJson(taste));
    }
}]);