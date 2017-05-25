// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
var app = angular.module('starter', ['ionic', 'ionic-material','starter.services']);

app.run(function ($ionicPlatform) {
    $ionicPlatform.ready(function () {
        // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
        // for form inputs)

        if (window.cordova && window.cordova.plugins.Keyboard) {
            cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
        }
        if (window.StatusBar) {
            StatusBar.styleDefault();
        }
    });
})

app.config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider

    .state('app', {
        url: '/app',
        abstract: true,
        templateUrl: 'templates/menu.html',
        controller: 'AppCtrl'
    })

    .state('app.unidadesaude', {
        url: '/unidadesaude',
        views: {
            'menuContent': {
                templateUrl: 'templates/unidadesaude.html',
                controller: 'unidadeSaudeCtrl'
            }
        }
    })
        .state('login', {
            url: '/login',
            templateUrl: 'templates/login.html'
        })
        .state('cadastrar', {
        url: '/cadastrar',
        templateUrl: 'templates/cadastrar.html'
                // ,
                // controller: 'unidadeSaudeCtrl'


    })
    //
    // .state('app.feednoticia', {
    //     url: '/feednoticia',
    //     views: {
    //         'menuContent': {
    //             templateUrl: 'templates/feednoticia.html',
    //             controller: 'feedNoticiaCtrl'
    //         }
    //     }
    // })
        .state('app.recursos', {
        url: '/recursos',
        views: {
            'menuContent': {
                templateUrl: 'templates/recurso.html'
                // ,
                // controller: 'feedNoticiaCtrl'
            }
        }
    }).state('app.feednoticia', {
        url: '/feednoticia',
        views: {
            'menuContent': {
                templateUrl: 'templates/feednoticia.html',
                controller: 'feedNoticiaCtrl'
            }
        }
    })

    .state('app.usuario', {
        url: '/usuario',
        views: {
            'menuContent': {
                templateUrl: 'templates/usuario.html',
                controller: 'usuarioCtrl'
            }
        }
    })

    .state('app.profissional', {
        url: '/profissional',
        views: {
            'menuContent': {
                templateUrl: 'templates/profissional.html',
                controller: 'profissionalCtrl'
            }
        }
    })


    ;

    // if none of the above states are matched, use this as the fallback
    $urlRouterProvider.otherwise('/app/feednoticia');
});
