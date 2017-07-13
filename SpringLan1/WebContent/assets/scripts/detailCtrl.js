app
		.controller(
				'detailCtrl',
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
					// get Album List
					function GetListAlbum() {
						$scope.list_album = [];
						var Album = $resource('http://localhost:8080/WebServer/api/album');
						Album.query().$promise.then(function(listAlbum) {

							$scope.list_album = listAlbum;

						});

					}
					GetListAlbum();
					// get New List Vol
					function GetListVol() {
						$scope.list_newVol = [];
						var newVol = $resource('http://localhost:8080/WebServer/api/volume/getNewVol');
						newVol.query().$promise.then(function(listNewVol) {

							$scope.list_newVol = listNewVol;

						});

					}
					GetListVol();
					// get HightLightSong
					function GetHightLightSong() {
						$scope.list_hlSong = [];
						var highLight = $resource('http://localhost:8080/WebServer/api/song/getHightLightSong');
						highLight.query().$promise.then(function(
								listHighlightSong) {

							$scope.list_hlSong = listHighlightSong;

						});

					}
					GetHightLightSong();
					// Load favorite Song to index page
					function GetFavoriteSong() {
						$scope.list_favoriteSong = [];
						var favorite = $resource('http://localhost:8080/WebServer/api/song/getFavoriteSong');
						favorite.query().$promise.then(function(
								listFavoriteSong) {

							$scope.list_favoriteSong = listFavoriteSong;

						});

					}
					GetFavoriteSong();
					// Load detail HightLightSong
					function GetDetailSong(id) {
						$scope.list_DetailSong = [];
						var detail = $resource('http://localhost:8080/WebServer/api/song/'
								+ id);
						detail.query().$promise.then(function(listDetailSong) {

							$scope.list_DetailSong = listDetailSong;

						});

					}
					// Load newestSong

					function GetNewestSong() {
						$scope.list_NewestSong = [];
						var newSong = $resource('http://localhost:8080/WebServer/api/song/getNewestSong');
						newSong.query().$promise.then(function(listNewestSong) {

							$scope.list_NewestSong = listNewestSong;
							

						});

					}
					GetNewestSong();

					function GetSongHasSixNumber() {
						$scope.list_SixNumberSong = [];
						var newSong = $resource('http://localhost:8080/WebServer/api/song/sixNumber');
						newSong.query().$promise.then(function(
								listSixNumberSong) {

							$scope.list_SixNumberSong = listSixNumberSong;
							

						});

					}
					GetSongHasSixNumber();

					if (!$scope.chk_lyric) {
						$scope.chk_songName = true;
					}

					$scope.Search = function() {
						if ($scope.chk_songName) {
							$http.get(
									"http://localhost:8080/WebServer/api/song/search/"
											+ $scope.searchText).then(
									function(response) {
										$scope.list_searchSong = response.data;
										$scope.result = true;
										$scope.showme = true;

									});
						} else if ($scope.chk_lyric) {
							$http.get(
									"http://localhost:8080/WebServer/api/song/searchLyric/"
											+ $scope.searchText).then(
									function(response) {
										$scope.list_searchSong = response.data;
										$scope.result = true;
										$scope.showme = true;

									});
						}

					}
					// Phân trang
			    	$scope.currentPage = 1;
			    	// max size of the pagination bar
			    	$scope.maxPaginationSize = 10;
			    	  $scope.itemsPerPage = 15;
			    	$scope.updatePageIndexes = function () {
			    		var totalPages = Math.ceil($scope.list_SixNumberSong.length / $scope.maxPaginationSize);
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
				});