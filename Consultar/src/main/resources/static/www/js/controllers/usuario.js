app.controller('usuarioCtrl', function ($scope, $stateParams, Com,$rootScope) {
    var fab = document.getElementById('fabUsuario');
    // fab.addEventListener('click', function () {$('#popupSalvarUsuario').toggle(500);});
    $scope.fechar=function () {
        var a=document.getElementById('popupAlterarUsuario').style.display;
        if (a=='block'){
            $('#popupAlterarUsuario').toggle(500);
        }
        var s= document.getElementById('popupSalvarUsuario').style.display;
        if (s=='block'){
            $('#popupSalvarUsuario').toggle(500);
        }}
    var popupAlterar=function () {$('#popupAlterarUsuario').toggle(500);}
    var popupSalvar=function () {
        var display = document.getElementById('popupSalvarUsuario').style.display;
        if(display == 'none')
            $('#popupSalvarUsuario').toggle(500);
        else
            $('#popupSalvarUsuario').toggle(500);

    }
    $scope.fexarPopup=function () {
        $rootScope.usuario=null;

        popupAlterar();

    }
    $scope.setusuario=function (u) {
        $rootScope.altusuario=$scope.usuarios[u];
        console.log('id:'+u);


        popupAlterar();



    };

    var uri="/acesso"


    $scope.salvar=function (usuario) {
        usuario.status=1;
        usuario.tipo=1;
        Com.post(uri,usuario,function (dados) {
            $scope.usuario=dados;
            $scope.fechar();
            $scope.atualizar();
            $rootScope.usuario=null;


        })
    }
    $scope.alterar=function (usuario) {
        Com.post(uri+"/alterar",usuario,function (dados) {
            $scope.usuario=dados;
            $scope.fechar();
            $scope.atualizar();
            $rootScope.usuario=null;


        })
    }
    $scope.remover=function (index) {
        console.log(index);
        Com.remove(uri,$scope.usuarios[index].idacesso,function (dados) {
            $scope.atualizar();
        })};



    $scope.atualizar=function () {
        Com.get(uri,function (dados) {
            $scope.usuarios=dados;

            console.log(JSON.stringify($scope.usuarios))
        })
    }

    $scope.atualizar();
    $scope.addPermissao=function (perm) {
        existe=false;

        angular.forEach($scope.altusuario.permissoes, function(alt, key)
        {

            if (alt.nome==perm){
                existe=true;
            }

        });
        if (!existe){
            $scope.altusuario.permissoes[$scope.altusuario.permissoes.length]={"nome":perm};

        }


    }

});