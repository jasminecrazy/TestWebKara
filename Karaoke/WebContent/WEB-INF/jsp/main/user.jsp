<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="">
	<div class="page-title">
		<div class="title_left">

			<ul class="breadcrumb">
				<li>
					<i class="ace-icon fa fa-home home-icon"></i>
					<a href="#">Home</a>
				</li>
				<li class="active">
					<a href="#/">User Management</a>
				</li>
				
			</ul>
		</div>

	</div>
	<div class="title_right">
			<div class="form-group pull-right top_search">
				<button data-toggle="modal" data-target="#myModal_them"
					type="button" class="btn btn-primary btn-lg" ng-click="loadthem()">Add</button>
			</div>
		</div> 
	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<div class="clearfix"></div>
				</div>
				<div class="col-md-6 pull-right">
					<input id="filter" type="text" placeholder="Find"
						class="form-control" data-ng-model="filterTable"></input>
				</div>

				<div class="x_content">
					<label for="mySelect">Hiển thị </label> <select name="mySelect"
						id="mySelect"
						ng-options="option.name for option in rowdata.availableOptions track by option.id"
						ng-model="rowdata.selectedOption"
						ng-change="ChangeRow(rowdata.selectedOption.id)">
					</select> <label> dòng</label>
					
					<div class="table-responsive">
						<table class="table table-condensed table-hover">
							<thead>
								<tr>
									<th style="width: 3%">&#35;</th>
									<th class="sortable" style="width: 5%"
										ng-click="sortType = 'Username';sortReverse = !sortReverse">Username
										<span
										ng-show="sortType == 'Username' &amp;&amp; !sortReverse"
										class="fa fa-caret-down"></span> <span
										ng-show="sortType == 'Username' &amp;&amp; sortReverse"
										class="fa fa-caret-up"></span>
									</th>
									<th class="sortable" style="width: 7%"
										ng-click="sortType = 'password';sortReverse = !sortReverse">Password
										<span
										ng-show="sortType == 'password' &amp;&amp; !sortReverse"
										class="fa fa-caret-down"></span> <span
										ng-show="sortType == 'password' &amp;&amp; sortReverse"
										class="fa fa-caret-up"></span>
									</th>
									<th class="sortable" style="width: 7%"
										ng-click="sortType = 'status';sortReverse = !sortReverse">Status
										<span
										ng-show="sortType == 'status' &amp;&amp; !sortReverse"
										class="fa fa-caret-down"></span> <span
										ng-show="sortType == 'status' &amp;&amp; sortReverse"
										class="fa fa-caret-up"></span>
									</th>
									
									

								

									<th style="width: 10%">Action</th>

								</tr>
							</thead>
							<tbody>
								<tr data-ng-show="showList(x,$index)" data-ng-repeat="x in list |  orderBy:sortType:sortReverse| filter : filterTable"">
									<td ng-bind="$index+1"><input type="hidden"
										ng-model="x.id" /></td>
									<td data-ng-bind="x.username"></td>
									<td data-ng-bind="x.password"></td>
									<td data-ng-bind="x.status ? 'Nữ' : 'Nam'"></td>
									

									<td>
										<button data-toggle="modal" class="btn btn-success btn-sm"
											data-tooltip="tooltip" title="View detail informations"
											data-target="#myModal_detail" ng-click="chitiet(x)">
											<span class="glyphicon glyphicon-eye-open"></span>
										</button>
										<button class="btn btn-primary btn-sm" ng-click="sua(x)"
											data-tooltip="tooltip" title="Edit" data-toggle="modal"
											data-target="#myModal_sua">
											<span class="glyphicon glyphicon-edit"></span>
										</button>
										<!-- <button data-toggle="modal" class="btn btn-danger btn-sm"
											data-tooltip="tooltip" title="Delete"
											data-target="#myModal_xoa" ng-click="xoa(x)">
											<i class="ace-icon fa fa-trash-o bigger-130"></i>
										</button> -->
									</td>
								</tr>
							</tbody>
						</table>

					</div>
					<div class='pull-right'>
						<uib-pagination
							data-total-items="(list | filter:filterTable).length"
							data-ng-model="currentPage" data-ng-change="updatePageIndexes()"
							data-max-size="maxPaginationSize"
							data-items-per-page="itemsPerPage" data-boundary-links="true"
							data-previous-text="&lsaquo;" data-next-text="&rsaquo;"
							data-first-text="&laquo;" data-last-text="&raquo;">
						</uib-pagination>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal thêm -->
	<div class="modal fade" id="myModal_them" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Thêm thông tin trẻ</h4>
				</div>
				<div class="modal-body row">
					<form class="form-horizontal" name="frmStudentAdd"
						enctype="multipart/form-data" id="fileUploadForm">
						<div class="col-md-6">
							<!-- Text input-->
							<div class="form-group">
								<label class=" control-label" for="">Mã trẻ</label>
								<div class="">
									<input id="username" name="username"
										ng-keyup="hideDuplicateAlert()" class="form-control input-md"
										ng-keydown="autoAdd($event)" type="text"
										ng-model="add_username" ng-required="false" />
								</div>
							</div>
							<p ng-show="duplicateAlert != ''" ng-bind="duplicateAlert"
								style="color: red"></p>
							<!-- Text input-->
							<div class="form-group">
								<label class=" control-label" for="">Họ và tên trẻ</label>
								<div class="">
									<input id="studentName" name="studentName"
										class="form-control input-md" type="text"
										ng-model="add_studentName" ng-required="false" />
								</div>
							</div>
							<div class="form-group">
								<label class=" control-label" for="birthday">Ngày Sinh</label>
								<div class="">
									<input id="birthday" name="birthday" placeholder=""
										ng-model="birthday" class="form-control input-md" type="date" />

								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label class="control-label">Giới tính</label>
								<div class="checkbox">
									<label> <input type="radio" ng-model="gender" value="0"
										name="gender" ng-value="0" /> Nam
									</label> <label> <input type="radio" ng-model="gender"
										value="1" name="gender" ng-value="1" /> Nữ
									</label>
								</div>


							</div>
							<!-- Text input-->
							<div class="form-group">
								<label class=" control-label" for="birthday">Địa chỉ</label>
								<div class="">
									<textarea id="address" name="address" rows="5"
										class="form-control input-md" type="text"
										ng-model="add_address"></textarea>

								</div>
							</div>
							<div class="form-group">
								<label class=" control-label" for="birthday">Ngày vào
									trường</label>
								<div class="">
									<input id="ngayvaotruong" name="ngayvaotruong" placeholder=""
										class="form-control input-md" type="date" ng-required="true"
										ng-model="add_ngayvaotruong" />

								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Tình trạng sức khỏe</label> <input
									id="healthStatus" name="healthStatus" placeholder=""
									class="form-control input-md" type="text"
									ng-model="add_healthStatus" />


							</div>
							<div class="form-group">
								<label class="control-label">Họ tên phụ huynh</label> <input
									id="parentName" name="parentName" placeholder=""
									class="form-control input-md" type="text"
									ng-model="add_parentName" />


							</div>
							<div class="form-group">
								<label class="control-label">Số điện thoại</label> <input
									id="phone" name="phone" placeholder=""
									class="form-control input-md" type="text"
									ng-model="add_phone" />


							</div>
							<div class="form-group">
								<label class="control-label" for="selectbasic">Lớp</label>
								<div class="">
									<select ng-selected="student.class" ng-model="add_className"
										class="form-control"
										ng-options="x.tenlop for x in list_class" name="className"
										id="className" ng-required="true">
									</select>
								</div>
							</div>
						</div>





					</form>
				</div>
				<div class="modal-footer">
					<button id="btnSave" name="btnSave" class="btn btn-primary"
						ng-click="them(false)">Add</button>
					<button id="btnSave" name="btnSave" class="btn btn-default"
						ng-click="them(true)">Add and close</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

				</div>

			</div>
		</div>
	</div>
	<!-- Modal-->
	<!-- Modal sửa -->
	<div class="modal fade" id="myModal_sua" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Sửa thông tin trẻ</h4>
				</div>
				<div class="modal-body row">
					<form class="form-horizontal" name="editForm">
						<div class="col-md-6">
							<!--- text input-->
							<input type="hidden" name="id" ng-model="edit_id" /> <input
								type="hidden" name="username" ng-model="edit_username" />

							<!-- Text input-->
							<div class="form-group">
								<label class="control-label" for="lastName"> Họ và tên
									trẻ</label>
								<div class="">
									<input id="studentName" name="studentName" placeholder=""
										class="form-control input-md" type="text"
										ng-model="edit_studentName" ng-required="true" />

								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="birthday">Birthday</label>
								<div class="">
									<input id="birthday" name="birthday" placeholder=""
										ng-model="edit_birthday" class="form-control input-md"
										type="date" />

								</div>
							</div>
							<div class="form-group">
								<label class=" control-label" for="birthday">Địa chỉ</label>
								<div class="">
									<input id="address" name="address"
										class="form-control input-md" type="text"
										ng-model="edit_address" />
								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label class=" control-label">Ngày vào trường</label>
								<div class="">
									<input id="ngayvaotruong" name="ngayvaotruong"
										class="form-control input-md" type="date"
										ng-model="edit_ngayvaotruong" />

								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Gender</label>
								<div class="checkbox">
									<label> <input type="radio" ng-model="edit_gender"
										value="0" name="gender" /> Nam
									</label> <label> <input type="radio" ng-model="edit_gender"
										value="1" name="gender" /> Nữ
									</label>
								</div>
							</div>
						</div>
						<div class="col-md-6">

							<!-- Text input-->
							<div class="form-group">
								<label class=" control-label" for="birthday">Tình trạng
									sức khỏe</label>
								<div class="">
									<input id="healthStatus" name="healthStatus" placeholder=""
										class="form-control input-md" type="text" ng-required="true"
										ng-model="edit_healthStatus" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label" for="selectbasic">Lớp</label>
								<div class="">
									<select ng-selected="student.class" ng-model="edit_className"
										class="form-control" ng-options="x.tenlop for x in list_class"
										name="className" id="className" ng-required="true">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Họ tên phụ huynh</label> <input
									id="parentName" name="parentName" placeholder=""
									class="form-control input-md" type="text"
									ng-model="edit_parentName" />


							</div>
							<div class="form-group">
								<label class="control-label">Số điện thoại</label> <input
									id="phone" name="phone" placeholder=""
									class="form-control input-md" type="text"
									ng-model="edit_phone" />


							</div>
							<div class="form-group">
							<label class="control-label">Trạng thái</label>
							<div class="" style="padding: 6px">
								<input type="radio" ng-model="active" ng-value="true" />
								Còn học <input type="radio" ng-model="active" ng-value="false" />
								Đã nghỉ
							</div>
						</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">

					<button id="btnSave" name="btnSave" class="btn btn-primary"
						ng-click="update()" data-dismiss="modal">Save</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal xem chi tiết -->
	<div class="modal fade" id="myModal_detail" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Thông tin chi tiết</h4>
				</div>
				<div class="modal-body row">
					<form class="form-horizontal" name="frmStudentView">
						<div class="col-md-6">



							<!-- Text input-->
							<div class="form-group">
								<label class="control-label" for="lastName">Mã Trẻ</label>
								<div class="">
									<input id="username" name="username" placeholder=""
										class="form-control input-md" type="text"
										ng-model="chitiet.username" readonly="readonly"
										ng-required="true" />
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="control-label" for="firstName">Họ và Tên
									trẻ</label>
								<div class="">
									<input id="firstName" name="firstName" placeholder=""
										class="form-control input-md" type="text" ng-required="true"
										ng-model="chitiet.firstname" readonly="readonly" />
								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label class="control-label" for="birthday">Ngày Sinh</label>
								<div class="">
									<input id="birthday" name="birthday"
										class="form-control input-md" type="text"
										ng-model="chitiet.birthday" readonly="readonly" />
									<!-- <p>{{chitiet.birthday}}</p> -->
								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label class="control-label" for="address">Địa chỉ</label>
								<div class="">
									<input type="text" id="adress" name="address" placeholder=""
										rows="5" class="form-control input-md" type="text"
										ng-model="chitiet.address" readonly="readonly" />

								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label class="control-label" for="address">Ngày vào
									trường</label>
								<div class="">
									<input type="date" id="ngayvaotruong" name="ngayvaotruong"
										placeholder="" class="form-control input-md"
										ng-model="chitiet.ngayvaotruong" readonly="readonly" />

								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label class="control-label" for="address">Tình trạng
									sức khỏe</label>
								<div class="">
									<input type="text" id="healthStatus" name="healthStatus"
										placeholder="" class="form-control input-md"
										ng-model="chitiet.healthStatus" readonly="readonly" />

								</div>
							</div>
							

						</div>
						<div class="col-md-6">

							<!-- Text input-->
							<div class="form-group">
								<label class=" control-label" for="gender">Giới Tính</label>
								<div class="col-md-12">
									<p>{{chitiet.gender ? 'Nữ' : 'Nam'}}</p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label">Họ tên phụ huynh</label> <input
									id="parentName" name="parentName" placeholder=""
									class="form-control input-md" type="text"
									ng-model="chitiet.parentName" />


							</div>
							<div class="form-group">
								<label class="control-label">Số điện thoại</label> <input
									id="phone" name="phone" placeholder=""
									class="form-control input-md" type="text"
									ng-model="chitiet.phone" />


							</div>

						</div>

					</form>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal xóa -->
	<div class="modal fade" id="myModal_xoa" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Xác nhận</h4>
				</div>

				<div class="modal-body">

					<input type="hidden" ng-model="student_delete.id" />

					<p>Bạn có chắc chắn muốn xóa không?</p>
				</div>

				<div class="modal-footer">
					<a class="btn btn-danger btn-ok" ng-click="deleteStudent()">Có</a>
					<button type="button" class="btn btn-default" data-dismiss="modal">Không</button>

				</div>
			</div>
		</div>
	</div>

</div>