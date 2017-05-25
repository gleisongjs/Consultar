app.controller('feedNoticiaCtrl', function ($scope, $stateParams, ionicMaterialInk,Com,$rootScope,$location) {

    var fab = document.getElementById('fabFeed');
    fab.addEventListener('click', function () {$('#popupSalvar').toggle(500);});
    $scope.fechar=function () {
        var a=document.getElementById('popupAlterar').style.display;
        if (a=='block'){
            $('#popupAlterar').toggle(500);
        }
        var s= document.getElementById('popupSalvar').style.display;
        if (s=='block'){
            $('#popupSalvar').toggle(500);
        }}
    var popupAlterar=function () {$('#popupAlterar').toggle(500);}
    var popupSalvar=function () {
        var display = document.getElementById('popupSalvar').style.display;
        if(display == 'none')
            $('#popupSalvar').toggle(500);
        else
            $('#popupSalvar').toggle(500);

    }
    $scope.fexarPopup=function () {
        popupAlterar();
    }
    $scope.setFeed=function (u) {
        $rootScope.feedNoticia=$scope.feedsNoticias[u];
        $scope.atlfeedNoticia= $rootScope.feedNoticia;
        console.log('id:'+u);


    popupAlterar();



    };

    var uri="/feedNoticia"


    $scope.salvar=function (feed) {

        Com.imagem('/upload',"formSalvar",function (data) {
            feed.imagem=data;
            console.log(feed.imagem);
        });

        feed.status=1;
        feed.tipo=1;
        Com.post(uri,feed,function (dados) {
            $scope.feed=dados;
            $scope.fechar();
            $scope.atualizar();



        })
    }
    $scope.remover=function (index) {
        console.log(index);
        Com.remove(uri,$scope.feedsNoticias[index].idfeedNoticias,function (dados) {
            $scope.atualizar();
        })};



    $scope.atualizar=function () {
       Com.get(uri,function (dados) {
           $scope.feedsNoticias=dados;

           console.log($scope.feedsNoticias)
        })
    }

    $scope.atualizar();

   
});