app.controller('feedNoticiaCtrl', function ($scope, $stateParams, ionicMaterialInk,Com) {

    $scope.teste=function Mudarestado() {
        var display = document.getElementById('minhaDiv').style.display;
        if(display == 'none')
           $('#minhaDiv').toggle(500);
        else
            $('#minhaDiv').toggle(500);
    };

    var uri="/feedNoticia"

    $scope.salvar=function (feedNoticia) {
        feedNoticia.status=1;
        feedNoticia.tipo=1;
        Com.post(uri,feedNoticia,function (dados) {
            $scope.feed=dados;
            $scope.atualizar();

        })
    }
    $scope.remover=function (index) {
        console.log(index);
        Com.remove(uri,$scope.feedsNoticias[index].idfeedNoticias,function (dados) {
            $scope.atualizar();
        })};
$scope.alterar=function (index) {
    divAlterar=document.getElementsById('alterar');


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