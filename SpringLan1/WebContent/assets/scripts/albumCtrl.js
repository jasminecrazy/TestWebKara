app
		.controller(
				'albumCtrl',
				function($scope,$rootScope, $http, $filter, $resource, uiGridConstants) {
					$scope.list_Song = [];
					$rootScope.listName = [];
					      function getAllSong() {
					            $http({
					              url : 'http://localhost:8080/WebServer/api/song',
					              method : "GET"
					            }).then(function(response) {
					              $scope.list_Song = response.data;
					               $rootScope.listName = [];
					              for(var i = 0; i<response.data.length;i++)
					              {
					                $scope.listName.push($scope.list_Song[i].ten)
					                //$scope.songName = response.data[i].ten;
					            
					              }
					              console.log($scope.listName);
					            }, function(error) {
					              console.log(error);
					            });
					          }
					          getAllSong();
						
						
						//Sort Array
						$rootScope.listName.sort();
						//Define Suggestions List
						$rootScope.suggestions = [];
						//Define Selected Suggestion Item
						$rootScope.selectedIndex = -1;
						
						//Function To Call On ng-change
						$rootScope.search = function(){
							$rootScope.suggestions = [];
							var myMaxSuggestionListLength = 0;
							for(var i=0; i<$rootScope.listName.length; i++){
								var searchItemsSmallLetters = angular.lowercase($rootScope.listName[i]);
								var searchTextSmallLetters = angular.lowercase($scope.searchText);
								if( searchItemsSmallLetters.indexOf(searchTextSmallLetters) !== -1){
									$rootScope.suggestions.push(searchItemsSmallLetters);
									myMaxSuggestionListLength += 1;
									if(myMaxSuggestionListLength == 5){
										break;
									}
								}
							}
						}
						
						//Keep Track Of Search Text Value During The Selection From The Suggestions List  
						$rootScope.$watch('selectedIndex',function(val){
							if(val !== -1) {
								$scope.searchText = $rootScope.suggestions[$rootScope.selectedIndex];
							}
						});
						
						
						//Text Field Events
						//Function To Call on ng-keydown
						$rootScope.checkKeyDown = function(event){
							if(event.keyCode === 40){//down key, increment selectedIndex
								event.preventDefault();
								if($rootScope.selectedIndex+1 !== $rootScope.suggestions.length){
									$rootScope.selectedIndex++;
								}
							}else if(event.keyCode === 38){ //up key, decrement selectedIndex
								event.preventDefault();
								if($rootScope.selectedIndex-1 !== -1){
									$rootScope.selectedIndex--;
								}
							}else if(event.keyCode === 13){ //enter key, empty suggestions array
								event.preventDefault();
								$rootScope.suggestions = [];
							}
						}
						//Function To Call on ng-keyup
						$rootScope.checkKeyUp = function(event){ 
							if(event.keyCode !== 8 || event.keyCode !== 46){//delete or backspace
								if($scope.searchText == ""){
									$rootScope.suggestions = [];
								}
							}
						}
						//======================================
						
						//List Item Events
						//Function To Call on ng-click
						$rootScope.AssignValueAndHide = function(index){
							 $scope.searchText = $rootScope.suggestions[index];
							 $rootScope.suggestions=[];
						}
					// get Genre List
					function GetListAlbum() {
						$scope.list = [];
						var Album = $resource('http://localhost:8080/WebServer/api/album');
						Album.query().$promise.then(function(listAlbum) {

							$scope.list = listAlbum;
							$scope.gridOptions.data = listAlbum;

						});

					}
					GetListAlbum();
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
									name : 'albumId',
									displayName : 'Album ID'
								},
								{
									name : 'albumName',
									displayName : 'Album Name'
								},
								{
									name : 'Action',
									enableSorting : false,
									enableFiltering : false,
									cellTemplate : '<button class="btn btn-primary btn-sm" ng-click="grid.appScope.GetAlbum(row.entity)" data-tooltip ="tooltip" title="Edit"	data-toggle="modal" data-target="#myModal_Edit"><span class="glyphicon glyphicon-edit"></span></button>'
											+ '<button ng-click="grid.appScope.deleteAlbum(row.entity)" data-toggle="modal" class="btn btn-danger btn-sm" data-tooltip ="tooltip" title="Delete" data-target="#myModal_delete"><span class="glyphicon glyphicon-remove"></span></button>'
								} ]
					};

					var alertDuration = 1800;
					// Check genreId
					function id_duplicate_Add(id) {
						var flag = true;
						$scope.list
								.forEach(function(item, index) {
									if (item.albumId === id) {
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
						if (id_duplicate_Add(document.getElementById("albumId").value)) {

							$http(
									{
										method : "POST",
										url : "http://localhost:8080/WebServer/api/album",
										data : {
											albumId : $scope.add_albumId,
											albumName : $scope.add_albumName

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
													GetListAlbum();
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

					$scope.GetAlbum = function(data) {
						$http.get(
								"http://localhost:8080/WebServer/api/album/"
										+ data.id).then(function(response) {
							albumID = data.id
							$scope.edit_albumId = response.data.albumId;
							$scope.edit_albumName = response.data.albumName;

							$scope.edit_id = data.id;
							$scope.editForm.albumId.$setUntouched();
							$scope.editForm.albumName.$setUntouched();

						});

					}
					// Update song information
					$scope.update = function() {

						var albumData = {
							id : albumID,
							albumId : $scope.edit_albumId,
							albumName : $scope.edit_albumName
						};

						$http(
								{
									method : "PUT",
									url : "http://localhost:8080/WebServer/api/album",
									data : albumData,
									dataType : "json",
									headers : {
										'Content-Type' : 'application/json; charset=UTF-8'
									}
								})
								.then(
										function(result) {
											$("#myModal_Edit").modal("hide");
											GetListAlbum();
											alertEditSucess();
										},
										function(response) {
											alertFailMessage("Oops! Something went wrong, please check your input again.");

										});
					}
					// get data for delete
					var datadelete = "";
					// get data for delete
					$scope.deleteAlbum = function(data) {
						datadelete = data;
					}
					// Delete Song
					$scope.deleteAlbums = function() {
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/WebServer/api/album/"
											+ datadelete.id
								}).then(function(result) {
							if (result.status == 202) {
								$('#myModal_delete').modal('hide');
								GetListAlbum();
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
						$scope.add_albumId = "";
						$scope.add_albumName = "";
						$scope.frmFormAdd.albumId.$setUntouched();
						$scope.frmFormAdd.albumName.$setUntouched();
						

					}
					function getRandomInt(min, max) {
						return Math.floor(Math.random() * (max - min + 1))
								+ min;
					}
					// Auto fill in add form
					$scope.autoAdd = function(keyEvent) {
						if (keyEvent.keyCode == 81 && keyEvent.altKey) {
							var random = getRandomInt(1, 100);
							$scope.add_albumId = "A" + random;
							$scope.add_albumName = "Tiếng Anh";

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