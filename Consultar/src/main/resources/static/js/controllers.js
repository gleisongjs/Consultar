
var mapview;


var controller =angular.module('starter.controllers', [])

//.controller('DashCtrl', function($scope) {})

    .controller('CadastrarCtrl', function($scope,$http,Mensagem,$location,Com,$window) {

        console.log('CadastrarCtrl')
        $scope.cadastrar=function (usuario) {



            Com.post('/acesso',usuario,function (dados) {


                   Mensagem.exibir('Cadastro',"Cadastrado Com Sucesso");
                   $window.location.href = '#/login';

           });


        }
        })
.controller('loginCtrl', function($scope,Com,$location,Mensagem,$window) {
    console.log("Login");

    $scope.logar =function (usuario) {

      console.log("Logando"+usuario);

          Com.autenticar('/login',this.usuario,function (dados) {
                console.log('Login:'+dados);
                if (dados==='ok'){
                    console.log('redirecionando:');

                    $window.location.href = '#/tab/feeds';

                }else{
                    console.log('Login:'+'Usuario ou senha Invalidos');

                    Mensagem.exibir('Login',' Usuario ou senha Invalidos ');
                }
         });



  }
  }
  )
    .controller('unidadeDeSaudeCtrl', function($scope, $http,Com,$window,$rootScope) {



        $scope.doRefresh = function() {

            console.log('Refreshing!');
            $timeout( function() {
                //simulate async response
                $scope.items.push('New Item ' + Math.floor(Math.random() * 1000) + 4);

                //Stop the ion-refresher from spinning
                $scope.$broadcast('scroll.refreshComplete');

            }, 1000);

        };



        console.log('unidadeDeSaudeCtrl')
var uri="/unidadeSaude";
        $scope.un={};
        $scope.setUN=function (u) {


            $rootScope.unidade=$scope.unidadeSaudes[u];
            $rootScope.prof=$rootScope.unidade.profissional;
            $rootScope.medicamentos=$rootScope.unidade.medicamento;
            $rootScope.exames=$rootScope.unidade.exames;
            $rootScope.vacinas=$rootScope.unidade.vacinas;
            $rootScope.plantaoDia=[plantao={},profissional={}];

            // carregamapa($rootScope.unidade.latitude,$rootScope.unidade.longitude,$rootScope.unidade.nome);

            angular.forEach($rootScope.unidade.plantaoDia, function(item1, key) {
                angular.forEach ($rootScope.prof, function(item2, key) {
                    if(item1.profissional == item2.id) {

                        $rootScope.plantaoDia[key].plantao=item1;
                        $rootScope.plantaoDia[key].profissional=item2;

                    }
                })
            })


            $window.location.href ="#/tab/unidadeview";

        };

        $scope.atualizarUN=function () {

                    Com.get(uri,function (dados) {
                        $scope.unidadeSaudes=dados;
                        $rootScope.exames=$scope.unidadeSaudes[0].exames;
                        $rootScope.vacinas=$scope.unidadeSaudes[0].vacinas;
                        $rootScope.profissionais=$scope.unidadeSaudes[0].usurio;

                });

        };


        $scope.deleteUn=function (un) {
            console.log(un);
            Com.remove(uri,$scope.unidadeSaudes[un].idunidadeDeSaude,function (dados) {
                $scope.atualizarUN();

            })};



        $scope.atualizarUN();


    })
    .controller('unidadeSaudeCadastrarCtrl', function($scope,Com,$window) {
        console.log('unidadeSaudeCadastrarCtrl')
        $scope.salvarUn=function (un) {
            un.status=1;
            Com.post('/unidadeSaude',un,function (dados) {
                unidadeSaude=dados;
                $scope.atualizarUN();

                $window.location.href ='#/tab/unidadeDeSaude';
            })};

    })
    .controller('FeedsCadastrarCtrl', function($scope,Com,$window) {
        console.log('FeedsCadastrarCtrl')

        $scope.salvarFeed=function (feed) {
            feed.status=1;
            Com.post('/feedNoticia',feed,function (dados) {
                // feed=dados;
                $window.location.href ='#/tab/feeds';

            })};

    })
        .controller('FeedsCtrl', function($scope,Com,$window,$rootScope) {

            $scope.$on('$viewContentLoaded', function () {
                //Defina as funções executadas assim que a view seja totalmente carregada
                console.log('feed Carrecada')
            });


            console.log('FeedsCtrl')

var uri="/feedNoticia";
            $scope.setFeed=function (u) {
                $rootScope.feedNoticia=$scope.feeds[u];
                console.log('id:'+u);
                console.log($scope.feed);

                 $window.location.href ="#/tab/tab-feeds";

            };

            $scope.atualizarFeed=function () {
           Com.get(uri,function (data) {
               $scope.feeds=data;

           })
           };

            $scope.atualizarFeed();
        $scope.deleteFeed=function (index) {
            console.log(index);
            Com.remove(uri,$scope.feeds[index].idfeedNoticias,function (dados) {
                $scope.atualizarFeed();
            })};





    })
    .controller('AppCtrl', function ($scope, $ionicModal, $ionicPopover, $timeout,$location,Mensagem,$window) {

        console.log('AppCtrl')

    var fab = document.getElementById('fab');
    fab.addEventListener('click', function () {
        //location.href = 'https://twitter.com/satish_vr2011';
        Path=$location.path();
       if('/tab/feeds'==Path){
           $window.location.href ='#/tab/cadastrarfeeds';
         }
        if('/tab/unidadeDeSaude'==Path){
            $window.location.href ='#/tab/cadastrarUnidadeSaude';
        }
        if('/tab/localizacao'==Path){
            $window.location.href ='';
        }





    });

})
    .controller('MapUnCtrl', function($scope, $ionicLoading, $compile) {

        console.log('MapUnCtrl')
        function initialize() {
            console.log('Iniciando MAp');
            var myLatlng = new google.maps.LatLng(43.07493,-89.381388);

            var mapOptions = {
                center: myLatlng,
                zoom: 16,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("mapun"),
                mapOptions);

            //Marker + infowindow + angularjs compiled ng-click
            var contentString = "<div><a ng-click='clickTest()'>Click me!</a></div>";
            var compiled = $compile(contentString)($scope);

            var infowindow = new google.maps.InfoWindow({
                content: compiled[0]


            });

            var marker = new google.maps.Marker({
                position: myLatlng,
                map: map,
                title: 'Uluru (Ayers Rock)'
            });

            google.maps.event.addListener(marker, 'click', function() {
                infowindow.open(map,marker);
            });

            $scope.map = map;

        }


        google.maps.event.addDomListener(window, 'load', initialize);


        $scope.centerOnMe = function() {
            if(!$scope.map) {
                return;
            }

            $scope.loading = $ionicLoading.show({
                content: 'Getting current location...',
                showBackdrop: false
            });

            navigator.geolocation.getCurrentPosition(function(pos) {
                $scope.map.setCenter(new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude));
                $scope.loading.hide();
            }, function(error) {
                alert('Unable to get location: ' + error.message);
            });
        };

        $scope.clickTest = function() {
            alert('Example of infowindow with ng-click')
        };


    }) .controller('MapCtrl', function($scope, $ionicLoading, $compile,$timeout) {

        $scope.doRefresh = function() {

            console.log('Refreshing!');
            $timeout( function() {
                //simulate async response
                $scope.items.push('New Item ' + Math.floor(Math.random() * 1000) + 4);

                //Stop the ion-refresher from spinning
                $scope.$broadcast('scroll.refreshComplete');

            }, 1000);

        };


        $scope.$on('$viewContentLoading',
            function(event, viewConfig){
                console.log('content loading: ', event, viewConfig)
            });

        $scope.$on('$viewContentLoaded',
            function(event){
                console.log('content loaded: ',event)
            });

            // $scope.$on('$viewContentLoaded', function(event) {
            //     $timeout(function() {
            //         console.log('MapCtrl Carrecada')
            //     },0);
            // });



        console.log('MapCtrl')
        function initialize() {
            var myLatlng = new google.maps.LatLng(43.07493,-89.381388);

            var mapOptions = {
                center: myLatlng,
                zoom: 16,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map"),
                mapOptions);

            //Marker + infowindow + angularjs compiled ng-click
            var contentString = "<div><a ng-click='clickTest()'>Click me!</a></div>";
            var compiled = $compile(contentString)($scope);

            var infowindow = new google.maps.InfoWindow({
                content: compiled[0]


            });

            var marker = new google.maps.Marker({
                position: myLatlng,
                map: map,
                title: 'Uluru (Ayers Rock)'
            });

            google.maps.event.addListener(marker, 'click', function() {
                infowindow.open(map,marker);
            });

            $scope.map = map;

        }
         google.maps.event.addDomListener(window, 'load', initialize);

        $scope.centerOnMe = function() {
            if(!$scope.map) {
                return;
            }

            $scope.loading = $ionicLoading.show({
                content: 'Getting current location...',
                showBackdrop: false
            });

            navigator.geolocation.getCurrentPosition(function(pos) {
                $scope.map.setCenter(new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude));
                $scope.loading.hide();
            }, function(error) {
                alert('Unable to get location: ' + error.message);
            });
        };

        $scope.clickTest = function() {
            alert('Example of infowindow with ng-click')
        };


    });

