
var controller =angular.module('starter.controllers', [])

//.controller('DashCtrl', function($scope) {})

    .controller('CadastrarCtrl', function($scope,$http,Mensagem,$location,Com,$window) {


        $scope.cadastrar=function (usuario) {



            Com.post('/acesso',usuario,function (dados) {

               if (dados=='ok') {
                   Mensagem.exibir('Cadastro',"Cadastrado Com Sucesso");
                   $window.location.href = '#/login';
               }else {
                   Mensagem.exibir('Cadastro',"erro"+dados);
               }
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
    .controller('unidadeDeSaudeCtrl', function($scope, $http,Com,$window) {
        var uri="/unidadeSaude";
        $scope.un={};

        $scope.setUN=function (u) {
            un=$scope.unidadeSaudes[u];
            $window.location.href ="#/tab/alterarunidadeDeSaude";
          };

        $scope.atualizarUN=function () {

                    Com.get(uri,function (dados) {
                        $scope.unidadeSaudes=dados;
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
        $scope.salvarUn=function (un) {
            un.status=1;
            Com.post('/unidadeSaude',un,function (dados) {
                unidadeSaude=dados;
                $scope.atualizarUN();

                $window.location.href ='#/tab/unidadeDeSaude';
            })};

    })
    .controller('FeedsCadastrarCtrl', function($scope,Com,$window,$rootScope) {
        $rootScope.salvarFeed=function (feed) {
            feed.status=1;
            Com.post('/feedNoticia',feed,function (dados) {
                // feed=dados;
                $window.location.href ='#/tab/feeds';
                $rootScope.atualizarFeed();

            })};

    })
        .controller('FeedsCtrl', function($scope,$rootScope,Com,$window) {
var uri="/feedNoticia";
            $scope.setFeed=function (u) {
                $rootScope.feed=$rootScope.feeds[u];
                console.log('id:'+u);
                console.log($rootScope.feed);

                 $window.location.href ="#/tab/alterarfeeds";

            };

            $rootScope.atualizarFeed=function () {
           Com.get(uri,function (data) {
               $rootScope.feeds=data;

           })
           };

            $rootScope.atualizarFeed($scope);
        $scope.deleteFeed=function (index) {
            console.log(index);
            Com.remove(uri,$rootScope.feeds[index].idfeedNoticias,function (dados) {
                $rootScope.atualizarFeed();
            })};





    })
    .controller('AppCtrl', function ($scope, $ionicModal, $ionicPopover, $timeout,$location,Mensagem,$window) {
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

});