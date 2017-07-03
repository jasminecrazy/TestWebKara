app
		.controller(
				'userCtrl',
				function($scope, $http, $filter, $resource) {
					$scope.list = [];
					$scope.date = new Date();
					function getAllStudent() {
						$http({
							url : 'http://localhost:8080/admin/api/Student',
							method : "GET"
						}).then(function(response) {
							$scope.list = response.data;
						}, function(error) {
							console.log(error);
						});
					}
					getAllStudent();
					$scope.rowdata = {
						     availableOptions: [
						    	 {id: '15', name: '15'},
							       {id: '30', name: '30'},
							       {id: '50', name: '50'},
							       {id: '100', name: '100'}
						     ],
						     selectedOption: {id: '15', name: '15 rows'}
						    };
					$scope.ChangeRow=function(index){
						$scope.itemsPerPage = index;
						$scope.updatePageIndexes();
					}
					
					 $scope.sortType = 'studentName';
					 $scope.filterTable =' ';
					// Phân trang
			    	$scope.currentPage = 1;
			    	// max size of the pagination bar
			    	$scope.maxPaginationSize = 10;
			    	  $scope.itemsPerPage = 15;
			    	$scope.updatePageIndexes = function () {
			    		var totalPages = Math.ceil($scope.list.length / $scope.maxPaginationSize);
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
					function getAllClass() {
						 $scope.list_class = [];
					        var Intake = $resource('http://localhost:8080/admin/api/studentcl');
					        Intake.query().$promise.then(function(listclass) {

					            $scope.list_class= listclass;
					            console.log($scope.list_class);
					        });
					}
					getAllClass();
					
					// add Student
					$scope.them = function(close) {
						
						if (id_duplicate_Add(document.getElementById("studentId").value)) {
							$http(
									{
										method : "POST",
										url : "http://localhost:8080/admin/api/Student",
										data : {
											studentId : $scope.add_studentId,
											studentName : $scope.add_studentName,
											ngaysinh : $scope.birthday,
											gioitinh : $scope.gender,
											diachi :$scope.add_address,
											ngayvaotruong : $scope.add_ngayvaotruong,
											tinhtrangsuckhoe : $scope.add_healthStatus,
											iclass:$scope.add_className,
											hotenph:$scope.parentName,
											phone:$scope.add_phone

										},
										dataType : "json"
									}).then(function(result) {	
								if (result.status == 201) {
									getAllStudent();
									addAlert();
									if (close == true) {
										$("#myModal_them").modal('hide');
									}
									
									
									
								}
							});
						}

					}
					var studentID = "";
					function id_duplicate_Add(id) {
						var flag = true;
						$scope.list
								.forEach(function(item, index) {
									if (id != studentID) {
										if (item.studentId === id) {
											$scope.duplicateAlert = "Bạn nhập trùng mã";
											flag = false;
										}
									}
								});
						return flag;
					}
					var studentID = "";
					// Load dữ liệu lên form sửa
					$scope.sua = function(data) {
						$http
								.get(
										"http://localhost:8080/admin/api/Student/"
												+ data.id)
								.then(
										function(response) {
											studentID = data.id;
											$scope.edit_studentName = response.data.studentName;
											$scope.edit_birthday = new Date(
													response.data.ngaysinh);
											$scope.edit_address = response.data.diachi;
											$scope.edit_ngayvaotruong = new Date(response.data.ngayvaotruong);
											$scope.edit_gender = response.data.gioitinh == 0 ? '0': '1';
											$scope.edit_healthStatus = response.data.tinhtrangsuckhoe;
											
											$scope.edit_id = data.id;
											$scope.edit_studentId=data.studentId;
											$scope.edit_parentName = response.data.hotenph;
											$scope.edit_phone = response.data.phone;
											$scope.active = response.data.status;
											for (var i = 0; i < $scope.list_class.length; i++) {
								                if (response.data.iclass.malop == $scope.list_class[i].malop) {
								                    $scope.edit_className = $scope.list_class[i];
								                    break;
								                }
								            }
										});

					}

					$scope.update = function() {
						var studentObj = {
							id : $scope.edit_id,
							studentId : $scope.edit_studentId,
							studentName : $scope.edit_studentName,
							ngaysinh : $scope.edit_birthday,
							gioitinh : $scope.edit_gender,
							diachi : $scope.edit_address,
							ngayvaotruong : $scope.edit_ngayvaotruong,
							tinhtrangsuckhoe:$scope.edit_healthStatus,
							iclass : $scope.edit_className,
							hotenph:$scope.edit_parentName,
							phone:$scope.edit_phone,
							 status: ($scope.active == null ? false : ($scope.active == false ? false : true))
						}
						
						$http({
							method : "PUT",
							url : "http://localhost:8080/admin/api/Student",
							data : studentObj,
							contentType : "application/json; charset=utf-8",
							dataType : "json"
						}).then(function(result) {
							$("#myModal_sua").modal("hide");
							getAllStudent();
							editAlert();

						}, function(response) {
							alertFailMessage("Vui lòng kiểm tra lại");
						});
					}
					// Thông tin chi tiết
					var studentID = ""
					$scope.chitiet = function(data) {
						$http
								.get(
										"http://localhost:8080/admin/api/Student/"
												+ data.id)
								.then(
										function(response) {
											studentID = data.id;
											$scope.chitiet.studentId = response.data.studentId;
											$scope.chitiet.firstname = response.data.studentName;
											$scope.chitiet.birthday = response.data.ngaysinh;
											$scope.chitiet.gender = response.data.gioitinh;
											$scope.chitiet.address = response.data.diachi;
											$scope.chitiet.ngayvaotruong = new Date (response.data.ngayvaotruong);
											$scope.chitiet.healthStatus = response.data.tinhtrangsuckhoe;
											$scope.chitiet.parentName = response.data.hotenph;
											$scope.chitiet.phone = response.data.phone
											
										});
					}
					//get data for delete
					$scope.xoa = function(data)
					{
						$scope.student_delete = data;
					}
					// Xóa Student
					$scope.student_delete = [];
					$scope.deleteStudent = function()
					{
						$http(
								{
									method : "DELETE",
									url : "http://localhost:8080/admin/api/Student/"
											+ $scope.student_delete.id
								}).then(function(result) {
							if (result.status == 202) {
								$('#myModal_xoa').modal('hide');
								getAllStudent();
								deleteAlert();

							}
						});
					}
					// Các alert
					function addAlert() {
						swal({
							title : "",
							text : "Add successfully.",
							type : "success",
							timer : 2000,
							showConfirmButton : false
						});
					}
					 var alertDuration = 1800;
					function alertFailMessage(message) {
						swal({
							title : "",
							text : message,
							type : "error",
							timer : alertDuration,
							showConfirmButton : false
						});
					}
					$scope.hideDuplicateAlert = function() {
						$scope.duplicateAlert = " ";
					}
					function deleteAlert() {
						swal({
							title : "",
							text : "Xóa thành công.",
							type : "success",
							timer : 2000,
							showConfirmButton : false
						});
					}
					function editAlert() {
						swal({
							title : "",
							text : "Sửa thành công.",
							type : "success",
							timer : 2000,
							showConfirmButton : false
						});
					}
					// Reset form Add
					$scope.loadthem = function()
					{
						$scope.add_studentId = "";
						$scope.add_studentName = "";
						$scope.birthday = "";
						$scope.gender = "";
						$scope.add_address = "";
						$scope.add_parentName = "";
						$scope.add_phone = "";
		
						
						
					}
					  function getRandomInt (min, max) {
						    return Math.floor(Math.random() * (max - min + 1)) + min;
						}
					//Hàm điền tự động
					 $scope.autoAdd = function(keyEvent) {    		  
					        if (keyEvent.keyCode == 81 && keyEvent.altKey) {
					        	var random = getRandomInt(1, 10000);
					        	$scope.add_studentId ="Mai" + random;
					        	$scope.add_studentName = "Mai";
								$scope.birthday = new Date("3/25/1997");
								$scope.gender = "0";
								$scope.add_address =random;
								$scope.add_healthStatus ="Tot";
								$scope.add_ngayvaotruong = new Date("3/25/1997");
								
					        }
					        }

				});
