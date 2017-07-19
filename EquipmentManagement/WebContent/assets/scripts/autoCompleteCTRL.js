// JavaScript Documen
app
		.controller(
				'autoCompleteCTRL',
				function($scope, $rootScope, $http, $filter, $resource) {
					$scope.list_Song = [];
					$rootScope.listName = [];
					// get List
					function GetListEquipment() {
						$scope.list_equipment = [];
						var Song = $resource('http://localhost:8080/EquipmentServer/api/equipment');
						Song.query().$promise.then(function(listSong) {

							$scope.list_equipment = listSong;

						});

					}

					GetListEquipment();
var equipmentID = "";
					$scope.borrow = function(data) {
						$http
								.get(
										"http://localhost:8080/EquipmentServer/api/borrowEquipment/"
												+ data.id)
								.then(
										function(response) {

											equipmentID = data.id;
										
											for(var i= 0; i<response.data.length; i ++)
												{
												$scope.add_EquipmentId = response.data[i].equipmentId;
												$scope.add_EquipmentName = response.data[i].equipmentName;
												$scope.add_unit = response.data[i].unit;
												$scope.add_date_return ="";
												$scope.add_employeeId = "";
												$scope.add_quantity ="";
												$scope.frmFormAdd.employeeName.$setUntouched();
												$scope.frmFormAdd.quantity.$setUntouched();
												$scope.frmFormAdd.date_return.$setUntouched();
												}
										
											

										});
					}
					var alertDuration = 1800;
					$scope.add = function() {
						var borrowDto = {
						employeeId : $scope.add_employeeId,
						equipment:{
									'id': equipmentID
									
								},
						dateBorrow : new Date(),
						dateReturnback : $scope.add_date_return,
						quantity : $scope.add_quantity,
						status : false
							};
						var currentDate = new Date();
						$http.post("http://localhost:8080/EquipmentServer/api/borrow", borrowDto)
								.then(
										function(result) {
											if (result.status == 201) {

												$("#myModal_Add").modal("hide");
												GetListEquipment();
												alertAddSucess();

											}

										},
										function(response) {
											alertFailMessage("Oops! Something went wrong, please check your input again.");
											console.log('Fail');
										});
					}
					// Alert when adding successfully
					function alertAddSucess() {
						swal({
							title : "",
							text : "Đơn đang được xét duyệt, tình trạng đơn sẽ được thông báo qua email",
							type : "success",
							timer : 3000,
							showConfirmButton : false
						});
					}
					function alertFailMessage(message) {
						swal({
							title : "",
							text : message,
							type : "error",
							timer : alertDuration,
							showConfirmButton : false
						});
					}
					// Phân trang
			    	$scope.currentPage = 1;
			    	// max size of the pagination bar
			    	$scope.maxPaginationSize = 10;
			    	  $scope.itemsPerPage = 15;
			    	$scope.updatePageIndexes = function () {
			    		var totalPages = Math.ceil($scope.list_equipment.length / $scope.maxPaginationSize);
			    		if (totalPages <= 10) {
			                // less than 10 total pages so show all
			    			$scope.firstIndex = 1;
			    			$scope.lastIndex = totalPages;
			            } else {
			                // more than 10 total pages so calculate start and end pages
			                if ($scope.currentPage <= 6) {
			                	$scope.firstIndex = 1;
			                	$scope.lastIndex = 10;
			                } else if ($scope.currentPage + 4 >= totalPages) {
			                	$scope.firstIndex = totalPages - 9;
			                	$scope.lastIndex = totalPages;
			                } else {
			                	$scope.firstIndex = $scope.currentPage - 5;
			                	$scope.lastIndex = $scope.currentPage + 4;
			                }
			            }
			    		$scope.firstIndex = ($scope.currentPage - 1) * $scope.itemsPerPage;
			    		$scope.lastIndex = $scope.currentPage * $scope.itemsPerPage;
			    	};
			    	$scope.updatePageIndexes();
			    	
			    	$scope.showList=function(school,index){
			    		return ((index >= $scope.firstIndex) && (index < $scope.lastIndex));
			    	}

				});