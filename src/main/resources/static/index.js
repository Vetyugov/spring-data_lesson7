angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app1/api/v1';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                name_part: $scope.filter ? $scope.filter.name_part : null,
                min_cost: $scope.filter ? $scope.filter.min_cost : null,
                max_cost: $scope.filter ? $scope.filter.max_cost : null
            }
        }).then(function (response) {
            $scope.ProductsList = response.data.content;
            console.log($scope.ProductsList);
        });
    };

    $scope.deleteProduct = function (id) {
        $http.delete(contextPath + '/products/' + id)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.createProduct = function () {
        $http.post(contextPath + '/products/', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.filterProducts = function () {
        $http({
            url: contextPath + '/products/cost_between',
            method: 'get',
            params: {
                min: $scope.filter.min_cost,
                max: $scope.filter.max_cost
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
        });
    }
    $scope.resetFilter = function () {
        $scope.filter.name_part = "";
        $scope.filter.min_cost = "";
        $scope.filter.max_cost = "";
        $scope.loadProducts();
    }

    $scope.loadProducts();
});