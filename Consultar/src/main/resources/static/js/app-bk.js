// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic', 'starter.controllers', 'starter.services','pickadate'])

.run(function($ionicPlatform,$rootScope,$ionicHistory,$ionicModal,$ionicPopup) {
 $rootScope.date='2016-2-11';

    $rootScope.user={};
 

 $rootScope.change_date = function() {
   console.log( $rootScope.date);
   $rootScope.open_popup=true
  };
 $rootScope.myGoBack = function() {
    $ionicHistory.goBack();
  };
  
  $rootScope.open_detail=false;
  $rootScope.readMore=function(){
		if($rootScope.open_detail){
			$rootScope.open_detail=false
		}else{
			$rootScope.open_detail=true
		}  
	  } 
  $rootScope.search_input=false;

  $rootScope.search_doc=function(){
	  		if($rootScope.search_input){
		  	$rootScope.search_input=false

		}else{
			$rootScope.search_input=true
		}  
	  }  
$rootScope.setting=[{title:"Doctor news"},{title:"Hospital news"},{title:"Local news"},{title:"Notification allert"}]	
//$rootScope.news=[{id:"1",img:"img/dengue-20161013-172741.jpg"},{id:"2",img:"img/dengue-20161013-172741.jpg"}]	
$rootScope.hospital=[{id:"1",img:"img/h1.png"},{id:"2",img:"img/h2.png"},{id:"3",img:"img/h3.png"}]	
$rootScope.doctors=[{id:"1",img:"img/001.png",name:"John Mc Donald",specialty:"Beauty mouth and teeth"},{id:"2",img:"img/002.png",name:"Jonathan Calleri",specialty:"Neurological Surgery"},{id:"3",img:"img/003.png",name:"Donald Trump",specialty:"Allergy & Immunology"},{id:"4",img:"img/004.png",name:"Leonardo DiCaprio",specialty:"Child Psychiatry"},{id:"5",img:"img/max.png",name:"Mikle Mc Jack",specialty:"Radiation Oncology"},{id:"6",img:"img/adam.jpg",name:"Jack Reacher",specialty:"Surgery-General"}]	
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
        {text: '<b>Enviar</b>',
        type: 'button-positive'},
        { text: 'Cancel' ,
        type: 'button-positive'},]
        });	
    };


    $rootScope.mensagem=function (titulo,mensagem){
        $ionicPopup.show({
            template: mensagem,
            title: titulo,
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
	$ionicModal.fromTemplateUrl('templates/note_detail.html',function(modal){
	$rootScope.note_detail=modal;
	}, {
		scope: $rootScope,
		animation: 'slide-in-up'
	});
	
	$rootScope.opennote_detail= function(){
		$rootScope.note_detail.show();
	};
	
	$rootScope.closenote_detail= function() {	
		$rootScope.note_detail.hide();
	};
	$rootScope.$on('$destroy', function() {
		$rootScope.note_detail.remove();
	});
	$rootScope.$on('modal.hidden', function() {
    // Execute action
  });
 /*************************************note_detail.html******************/
  
})

.config(function($stateProvider, $urlRouterProvider, $ionicConfigProvider) {
	
  $ionicConfigProvider.tabs.position('bottom');

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider

  // setup an abstract state for the tabs directive
    .state('app', {
    url: '/app',
    abstract: true,
    templateUrl: 'templates/menu.html'
  })

      .state('app.ink', {
          url: '/ink',
          views: {
              'menuContent': {
                  templateUrl: 'templates/ink.html',
                  controller: 'InkCtrl'
              }
          }
      })

      .state('app.teste', {
          url: '/teste',
          views: {
              'app-teste': {
                  templateUrl: 'templates/news.html'
              }
          }
      })

  // Each tab has its own nav history stack:

  .state('tab.doctor', {
    url: '/doctor',
    views: {
      'tab-doctor': {
        templateUrl: 'templates/tab-doctor.html'
      }
    }
  })
  

  
  
  
  .state('tab.calender', {
    url: '/calender',
    views: {
      'tab-calender': {
        templateUrl: 'templates/tab-calender.html'
      }
    }
  })
  .state('tab.doctor-detail', {
    url: '/doctor-detail',
    views: {
      'tab-doctor': {
        templateUrl: 'templates/doctor-detail.html'
	 }
    }
  })
  
   .state('tab.hospital-detail', {
    url: '/hospital-detail',
    views: {
      'tab-unidadesDeSaude': {
        templateUrl: 'templates/huana.html'
	 }
    }
  })
  
  .state('tab.news-detail', {
    url: '/news-detail',
    views: {
      'tab-news': {
        templateUrl: 'templates/news-detail.html'
	 }
    }
  })
  
  .state('tab.news-detail1', {
    url: '/news-detail_1',
    views: {
      'tab-news': {
        templateUrl: 'templates/news-detail_1.html'
	 }
    }
  })
  .state('tab.news-detail11', {
    url: '/news-detail_1_1',
    views: {
      'tab-news': {
        templateUrl: 'templates/news-detail_1_1.html'
	 }
    }
  })
  
  
  .state('login', {
      url: '/login',
          templateUrl: 'templates/login.html'
    })

 .state('register', {
      url: '/register',
          templateUrl: 'templates/register.html'
    })  


  .state('tab.unidadesDeSaude', {
      url: '/unidadesDeSaude',
      views: {
        'tab-unidadesDeSaude': {
          templateUrl: 'templates/tab-unidadesDeSaude.html'
        }
      }
    })
    
  .state('tab.huana', {
      url: '/huana',
      views: {
        'tab-unidadesDeSaude': {
          templateUrl: 'templates/tab-huana.html'
        }
      }
    })
    
    
      .state('tab.exames', {
      url: '/exames',
      views: {
        'tab-unidadesDeSaude': {
          templateUrl: 'templates/exames.html'
        }
      }
    })
    
     .state('tab.profissionais', {
      url: '/profissionais',
      views: {
        'tab-unidadesDeSaude': {
          templateUrl: 'templates/profissionais.html'
        }
      }
    })
    
     .state('tab.medicamentos', {
      url: '/medicamentos',
      views: {
        'tab-unidadesDeSaude': {
          templateUrl: 'templates/medicamentos.html'
        }
      }
    })
    
     .state('tab.vacinas', {
      url: '/vacinas',
      views: {
        'tab-unidadesDeSaude': {
          templateUrl: 'templates/vacinas.html'
        }
      }
    })
    
    
    
.state('tab.localizacao', {
      url: '/localizacao',
      views: {
        'tab-localizacao': {
          templateUrl: 'templates/tab-localizacao.html'
        }
      }
    })	
	
    .state('tab.noticias', {
      url: '/noticias',
      views: {
        'tab-noticias': {
          templateUrl: 'templates/tab-noticias.html',
         
        }
      }
    })

  .state('tab.news', {
    url: '/news',
    views: {
      'tab-news': {
        templateUrl: 'templates/tab-news.html'
      }
    }
  });

  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/login');

});
