
angular.module('starter.controllers', [])

//.controller('DashCtrl', function($scope) {})

    .controller('CadastrarCtrl', function($scope,$http) {
        $scope.cadastrar=function (usuario) {
            console.log(usuario);
            $http.post("/acesso",usuario).success(function (data,status) {
                console.log(data);
            });
        }
    })
    
    
.controller('loginCtrl', function($scope,$http) {
   // $scope.feeds = [{"nome":"teste","titulo":"asdasd","descricao":"testestee"},{"nome":"teste2","titulo":"asdasd2","descricao":"testestee"}];



  $scope.login = function(usuario){
      $.ajax({type: "POST", url: "/login", beforeSend: function(xhr) {
          xhr.setRequestHeader("Authorization", "Basic " + window.btoa(usuario.email + ":" + usuario.senha)); },
          success: function(result,data) { console.log(arguments); },
          error:function(status,data){
              console.log(status+"  dados:"+data);
          }} );
   // $http.post("/acesso",usuario).success();

  //  console.log(usuario);
  };
  $scope.remove = function(chat) {
    Chats.remove(chat);
  };
})

    .controller('unidadeSaudeCtrl', function($scope, $http) {

        $scope.chat = Chats.get($stateParams.chatId);
    })

    .controller('feedNoticiaCtrl', function($scope, $http) {
       })

.controller('ChatDetailCtrl', function($scope, $stateParams, Chats) {
  $scope.chat = Chats.get($stateParams.chatId);
})

.controller('AccountCtrl', function($scope) {
  $scope.settings = {
    enableFriends: true
  };
});
