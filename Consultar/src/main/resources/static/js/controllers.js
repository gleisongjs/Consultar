
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
    .controller('unidadeDeSaudeCtrl', function($scope, $http,Com,$window,$rootScope) {
        var uri="/unidadeSaude";
        $scope.un={};

        $scope.setUN=function (u) {
            $rootScope.unidade=$scope.unidadeSaudes[u];
            $rootScope.profissionais=$rootScope.unidade.profissional;
            $rootScope.medicamentos=$rootScope.unidade.medicamento;
            $rootScope.exames=$rootScope.unidade.exames;
            $rootScope.vacinas=$rootScope.unidade.vacinas;
            $rootScope.plantaoDia=$rootScope.unidade.plantaoDia;



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
        $scope.salvarUn=function (un) {
            un.status=1;
            Com.post('/unidadeSaude',un,function (dados) {
                unidadeSaude=dados;
                $scope.atualizarUN();

                $window.location.href ='#/tab/unidadeDeSaude';
            })};

    })
    .controller('FeedsCadastrarCtrl', function($scope,Com,$window) {
        $scope.salvarFeed=function (feed) {
            feed.status=1;
            Com.post('/feedNoticia',feed,function (dados) {
                // feed=dados;
                $window.location.href ='#/tab/feeds';

            })};

    })
        .controller('FeedsCtrl', function($scope,Com,$window,$rootScope) {
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

            $scope.atualizarFeed($scope);
        $scope.deleteFeed=function (index) {
            console.log(index);
            Com.remove(uri,$scope.feeds[index].idfeedNoticias,function (dados) {
                $scope.atualizarFeed();
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