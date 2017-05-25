app.controller('profissionalCtrl', function ($scope, $stateParams, Com,$rootScope) {

    var fab = document.getElementById('fabProfissional');
    fab.addEventListener('click', function () {$('#popupSalvarProfissional').toggle(500);});
    $scope.fechar=function () {
        var a=document.getElementById('popupAlterarProfissional').style.display;
        if (a=='block'){
            $('#popupAlterarProfissional').toggle(500);
        }
        var s= document.getElementById('popupSalvarProfissional').style.display;
        if (s=='block'){
            $('#popupSalvarProfissional').toggle(500);
        }}
    var popupAlterar=function () {$('#popupAlterarProfissional').toggle(500);}
    var popupSalvar=function () {
        var display = document.getElementById('popupSalvarProfissional').style.display;
        if(display == 'none')
            $('#popupSalvarProfissional').toggle(500);
        else
            $('#popupSalvarProfissional').toggle(500);

    }
    $scope.fexarPopup=function () {
        $rootScope.profissional=null;

        popupAlterar();

    }
    $scope.setprofissional=function (u) {
        $rootScope.altprofissional=$scope.profissionais[u];
        console.log('id:'+u);


        popupAlterar();



    };

    var uri="/profissional"


    $scope.salvar=function (profissional) {
        profissional.status=1;
        profissional.tipo=1;
        Com.post(uri,profissional,function (dados) {
            $scope.profissional=dados;
            $scope.fechar();
            $scope.atualizar();
            $rootScope.profissional=null;


        })
    }
    $scope.remover=function (index) {
        console.log(index);
        Com.remove(uri,$scope.profissionais[index].id,function (dados) {
            $scope.atualizar();
        })};



    $scope.atualizar=function () {
        Com.get(uri,function (dados) {
            $scope.profissionais=dados;

            console.log($scope.profissionais)
        })
    }

    $scope.atualizar();


});