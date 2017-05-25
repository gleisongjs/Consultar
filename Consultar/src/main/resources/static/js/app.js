// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
var app=angular.module('starter', ['ionic', 'starter.controllers', 'starter.services','pickadate']);

    app.run(function($ionicPlatform,$rootScope,$ionicHistory,$ionicModal,$ionicPopup) {
        // $rootScope.date='2016-2-11';
         $rootScope.feeds={};
         $rootScope.feed={};
         $rootScope.usuario={nome:"",senha:""};
         $rootScope.credenciais={};



        $rootScope.change_date = function() {
            console.log( $rootScope.date);
            $rootScope.open_popup=true
        };
        $rootScope.myGoBack = function() {
            $ionicHistory.goBack();
        };

        $rootScope.search_input=false;

        $rootScope.search_doc=function(){
            if($rootScope.search_input){
                $rootScope.search_input=false

            }else{
                $rootScope.search_input=true
            }
        }
        $ionicPlatform.ready(function() {
            // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
            // for form inputs)
            if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
                cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
                cordova.plugins.Keyboard.disableScroll(true);

            }
            if (window.StatusBar) {
                // org.apache.cordova.statusbar required
                StatusBar.styleDefault();
            }
        });

        $rootScope.forget_password=function (){
            $ionicPopup.show({
                template: 'Enter your email address below.<label class="item item-input" style="  height: 34px; margin-top: 10px;"><input  type="email"  /></label>',
                title: 'Forget Password',
                subTitle: ' ',
                scope: $rootScope,
                buttons: [
                    {text: '<b>Send</b>',
                        type: 'button-positive'},
                    { text: 'Cancel' ,
                        type: 'button-positive'},]
            });
        };


        /*************************************note_detail.html******************/
        // $ionicModal.fromTemplateUrl('templates/note_detail.html',function(modal){
        //     $rootScope.note_detail=modal;
        // }, {
        //     scope: $rootScope,
        //     animation: 'slide-in-up'
        // });
        //
        // $rootScope.opennote_detail= function(){
        //     $rootScope.note_detail.show();
        // };
        //
        // $rootScope.closenote_detail= function() {
        //     $rootScope.note_detail.hide();
        // };
        // $rootScope.$on('$destroy', function() {
        //     $rootScope.note_detail.remove();
        // });
        // $rootScope.$on('modal.hidden', function() {
        //     // Execute action
        // });
        /*************************************note_detail.html******************/

    });

    app.config(function($stateProvider, $urlRouterProvider,$httpProvider) {

        // $httpProvider.interceptors.push("timestampInterceptor");
       $httpProvider.interceptors.push("errorInterceptor");
        // $httpProvider.interceptors.push("loadingInterceptor");

        // $ionicConfigProvider.tabs.position('bottom');

        // Ionic uses AngularUI Router which uses the concept of states
        // Learn more here: https://github.com/angular-ui/ui-router
        // Set up the various states which the app can be in.
        // Each state's controller can be found in controllers.js
        $stateProvider

        // setup an abstract state for the tabs directive
            .state('tab', {
                url: '/tab',
                abstract: true,
                templateUrl: 'templates/menu.html'
            //      ,
            //       controller: 'AppCtrl'
            })


            .state('login', {
                url: '/login',
                templateUrl: 'templates/login.html'
            })

            .state('register', {
                url: '/register',
                templateUrl: 'templates/register.html'
            })



            // Each tab has its own nav history stack:

            .state('tab.feeds', {
                url: '/feeds',
                views: {
                    'tab-feeds': {
                        templateUrl: 'templates/feeds.html'

                    }
                }
            })  .state('tab.tab-feeds', {
                url: '/tab-feeds',
                views: {
                    'tab-feeds': {
                        templateUrl: 'templates/tab-feeds.html'

                    }
                }
            })
            .state('tab.alterarfeeds', {
                url: '/alterarfeeds',
                views: {
                    'tab-feeds': {
                        templateUrl: 'templates/alterarFeed.html'

                    }
                }
            })
            .state('tab.cadastrarfeeds', {
                url: '/cadastrarfeeds',
                views: {
                    'tab-feeds': {
                        templateUrl: 'templates/cadastrarFeed.html'
                    }
                }
            })
            .state('tab.cadastrarUnidadeSaude', {
                url: '/cadastrarUnidadeSaude',
                views: {
                    'tab-unidadeDeSaude': {
                        templateUrl: 'templates/cadastrarUnidadeSaude.html'

                    }
                }
            })

            .state('tab.unidadeDeSaude', {
                url: '/unidadeDeSaude',
                views: {
                    'tab-unidadeDeSaude': {
                        templateUrl: 'templates/unidadesDeSaude.html'

                    }
                }
            })
            .state('tab.unidadeview', {
                url: '/unidadeview',
                views: {
                    'tab-unidadeDeSaude': {
                        templateUrl: 'templates/unview.html'

                    }
                }
            })
            .state('tab.medicamento', {
                url: '/medicamento',
                views: {
                    'tab-unidadeDeSaude': {
                        templateUrl: 'templates/medicamentos.html'

                    }
                }
            })
            .state('tab.exames', {
                url: '/exames',
                views: {
                    'tab-unidadeDeSaude': {
                        templateUrl: 'templates/exames.html'

                    }
                }
            })
            .state('tab.vacinas', {
                url: '/vacinas',
                views: {
                    'tab-unidadeDeSaude': {
                        templateUrl: 'templates/vacinas.html'

                    }
                }
            })

            .state('tab.profissional', {
                url: '/profissional',
                views: {
                    'tab-unidadeDeSaude': {
                        templateUrl: 'templates/profissionais.html'

                    }
                }
            })

            .state('tab.alterarunidadeDeSaude', {
                url: '/alterarunidadeDeSaude',
                views: {
                    'tab-unidadeDeSaude': {
                        templateUrl: 'templates/alterarUnidadeSaude.html'

                    }
                }
            })


            .state('tab.localizacao', {
                url: '/localizacao',
                views: {
                    'tab-localizacao': {
                        templateUrl: 'templates/tab-localizacao.html',

                        cotrollerAs:'MapCtrl'
                    }
                }
            })



            ;

        // if none of the above states are matched, use this as the fallback
        $urlRouterProvider.otherwise('/login');

    });
angular.module("starter").factory("errorInterceptor", function ($q, $location) {
    return {
        responseError: function (rejection) {
//            console.log("errorInterceptor:"+rejection.status);

            if (rejection.status === 404) {
  //              console.log("erro 404")
    //            $location.path("/error");

            }
            if (rejection.status === 500) {
               console.log("erro 500")
                console.log(rejection.data)
//                Mensagem.exibir("Erro","Erro 500");
//                $location.path("/login");

            }
            if (rejection.status === 301) {
  //              console.log("erro 301")
    //            $location.path("/login");

            }
            if (rejection.status === 400) {
      //          console.log("erro 400")
        //        $location.path("/error");
            }
            return $q.reject(rejection);
        }
    };
});