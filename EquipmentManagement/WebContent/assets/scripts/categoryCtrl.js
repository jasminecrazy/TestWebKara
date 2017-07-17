app
		.controller(
				'categoryCtrl',
				function($scope, $http, $filter, $resource, uiGridConstants) {
					
					// get List Songs
					function GetListCategory() {
						$scope.list = [];
						var Song = $resource('http://localhost:8080/EquipmentServer/api/category');
						Song.query().$promise.then(function(listSong) {

							$scope.list = listSong;
							$scope.gridOptions.data = listSong;

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
									name : 'categoryId',
									displayName : 'Category Id'
								},
								{
									name : 'categoryName',
									displayName : 'CategoryName'
								},
								

								{
									name : 'Action',
									enableSorting : false,
									enableFiltering : false,
									cellTemplate : '<button class="btn btn-primary btn-sm" ng-click="grid.appScope.GetCategory(row.entity)" data-tooltip ="tooltip" title="Edit"	data-toggle="modal" data-target="#myModal_Edit"><span class="glyphicon glyphicon-edit"></span></button>'
										
											+ '<button ng-click="grid.appScope.deleteCategory(row.entity)" data-toggle="modal" class="btn btn-danger btn-sm" data-tooltip ="tooltip" title="Delete" data-target="#myModal_delete"><span class="glyphicon glyphicon-remove"></span></button>'
											
								} ]
					};
					
					
					var alertDuration = 1800;
					// Check SongId
					function id_duplicate_Add(id) {
						var flag = true;
						$scope.list
								.forEach(function(item, index) {
									if (item.categoryId ===id) {
										$scope.duplicateAlert = "There already exists a category with this ID";

										flag = false;
									}
								});
						return flag;
					}
					// Hide alert when using same CategoryID
					$scope.hideDuplicateAlert = function() {
						$scope.duplicateAlert = " ";
					}
					
					// Add new Category
					$scope.add = function(close) {
						if (id_duplicate_Add(document.getElementById("CategoryId").value)) {
							
							$http(
									{
										method : "POST",
										url : "http://localhost:8080/EquipmentServer/api/category",
										data : {
											categoryId : $scope.add_CategoryId,
											categoryName : $scope.add_CategoryName
											
										},

										dataType : "json",
										headers: { 'Content-Type': 'application/json; charset=UTF-8'}
									})
									.then(
											function(result) {
												if (result.status == 201) {

													GetListCategory();
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
	
					$scope.GetCategory = function(data) {
						$http
								.get(
										"http://localhost:8080/EquipmentServer/api/category/"
												+ data.id)
								.then(
										function(response) {
										categoryID= data.id
											$scope.edit_CategoryId = response.data.categoryId;
											$scope.edit_CategoryName = response.data.categoryName;		
										
										});

					}
					// Update song information
					$scope.update = function () {
						
			   	var categoryData={
			   			id:categoryID,
			   			categoryId:$scope.edit_CategoryId,
			   			categoryName:$scope.edit_CategoryName,
			   			
			   				};
			   	
			       $http({
			          method: "PUT",
			          url: "http://localhost:8080/EquipmentServer/api/category",
			          data: categoryData,
			          dataType: "json",
			          headers: { 'Content-Type': 'application/json; charset=UTF-8'}
			       })
			          .then(function (result) {
			           	  $("#myModal_Edit").modal("hide");
			           	GetListCategory();
			           	alertEditSucess();
			        }, function(response) {
							alertFailMessage("Oops! Something went wrong, please check your input again.");

			        });
			  }  
				
					// get data for delete
					var deleteCatogies ="";
					// get data for delete
					$scope.deleteCategory = function(data)
					{
						deleteCatogies = data;
					}
					// Delete Song
					$scope.delete = function()
					{
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/EquipmentServer/api/category/"
											+ deleteCatogies.id
								}).then(function(result) {
							if (result.status == 202) {
								$('#myModal_delete').modal('hide');
								GetListCategory();
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
						$scope.add_CategoryId = "";
						$scope.add_CategoryName = "";	
						$scope.frmFormAdd.CategoryName.$setUntouched();
						$scope.frmFormAdd.CategoryId.$setUntouched();
					}
					function getRandomInt(min, max) {
						return Math.floor(Math.random() * (max - min + 1))
								+ min;
					}
					// Auto fill in add form
					$scope.autoAdd = function(keyEvent) {
						if (keyEvent.keyCode == 81 && keyEvent.altKey) {
							var random = getRandomInt(10000, 59999);
							$scope.add_CategoryId ="C"+ random;
							$scope.add_CategoryName = "Ban Phim";
						
						}
					}
				});