angular.module('starter.services', [])

.factory('Com', function($http) {

    var url='http://localhost:8090';
    var dados='iniciando';

  return {

      imagem : function(uri,id,callback) {
          $.ajax({
              url: url+uri,
              type: "POST",
              data: new FormData($("#"+id)[0]),
              enctype: 'multipart/form-data',
              processData: false,
              contentType: false,
              cache: false,
              success: function (data) {
                  // Handle upload success
                  $("#upload-file-message").text("File Upload Operation is Successful").addClass("alert alert-success");
              callback(data);
              },
              error: function () {
                  // Handle upload error
                  $("#upload-file-message").text("File Upload Operation is UnSuccessful").addClass("alert alert-danger");
              }
          });
      },
          autenticar: function(uri,usuario,callback) {
              console.log('Logando:');
          $.ajax({type: "POST", url: url+uri, beforeSend: function(xhr) {
              xhr.setRequestHeader("Authorization", "Basic " + window.btoa(usuario.email + ":" + usuario.senha)); },
              success: function(data) {
                callback('ok');

              },
              error:function(request,data){
                 callback(data);
              }} );


      },
          post: function(url,objeto,callback) {

        $http.post(url,objeto).success(function (data,status) {
            console.log("Status:"+status);
            callback(data);
        });

    },
    remove: function(uri,objeto,callback) {


        console.log("Get:"+url+" id:"+objeto);
        var rm={"id":objeto};
        $http.delete(url+uri+'/ '+objeto). success( function(data) {
                console.log('sucesso data:'+data+";" );
            callback(data);

            }

        ).
        error(function(request){
            console.log(JSON.stringify(request));

            callback("erro");
        });

    },
    get: function(uri,callback) {
        console.log("Get:"+url+uri);

      $http.get(url+uri). success( function(data) {

                //s  user=data;
              //  $window.location.href='/#/tab/news';
                console.log('sucesso data:'+JSON.stringify(data)+";" );
          callback(data);

            }
      ).
            error(function(request){
          console.log("Erro");
                console.log(JSON.stringify(request));

          callback(null);
            })




    }
  };
})

    .factory('Mensagem',function ($ionicPopup,$rootScope) {

        return {

            exibir: function (titulo, mensagem) {
                var res = $ionicPopup.confirm({
                    template: mensagem,
                    title: titulo,
                    subTitle: ' ',
                    scope: $rootScope,
                    buttons: [
                        {
                            text: '<b>Ok</b>',
                            type: 'button-positive'
                        },]
                });
            },
            confirmar: function (titulo, mensagem) {

                var ret=false;
                var confirmPopup = $ionicPopup.confirm({
                    title: titulo,
                    template: mensagem
                })
                ;

                 confirmPopup.then(function(res) {
                     ret= res;
                 }) ;

            }


        }
    }
    )
;
