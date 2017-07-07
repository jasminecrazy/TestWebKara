app.controller('songCtrl',  function($scope, $http, $filter, $resource, uiGridConstants) {
	/*$scope.list = [];
	function getAllSong() {
		$http({
			url : 'http://localhost:8080/WebServer/api/song',
			method : "GET"
		}).then(function(response) {
			$scope.list = response.data;
		}, function(error) {
			console.log(error);
		});
	}
	getAllSong();*/
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
	    		multiSelect: false,
	    		enableRowSelection: true,
	    		enableRowHeaderSelection: false,
	    	    enableSelectAll: false,
	    	    enableGridMenu: true,
	    		enableFiltering: true,
	    		enableColumnResize: true,
	    		enableColumnMenus: false,
	    	    paginationPageSizes: [15, 30, 50, 100],
	    	    paginationPageSize: 15,
	    	    columnDefs: [
	    	    	{ name: 'id',displayName:'No.' },
	    		      { name: 'maso',displayName:'SongId' },
	    		      { name: 'ten', displayName : 'SongName' },
	    		      { name: 'loi', displayName : 'Lyric' },
	    		      { name: 'thongtin', displayName : 'Author' },
	    		      { name: 'linkyoutube', displayName : 'Youtube Link' },
	    		  
	    		      { name: 'Action',enableSorting: false,enableFiltering: false,
	    		             cellTemplate:'<button class="btn btn-primary btn-sm" ng-click="grid.appScope.GetIntake(row.entity)" data-tooltip ="tooltip" title="Edit"	data-toggle="modal" data-target="#myModal_edit"><span class="glyphicon glyphicon-edit"></span></button>'
	    		            	 			+'<button ng-click="grid.appScope.GetIntake(row.entity)" data-toggle="modal" class="btn btn-danger btn-sm" data-tooltip ="tooltip" title="Delete" data-target="#myModal_delete"><span class="glyphicon glyphicon-remove"></span></button>'
	    		      }
	    		    ]
	    	  };
	 
	 $scope.rowdata = {
		        availableOptions: [{
		                id: '15',
		                name: '15'
		            },
		            {
		                id: '30',
		                name: '30'
		            },
		            {
		                id: '50',
		                name: '50'
		            },
		            {
		                id: '100',
		                name: '100'
		            }
		        ],
		        selectedOption: {
		            id: '15',
		            name: '15 rows'
		        }
		    };
		    $scope.ChangeRow = function(index) {
		        $scope.itemsPerPage = index;
		        $scope.updatePageIndexes();
		    }
		    var alertDuration = 1800;
});