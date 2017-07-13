app
		.controller(
				'detailCtrl',
				function($scope, $http, $filter, $resource, uiGridConstants) {

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
											+ $scope.keyword).then(
									function(response) {
										$scope.list_searchSong = response.data;
										$scope.result = true;
										$scope.showme = true;

									});
						} else if ($scope.chk_lyric) {
							$http.get(
									"http://localhost:8080/WebServer/api/song/searchLyric/"
											+ $scope.keyword).then(
									function(response) {
										$scope.list_searchSong = response.data;
										$scope.result = true;
										$scope.showme = true;

									});
						}

					}

				});