app
		.controller(
				'userCtrl',
				function($scope, $http, $filter, $resource, uiGridConstants) {
					$scope.list = [];

					// get User List
					function GetListUser() {
						$scope.list = [];
						var User = $resource('http://localhost:8080/WebServer/api/user');
						User.query().$promise.then(function(listUser) {

							$scope.list = listUser;
							$scope.gridOptions.data = listUser;

						});

					}
					GetListUser();
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
									name : 'fullname',
									displayName : 'Fullname'
								},
								{
									name : 'username',
									displayName : 'Username'
								},
								{
									name : 'role.roleName',
									displayName : 'Role'
								},

								{
									name : 'enabled',
									displayName : 'Status',
									visible : true,
									cellTemplate : '<div class="ui-grid-cell-contents">{{row.entity.enabled == 0 ? "Inactive" : "Active"}}</div>',
									filter : {
										type : uiGridConstants.filter.SELECT,
										selectOptions : [ {
											value : 'true',
											label : 'Active'
										}, {
											value : 'false',
											label : 'Inactive'
										} ]
									}
								},
								{
									name : 'Action',
									enableSorting : false,
									enableFiltering : false,
									cellTemplate : '<button class="btn btn-primary btn-sm" ng-click="grid.appScope.GetUser(row.entity)" data-tooltip ="tooltip" title="Edit"	data-toggle="modal" data-target="#myModal_edit"><span class="glyphicon glyphicon-edit"></span></button>'
											+ '<button ng-click="grid.appScope.deleteUser(row.entity)" data-toggle="modal" class="btn btn-danger btn-sm" data-tooltip ="tooltip" title="Delete" data-target="#myModal_delete"><span class="glyphicon glyphicon-remove"></span></button>'
								} ]
					};
					var alertDuration = 1800;
					// Check username
					function id_duplicate_Add(id) {
						var flag = true;
						$scope.list
								.forEach(function(item, index) {
									if (item.username === id) {
										$scope.duplicateAlert = "There already exists a user with this username";

										flag = false;
									}
								});
						return flag;
					}
					// Hide alert when using same username
					$scope.hideDuplicateAlert = function() {
						$scope.duplicateAlert = " ";
					}
					// Add new user
					$scope.save = function(close) {
						if (id_duplicate_Add(document
								.getElementById("username").value)) {
							$http(
									{
										method : "POST",
										url : "http://localhost:8080/WebServer/api/user",
										data : {
											username : $scope.add_username,
											fullname : $scope.add_fullname,
											password : $scope.add_password,
											role : {
												'id' : $scope.role
											},
											enabled : $scope.status
										},

										dataType : "json"
									})
									.then(
											function(result) {
												if (result.status == 201) {

													GetListUser();
													alertAddSucess();
													if (close == true) {
														$("#myModal_add")
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
					// Reset form add
					$scope.resetFormAdd = function() {
						$scope.add_username = "";
						$scope.add_fullname = "";
						$scope.add_password = "";
					}
					function getRandomInt(min, max) {
						return Math.floor(Math.random() * (max - min + 1))
								+ min;
					}
					// Auto fill in add form
					$scope.autoAdd = function(keyEvent) {
						if (keyEvent.keyCode == 81 && keyEvent.altKey) {
							var random = getRandomInt(1, 10000);
							$scope.add_username = "Jackson" + random;
							$scope.add_fullname = "Jackson Samatha";
							$scope.add_password = "123456"

						}
					}
					//Load data to edit form
					$scope.GetUser = function(data) {
						$http
								.get(
										"http://localhost:8080/WebServer/api/user/"
												+ data.id)
								.then(
										function(response) {
											userID = data.id;
											$scope.edit_username = response.data.username;
											$scope.edit_fullname = response.data.fullname
											$scope.edit_status = response.data.enabled == 0 ? '0': '1';
											$scope.edit_id = data.id;
											$scope.edit_role = response.data.role.id==1 ?'1':'2';
										
										});

					}
					//Edit user information
					$scope.update = function()
					{
						
					}
					var deleteUser ="";
					//get data for delete
					$scope.deleteUser = function(data)
					{
						deleteUser = data;
					}
					//Delete user
					$scope.deleteUsers = function()
					{
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/WebServer/api/user/"
											+ deleteUser.id
								}).then(function(result) {
							if (result.status == 202) {
								$('#myModal_delete').modal('hide');
								GetListUser();
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

				});