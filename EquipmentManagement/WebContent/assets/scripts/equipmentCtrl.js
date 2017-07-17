app
		.controller(
				'equipmentCtrl',
				function($scope, $http, $filter, $resource, uiGridConstants) {
					
					// get List 
					function GetListEquipment() {
						$scope.list = [];
						var Song = $resource('http://localhost:8080/EquipmentServer/api/equipment');
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
									name : 'equipmentId',
									displayName : 'Equipment Id'
								},
								{
									name : 'equipmentName',
									displayName : 'Equipment Name'
								},
								{
									name : 'category.categoryName',
									displayName : 'Category Name'
								},
								{
									name : 'quantity',
									displayName : 'Quantity'
								},
								{
									name : 'unit',
									displayName : 'Unit'
								},
								{
									name : 'status',
									displayName : 'Description'
								},
								{
									name : 'Action',
									enableSorting : false,
									enableFiltering : false,
									cellTemplate : '<button class="btn btn-primary btn-sm" ng-click="grid.appScope.GetEquipment(row.entity)" data-tooltip ="tooltip" title="Edit"	data-toggle="modal" data-target="#myModal_Edit"><span class="glyphicon glyphicon-edit"></span></button>'
										
											+ '<button ng-click="grid.appScope.deleteEquipment(row.entity)" data-toggle="modal" class="btn btn-danger btn-sm" data-tooltip ="tooltip" title="Delete" data-target="#myModal_delete"><span class="glyphicon glyphicon-remove"></span></button>'
											
								} ]
					};
					
					
					var alertDuration = 1800;
					// Check SongId
					function id_duplicate_Add(id) {
						var flag = true;
						$scope.list
								.forEach(function(item, index) {
									if (item.equipmentId ===id) {
										$scope.duplicateAlert = "There already exists an equipment with this ID";

										flag = false;
									}
								});
						return flag;
					}
					// Hide alert when using same EquipmentID
					$scope.hideDuplicateAlert = function() {
						$scope.duplicateAlert = " ";
					}
					
					// Add new Equipment
					$scope.add = function(close) {
						if (id_duplicate_Add(document.getElementById("EquipmentId").value)) {
							
							$http(
									{
										method : "POST",
										url : "http://localhost:8080/EquipmentServer/api/equipment",
										data : {
											equipmentId : $scope.add_EquipmentId,
											equipmentName : $scope.add_EquipmentName,
											status : $scope.add_note,
											quantity:$scope.add_quantity,
											unit : $scope.add_unit,
											category:$scope.add_categoryName
											
										},

										dataType : "json",
										headers: { 'Content-Type': 'application/json; charset=UTF-8'}
									})
									.then(
											function(result) {
												if (result.status == 201) {

													GetListEquipment();
													alertAddSucess();
													if (close == true) {
														$("#myModal_Add")
																.modal("hide");
													}
												}

											},
											function(response) {
												alertFailMessage("Oops! Something went wrong, please check your input again.");
												console.log('Fail');
											});
						}
					}
					// Load song data to edit form

					$scope.GetEquipment = function(data) {
						$http
								.get(
										"http://localhost:8080/EquipmentServer/api/equipment/"
												+ data.id)
								.then(
										function(response) {
										EquipmentID= data.id
											$scope.edit_equipmentId = response.data.equipmentId;
											$scope.edit_equipmentName = response.data.equipmentName;
											$scope.edit_unit= response.data.unit;
											$scope.edit_quantity = response.data.quantity;
											$scope.edit_note = response.data.status;
											for (var i = 0; i < $scope.list_category.length; i++) {
								                if (response.data.category.categoryId == $scope.list_category[i].categoryId) {
								                    $scope.edit_categoryName = $scope.list_category[i];
								                    break;
}}
										
										});

					}
					// Update song information
					$scope.update = function () {
						
			   	var EquipmentData={
			   			id:EquipmentID,
			   			equipmentId:$scope.edit_equipmentId,
			   			equipmentName:$scope.edit_equipmentName,
			   			status : $scope.edit_note,
			   	quantity:$scope.edit_quantity,
			   	unit :$scope.edit_unit,
			   	category : $scope.edit_categoryName
			   			
			   				};
			   	
			       $http({
			          method: "PUT",
			          url: "http://localhost:8080/EquipmentServer/api/equipment",
			          data: EquipmentData,
			          dataType: "json",
			          headers: { 'Content-Type': 'application/json; charset=UTF-8'}
			       })
			          .then(function (result) {
			           	  $("#myModal_Edit").modal("hide");
			           	GetListEquipment();
			           	alertEditSucess();
			        }, function(response) {
							alertFailMessage("Oops! Something went wrong, please check your input again.");

			        });
			  }  
				
					// get data for delete
					var deleteCatogies ="";
					// get data for delete
					$scope.deleteEquipment = function(data)
					{
						deleteCatogies = data;
					}
					// Delete Song
					$scope.delete = function()
					{
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/EquipmentServer/api/equipment/"
											+ deleteCatogies.id
								}).then(function(result) {
							if (result.status == 202) {
								$('#myModal_delete').modal('hide');
								GetListEquipment();
								alertDeleteSucess();

							}
						});
					}
					
					
					// Alert when adding successfully
					function alertAddSucess() {
						swal({
							title : "",
							text : "Add successfully.",
							type : "success",
							timer : 2000,
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
					// alert when edit successfully
					function alertEditSucess() {
						swal({
							title : "",
							text : "Edit successfully.",
							type : "success",
							timer : alertDuration,
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
					// alert when have some input not right format
					function alertFail() {
						swal({
							title : "",
							text : "Opps! Something went wrong, please check your input again.",
							type : "error",
							timer : alertDuration,
							showConfirmButton : false
						})
						setTimeout(function() {
							location.reload();
						}, alertDuration);
					}
					// Reset form add
					$scope.ResetForm = function() {
						$scope.add_EquipmentId = "";
						$scope.add_EquipmentName = "";	
						$scope.frmFormAdd.EquipmentName.$setUntouched();
						$scope.frmFormAdd.EquipmentId.$setUntouched();
					}
					function getRandomInt(min, max) {
						return Math.floor(Math.random() * (max - min + 1))
								+ min;
					}
					// Auto fill in add form
					$scope.autoAdd = function(keyEvent) {
						if (keyEvent.keyCode == 81 && keyEvent.altKey) {
							var random = getRandomInt(10000, 59999);
							$scope.add_EquipmentId ="C"+ random;
							$scope.add_EquipmentName = "Ban Phim";
							$scope.add_unit = "cai";
							$scope.add_quantity = 1;
							$scope.add_note = "white machine";
						
						}
					}
				});