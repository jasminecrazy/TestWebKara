app
		.controller(
				'volCtrl',
				function($scope, $http, $filter, $resource, uiGridConstants) {

					// get Genre List
					function GetListVol() {
						$scope.list = [];
						var Genre = $resource('http://localhost:8080/WebServer/api/volume');
						Genre.query().$promise.then(function(listGenre) {

							$scope.list = listGenre;
							$scope.gridOptions.data = listGenre;

						});

					}
					GetListVol();
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
									name : 'volId',
									displayName : 'Vol ID'
								},
								{
									name : 'volName',
									displayName : 'Vol Name'
								},
								{
									name : 'Action',
									enableSorting : false,
									enableFiltering : false,
									cellTemplate : '<button class="btn btn-primary btn-sm" ng-click="grid.appScope.GetVol(row.entity)" data-tooltip ="tooltip" title="Edit"	data-toggle="modal" data-target="#myModal_Edit"><span class="glyphicon glyphicon-edit"></span></button>'
											+ '<button ng-click="grid.appScope.deleteVolume(row.entity)" data-toggle="modal" class="btn btn-danger btn-sm" data-tooltip ="tooltip" title="Delete" data-target="#myModal_delete"><span class="glyphicon glyphicon-remove"></span></button>'
								} ]
					};

					var alertDuration = 1800;
					// Check genreId
					function id_duplicate_Add(id) {
						var flag = true;
						$scope.list
								.forEach(function(item, index) {
									if (item.volId === id) {
										$scope.duplicateAlert = "There already exists a song with this ID";

										flag = false;
									}
								});
						return flag;
					}
					// Hide alert when using same SongID
					$scope.hideDuplicateAlert = function() {
						$scope.duplicateAlert = " ";
					}

					// Add new Genre
					$scope.add = function() {
						if (id_duplicate_Add(document.getElementById("volId").value)) {

							$http(
									{
										method : "POST",
										url : "http://localhost:8080/WebServer/api/volume",
										data : {
											volId : $scope.add_volId,
											volName : $scope.add_volName

										},

										dataType : "json",
										headers : {
											'Content-Type' : 'application/json; charset=UTF-8'
										}
									})
									.then(
											function(result) {
												if (result.status == 201) {

													$("#myModal_Add").modal(
															"hide");
													GetListVol();
													alertAddSucess();

												}

											},
											function(response) {
												alertFailMessage("Oops! Something went wrong, please check your input again.");
												console.log('Fail');
											});
						}

					}
					// Load song data to edit form

					$scope.GetVol = function(data) {
						$http.get(
								"http://localhost:8080/WebServer/api/volume/"
										+ data.id).then(function(response) {
							volID = data.id
							$scope.edit_volId = response.data.volId;
							$scope.edit_volName = response.data.volName;

							$scope.edit_id = data.id;
							$scope.editForm.volId.$setUntouched();
							$scope.editForm.volName.$setUntouched();

						});

					}
					// Update song information
					$scope.update = function() {

						var volData = {
							id : volID,
							volId : $scope.edit_volId,
							volName : $scope.edit_volName
						};

						$http(
								{
									method : "PUT",
									url : "http://localhost:8080/WebServer/api/volume",
									data : volData,
									dataType : "json",
									headers : {
										'Content-Type' : 'application/json; charset=UTF-8'
									}
								})
								.then(
										function(result) {
											$("#myModal_Edit").modal("hide");
											GetListVol();
											alertEditSucess();
										},
										function(response) {
											alertFailMessage("Oops! Something went wrong, please check your input again.");

										});
					}
					// get data for delete
					var deleteVolume = "";
					// get data for delete
					$scope.deleteVolume = function(data) {
						deleteVolume = data;
					}
					// Delete Song
					$scope.deleteVol = function() {
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/WebServer/api/volume/"
											+ deleteVolume.id
								}).then(function(result) {
							if (result.status == 202) {
								$('#myModal_delete').modal('hide');
								GetListVol();
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
					// Reset form add
					$scope.ResetForm = function() {
						$scope.add_volId = "";
						$scope.add_volName = "";
						$scope.frmFormAdd.volId.$setUntouched();
						$scope.frmFormAdd.volName.$setUntouched();

					}
					function getRandomInt(min, max) {
						return Math.floor(Math.random() * (max - min + 1))
								+ min;
					}
					// Auto fill in add form
					$scope.autoAdd = function(keyEvent) {
						if (keyEvent.keyCode == 81 && keyEvent.altKey) {
							var random = getRandomInt(1, 100);
							$scope.add_volId = "V" + random;
							$scope.add_volName = "Vol 43";

						}
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