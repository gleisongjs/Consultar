app.controller('unidadeSaudeCtrl', function ($scope,Com, $rootScope) {


    var fab = document.getElementById('fabUN');
    fab.addEventListener('click', function () {
        $scope.un={};
        $('#popupSalvarUN').toggle(500);});
    $scope.fechar=function () {
        var a=document.getElementById('popupAlterarUN').style.display;
        if (a=='block'){
            $('#popupAlterarUN').toggle(500);
        }
        var s= document.getElementById('popupSalvarUN').style.display;
        if (s=='block'){
            $('#popupSalvarUN').toggle(500);
        }}
    var popupSalvar=function () {
        var display = document.getElementById('popupSalvarUN').style.display;
            $('#popupSalvarUN').toggle(500);

    }
    var popupAlterar=function () {

            $('#popupAlterarUN').toggle(500);


    }



        $scope.salvar=function (un) {

            console.log("Salvar Un:");
            console.log(JSON.stringify(un));
        Com.post(uri,un,function (dados) {
            $scope.un=dados;

            $scope.atualizarUN();
            $scope.fechar();

        })
    }



    console.log('unidadeDeSaudeCtrl')
    var uri="/unidadeSaude";
    $scope.un={};
    $scope.setUN=function (u) {
        $scope.un=$scope.unidadeSaudes[u];
        $rootScope.prof=$scope.un.profissional;
        $rootScope.medicamentos=$scope.un.medicamento;
        $rootScope.exames=$scope.un.exames;
        $rootScope.vacinas=$scope.un.vacinas;
        $rootScope.plantaoDia=[plantao={},profissional={}];

        // carregamapa($rootScope.unidade.latitude,$rootScope.unidade.longitude,$rootScope.unidade.nome);

        angular.forEach( $scope.un.plantaoDia, function(item1, key) {
            angular.forEach ($rootScope.prof, function(item2, key) {
                if(item1.profissional == item2.id) {

                    $rootScope.plantaoDia[key].plantao=item1;
                    $rootScope.plantaoDia[key].profissional=item2;

                }
            })
        })

        popupAlterar();

    };

    $scope.atualizarUN=function () {

        Com.get(uri,function (dados) {
            $rootScope.unidadeSaudes=dados;
            $rootScope.exames=$scope.unidadeSaudes[0].exames;
            $rootScope.vacinas=$scope.unidadeSaudes[0].vacinas;
            $rootScope.profissionais=$scope.unidadeSaudes[0].profissional;

        });

    };


    $scope.deleteUn=function (un) {
        console.log(un);
        Com.remove(uri,$scope.unidadeSaudes[un].idunidadeDeSaude,function (dados) {
            $scope.atualizarUN();

        })};



    $scope.atualizarUN();

   
});