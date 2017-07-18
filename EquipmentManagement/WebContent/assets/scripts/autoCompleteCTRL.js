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
						
								/*employeeId: 'J1',
								equipment :{
									'id':1
								},
						 "dateBorrow": "2017-07-17",
					        "dateReturnback": "2017-07-19",
					        "quantity": 1,
					        "status": true*/
							};
						var currentDate = new Date();
						$http.post("http://localhost:8080/EquipmentServer/api/borrow", borrowDto)
								.then(
										function(result) {
											if (result.status == 201) {

												$("#myModal_Add").modal("hide");
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

				});