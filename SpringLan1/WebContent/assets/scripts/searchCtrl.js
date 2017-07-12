app
		.controller(
				'searchCtrl',
				function($scope,$http, $filter, $resource, uiGridConstants) {

				
					function getSong() {
						$http.get(
								"http://localhost:8080/admin/api/song/search/"
										+ keyword).then(function(response) {
											console.log(response);

						});
					}
					getSong();
	
					
					
					

				
				
					
					
				});