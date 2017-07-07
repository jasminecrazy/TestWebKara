app
		.controller(
				'songCtrl',
				function($scope, $http, $filter, $resource, uiGridConstants) {
					/*
					 * $scope.list = []; function getAllSong() { $http({ url :
					 * 'http://localhost:8080/WebServer/api/song', method :
					 * "GET" }).then(function(response) { $scope.list =
					 * response.data; }, function(error) { console.log(error);
					 * }); } getAllSong();
					 */
					// get User List
					function GetListSong() {
						$scope.list = [];
						var User = $resource('http://localhost:8080/WebServer/api/song');
						User.query().$promise.then(function(listSong) {

							$scope.list = listSong;
							$scope.gridOptions.data = listSong;

						});

					}
					GetListSong();
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
									name : 'maso',
									displayName : 'SongId'
								},
								{
									name : 'ten',
									displayName : 'SongName'
								},
								{
									name : 'loi',
									displayName : 'Lyric'
								},
								{
									name : 'thongtin',
									displayName : 'Author'
								},
								{
									name : 'linkyoutube',
									displayName : 'Youtube Link'
								},

								{
									name : 'Action',
									enableSorting : false,
									enableFiltering : false,
									cellTemplate : '<button class="btn btn-primary btn-sm" ng-click="grid.appScope.GetSong(row.entity)" data-tooltip ="tooltip" title="Edit"	data-toggle="modal" data-target="#myModal_Edit"><span class="glyphicon glyphicon-edit"></span></button>'
											+ '<button ng-click="grid.appScope.deleteSong(row.entity)" data-toggle="modal" class="btn btn-danger btn-sm" data-tooltip ="tooltip" title="Delete" data-target="#myModal_delete"><span class="glyphicon glyphicon-remove"></span></button>'
								} ]
					};

					$scope.rowdata = {
						availableOptions : [ {
							id : '15',
							name : '15'
						}, {
							id : '30',
							name : '30'
						}, {
							id : '50',
							name : '50'
						}, {
							id : '100',
							name : '100'
						} ],
						selectedOption : {
							id : '15',
							name : '15 rows'
						}
					};
					$scope.ChangeRow = function(index) {
						$scope.itemsPerPage = index;
						$scope.updatePageIndexes();
					}
					var alertDuration = 1800;
					// Check SongId
					function id_duplicate_Add(id) {
						var flag = true;
						$scope.list
								.forEach(function(item, index) {
									if (item.maso ===id) {
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
					//Get Image
					$scope.prev_img='';
					$scope.getImage = function(element) {
			    		photofile = element.files[0];
			            var reader = new FileReader();
			            reader.onload = function(e) {
			                $scope.$apply(function() {
			                    $scope.prev_img = e.target.result;
			                });
			            };
			            reader.readAsDataURL(photofile);
			          
			    	};
			    	
			    	function uploadFile() {
			            $.ajax({
			              url: "http://localhost:8080/WebServer/api/song/uploadFile",
			              type: "POST",
			              data: new FormData($("#fileUploadForm")[0]),
			              enctype: 'multipart/form-data',
			              processData: false,
			              contentType: false,
			              cache: false,
			              success: function () {
			                // Handle upload success
			                $("#upload-file-message").text("File succesfully uploaded");
			              },
			              error: function () {
			                // Handle upload error
			                $("#upload-file-message").text(
			                    "File not uploaded (Perhaps this picture is too big)");
			              }
			            });
			          }
			    	$scope.image="";
					// Add new Song
					$scope.add = function(close) {
						if (id_duplicate_Add(document.getElementById("songId").value)) {
							uploadFile();
							$http(
									{
										method : "POST",
										url : "http://localhost:8080/WebServer/api/song",
										data : {
											maso : $scope.add_songId,
											ten : $scope.add_songName,
											loi : $scope.add_lyric,
											thongtin : $scope.add_author,
											linkyoutube : $scope.add_youtubelink,
											picture:$scope.image
										},

										dataType : "json",
										headers: { 'Content-Type': 'application/json; charset=UTF-8'}
									})
									.then(
											function(result) {
												if (result.status == 201) {

													GetListSong();
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
					//Load song data to edit form
	
					$scope.GetSong = function(data) {
						$http
								.get(
										"http://localhost:8080/WebServer/api/song/"
												+ data.id)
								.then(
										function(response) {
										songID= data.id
											$scope.edit_songId = response.data.maso;
											$scope.edit_songName = response.data.ten
											$scope.edit_lyric = response.data.loi;
											$scope.edit_id = data.id;
											$scope.edit_author = response.data.thongtin;
											$scope.edit_youtubelink = response.data.linkyoutube;
										
										});

					}
					//Update song information
					$scope.update = function () {
						
			   	var songData={id:songID,ten:$scope.edit_songName,maso:$scope.edit_songId,loi:$scope.edit_lyric,
			   			thongtin:$scope.edit_author,linkyoutube:$scope.edit_youtubelink
			   			};
			   	
			       $http({
			          method: "PUT",
			          url: "http://localhost:8080/WebServer/api/song",
			          data: songData,
			          dataType: "json",
			          headers: { 'Content-Type': 'application/json; charset=UTF-8'}
			       })
			          .then(function (result) {
			           	  $("#myModal_Edit").modal("hide");
			           	GetListSong();
			           	alertEditSucess();
			        }, function(response) {
							alertFailMessage("Oops! Something went wrong, please check your input again.");

			        });
			  }  
					//get data for delete
					var deleteSong ="";
					//get data for delete
					$scope.deleteSong = function(data)
					{
						deleteSong = data;
					}
					//Delete Song
					$scope.delete = function()
					{
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/WebServer/api/song/"
											+ deleteSong.id
								}).then(function(result) {
							if (result.status == 202) {
								$('#myModal_delete').modal('hide');
								GetListSong();
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
						$scope.add_songId = "";
						$scope.add_songName = "";
						$scope.add_lyric = "";
						$scope.add_author="";
						$scope.add_youtubelink="";
					}
					function getRandomInt(min, max) {
						return Math.floor(Math.random() * (max - min + 1))
								+ min;
					}
					// Auto fill in add form
					$scope.autoAdd = function(keyEvent) {
						if (keyEvent.keyCode == 81 && keyEvent.altKey) {
							var random = getRandomInt(1, 10000);
							$scope.add_songId = random;
							$scope.add_songName = "Just the way you are";
							$scope.add_lyric = " And I see your name that nothing that I would change";
							$scope.add_author="Bruno Mars";
							$scope.add_youtubelink = "https://www.youtube.com/watch?v=KtyB1UTaoaE";

						}
					}
				});