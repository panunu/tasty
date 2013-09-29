'use strict';

angular.module('tag-input', []).directive('tagInput', function() {
    var link = function(scope, element) {
        if (!scope.tags) {
            scope.tags = [];
        }

        var input = element.find('input');
        input.bind('keyup', function(e) {
            if (e.keyCode != 13) {
                return;
            }

            var value = input.val().trim();

            if (scope.tags.indexOf(value) !== -1) {
                return;
            }

            input.val('');
            scope.tags.push(value);
            scope.$apply();
        });
    };

    var template =
        '<div>' +
            '<input placeholder="Tag" class="form-control" />' +
            '<span ng-repeat="tag in tags" class="label label-default">{{ tag }}</span>' +
        '</div>';

    return {
        restrict: 'E',
        replace: true,
        scope: { tags: '=ngModel' },
        template: template,
        link: link
    };
});
