angular.module("starter").factory("errorInterceptor", function ($q, $location) {
	return {
		responseError: function (rejection) {
            console.log("errorInterceptor")

            if (rejection.status === 404) {
				console.log("erro 404")
                $location.path("/error");

			}
            if (rejection.status === 500) {
                console.log("erro 500")
                $location.path("/error");

            }
            if (rejection.status === 301) {
                console.log("erro 301")
                $location.path("/error");

            }
            if (rejection.status === 400) {
                console.log("erro 400")
                $location.path("/error");
            }
			return $q.reject(rejection);
		}
	};
});