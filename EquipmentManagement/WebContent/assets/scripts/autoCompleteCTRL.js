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

					$scope.borrow = function(data) {
						$http
								.get(
										"http://localhost:8080/EquipmentServer/api/borrowEquipment/"
												+ data.id)
								.then(
										function(response) {

											userID = data.id;
											console.log(response.data);
											$scope.add_EquipmentId = response.data.equipment.equipmentId;
											$scope.add_EquipmentName = response.data.equipment.equipmentName;
											$scope.add_unit = response.data.equipment.unit;

										});
					}
					var alertDuration = 1800;
					$scope.add = function() {
						var borrowDto = {
								'id': 5,
								'employeeId' : $scope.add_employeeId,
								equipment : {
									'id' :userID,
									'equipmentId':$scope.add_EquipmentId,
									'equipmentName' :$scope.add_EquipmentName
									
									
								},
								dateBorrow : currentDate,
								dateReturnback : $scope.add_date_return,
								quantity : $scope.add_quantity,
								status : $scope.add_note
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