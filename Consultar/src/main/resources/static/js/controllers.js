
var controler =angular.module('starter.controllers', [])

//.controller('DashCtrl', function($scope) {})

    .controller('CadastrarCtrl', function($scope,$http,Mensagem,$location,Com) {


        $scope.cadastrar=function (usuario) {



           res= Com.post('/acesso',usuario,function (dados) {

               if (res=='ok') {
                   Mensagem.exibir('Cadastro',"Cadastrado Com Sucesso");
                    $location.path('#/tab/feeds');
               }else {
                   Mensagem.exibir('Cadastro',res);
               }
           });


        }
        })
.controller('loginCtrl', function($scope,Com,$location,Mensagem) {

  $scope.login =function (usurio) {
         res= Com.autenticar('/login',this.usuario,function (dados) {
                console.log('Login:'+dados);
                if (dados==='ok'){
                    console.log('redirecionando:');

                    $location.path('#/tab/feeds');

                }else{
                    console.log('Login:'+'Usuario ou senha Invalidos');

                    Mensagem.exibir('Login','Usuario ou senha Invalidos');
                }
         });



  }
  }
  )
    .controller('unidadeDeSaudeCtrl', function($scope, $http,Com) {
        $scope.unidadeSaude={};

        var setUN=function (un) {
            unidadeSaude=un;
        }

            var atualizarUN=function ($scope,$http) {

                    Com.get('/unidadeSaude',function (dados) {
                        $scope.unidadeSaudes=dados;
                });

        }

        salvarUn=function (un) {

            Com.post("/unidadeSaude",un,function (dados) {
                unidadeSaude=dados;
                atualizarFeed()
            })}
        deleteUn=function (un) {
            Com.delete("/unidadeSaude",un,function (dados) {
                atualizarFeed()
            })}



        atualizarUN($scope,$http);


    })
    .controller('CFeedsCtrl', function($scope, $http,Com) {
        $scope.feed ={}
        var setFeed=function (f) {
            feed=f;
        }


        var salvarFeed=function (f) {
            console.log("salvar feed");
            console.log(f);
            f.status=1;
            Com.post("/feedNoticia",f,function (dados) {
                feed=dados;
                atualizarFeed()
            })}
        var deleteFeed=function (feed) {
            Com.delete("/feedNoticia",feed,function (dados) {
                atualizarFeed()
            })}



    })
    .controller('FeedsCtrl', function($scope, $http,Com) {

        var atualizarFeed=function () {
           Com.get("/feedNoticia",function (data) {
               $scope.feeds=data;
           })
           }

        atualizarFeed($scope,$http);




       })

.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
controler.controller('AppCtrl', function ($scope, $ionicModal, $ionicPopover, $timeout,$location,Mensagem) {
    var fab = document.getElementById('fab');
    fab.addEventListener('click', function () {
        //location.href = 'https://twitter.com/satish_vr2011';
        Path=$location.path();
       if('/tab/feeds'==Path){
           $location.path('#/tab/cadastrarfeeds');
         }
        if('/tab/unidadeDeSaude'==Path){
            $location.path('#/tab/cadastrarUnidadeSaude');
        }
        if('/tab/localizacao'==Path){

        }





    });

});