angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                console.log(response.data)
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (id) {
        $http.get(contextPath + '/products/delete/' + id)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.createProduct = function () {
        $http.post(contextPath + '/new_product', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.filterProducts = function () {
        $http({
            url: contextPath + '/products/cost_between',
            method: 'get',
            params: {
                min: $scope.filter.min,
                max: $scope.filter.max
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
        });
    }

    $scope.loadProducts();
});