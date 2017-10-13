/**
 * Created by a1 on 22.05.17.
 */
angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://rest-service.guides.spring.io/greeting').
    then(function(response) {
        $scope.data = response.data;
    });

    /**
     *
     */
    function _addItems(event, settings, updateFunction, mode) {

        if (angular.isObject(settings)) {
            var modalSettings = {
                controller: settings.controller,
                templateUrl: settings.templateUrl,
                parent: angular.element(document.body),
                targetEvent: event,
                clickOutsideToClose: false,
                locals: {
                    serviceUrl: settings.serviceUrl,
                    rules: settings.rules,
                    formElements: {}
                }
            };

            _mdDialog.show(modalSettings).then(function (list) {

                var idList = [];

                list.forEach(function (item) {
                    idList.push(item.id);
                });

                if (angular.isFunction(updateFunction)) {
                    if (mode === 'fullList') {
                        updateFunction(list);
                    } else {
                        updateFunction(idList);
                    }
                }
            });
        }
    }
});
