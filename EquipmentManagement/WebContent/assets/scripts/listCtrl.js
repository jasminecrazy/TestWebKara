app
		.controller(
				'listCtrl',
				function($scope, $http, $filter, $resource, uiGridConstants) {
					const alertDuration = 2000;
					// get List
					function GetListEquipment() {
						$scope.list = [];
						var Song = $resource('http://localhost:8080/EquipmentServer/api/borrow');
						Song.query().$promise.then(function(listSong) {

							$scope.list = listSong;
							$scope.gridOptions.data = listSong;

						});

					}

					GetListEquipment();
					// get List
					function GetListCategory() {
						$scope.list_category = [];
						var Vol = $resource('http://localhost:8080/EquipmentServer/api/category');
						Vol.query().$promise.then(function(listVol) {

							$scope.list_category = listVol;

						});

					}
					GetListCategory();

					$scope.gridOptions = {
						noUnselect : true,
						multiSelect : false,
						enableRowSelection : true,
						enableRowHeaderSelection : false,
						enableSelectAll : false,
						enableGridMenu : true,
						enableFiltering : true,
						enableColumnResize : true,
						enableColumnMenus : false,
						paginationPageSizes : [ 15, 30, 50, 100 ],
						paginationPageSize : 15,
						columnDefs : [
								{
									name : 'id',
									displayName : 'No.'
								},
								{
									name : 'user.employeeName',
									displayName : 'Employee Name'
								},
								{
									name : 'user.email',
									displayName : 'Email'
								},
								{
									name : 'equipment.equipmentName',
									displayName : 'Equipment Name'
								},
								{
									name : 'equipment.unit',
									displayName : 'Unit'
								},
								{
									name : 'quantity',
									displayName : 'Quantity'
								},
								{
									name : 'status',
									displayName : 'Status',
									visible : true,
									cellTemplate : '<div class="ui-grid-cell-contents">{{row.entity.status == 0 ? "pending" : "approved"}}</div>',
									filter : {
										type : uiGridConstants.filter.SELECT,
										selectOptions : [ {
											value : 'true',
											label : 'approved'
										}, {
											value : 'false',
											label : 'pending'
										} ]
									}
								},
								{
									name : 'Action',
									enableSorting : false,
									enableFiltering : false,
									cellTemplate : '<button class="btn btn-primary btn-sm" ng-click="grid.appScope.GetEquipment(row.entity)" data-tooltip ="tooltip" title="Edit"	data-toggle="modal" data-target="#myModal_Edit"><span class="glyphicon glyphicon-edit"></span></button>'

											+ '<button ng-click="grid.appScope.deleteEquipment(row.entity)" data-toggle="modal" class="btn btn-danger btn-sm" data-tooltip ="tooltip" title="Delete" data-target="#myModal_delete"><span class="glyphicon glyphicon-remove"></span></button>'

								} ]
					};
					$scope.GetEquipment = function(data) {
						$http
								.get(
										"http://localhost:8080/EquipmentServer/api/borrowlist/"
												+ data.id)
								.then(
										function(response) {
											borrowID = data.id
											$scope.edit_idequipment = response.data.equipment.id;
											$scope.edit_EquipmentId = response.data.equipment.equipmentId;
											$scope.edit_EquipmentName = response.data.equipment.equipmentName;
											$scope.edit_employeeId = response.data.user.employeeName;
											$scope.edit_quantity = response.data.quantity;
											$scope.edit_unit = response.data.equipment.unit;
											$scope.status = response.data.status;
											$scope.edit_date_borrow = new Date(
													response.data.dateBorrow);
											$scope.edit_date_return = new Date(
													response.data.dateReturnback);
											$scope.edit_employee = response.data.user.id;

										});

					}

					// Update song information
					$scope.update = function() {

						var EquipmentData = {
							id : borrowID,
							status : ($scope.status == null ? false
									: ($scope.status == false ? false : true)),
							quantity : $scope.edit_quantity,
							equipment : {
								'id' : $scope.edit_idequipment
							},
							employee : {
								'id' : $scope.edit_employee
							},
							dateBorrow : $scope.edit_date_borrow,
							dateReturnback : $scope.edit_date_return

						};

						$http(
								{
									method : "PUT",
									url : "http://localhost:8080/EquipmentServer/api/borrow",
									data : EquipmentData,
									dataType : "json",
									headers : {
										'Content-Type' : 'application/json; charset=UTF-8'
									}
								})
								.then(
										function(result) {
											$("#myModal_Edit").modal("hide");
											GetListEquipment();
											alertEditSucess();
										},
										function(response) {
											alertFailMessage("Oops! Something went wrong, please check your input again.");

										});
					}
					var deleteBorrowList = "";
					// get data for delete
					$scope.deleteEquipment = function(data) {
						deleteBorrowList = data;
					}
					// Delete user
					$scope.delete = function() {
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/EquipmentServer/api/borrow/"
											+ deleteBorrowList.id
								}).then(function(result) {
							if (result.status == 202) {
								$('#myModal_delete').modal('hide');
								GetListEquipment();
								alertDeleteSucess();

							}
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

					function alertEditSucess() {
						swal({
							title : "",
							text : "Edit successfully.",
							type : "success",
							timer : alertDuration,
							showConfirmButton : false
						});
					}
					// alert when delete sucessfully
					function alertDeleteSucess() {
						swal({
							title : "",
							text : "Delete successfully.",
							type : "success",
							timer : alertDuration,
							showConfirmButton : false
						});
					}
				});