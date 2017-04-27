<%-- 
    Document   : formulario
    Created on : 08/12/2016, 14:14:30
    Author     : Gleisongjs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="ls-theme-blue" lang="pt-br">
    <head>
        <title>CarSell APP</title>
        <meta charset="utf-8">
        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="CarSell APP" content="Essa aplicação será utilizada na avaliação da 3º VA, na disciplina de Programação e Tecnologia para Web">
        <!-- inserindo o bootstrap-->
        <link href="public/css/bootstrap.min.css" rel="stylesheet">
        <link href="public/css/bootstrap-select.min.css" rel="stylesheet">
        <link href="public/css/style.css" rel="stylesheet">
        <link href="public/css/costumizado.css" rel="stylesheet">

        <link href="public/stylesheets/locastyle.css" rel="stylesheet" type="text/css">
        <link rel="icon" sizes="192x192" href="images/portal.png">
        <link rel="apple-touch-icon" href="public/img//portal.png">
        <!-- Ele funciona da mesma com toda a versão do jQuery 1.x para 2.x -->
        <script src="public/js/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="public/js/jquery.min.js" type="text/javascript"></script>



    </head>
    <body>
        <div class="ls-topbar ">


            <span class="ls-show-sidebar ls-ico-menu"></span>

            <a href="/locawebstyle/documentacao/exemplos//pre-painel"  class="ls-go-next"><span class="ls-text">Voltar à lista de serviços</span></a>

            <!-- Nome do produto/marca com sidebar -->
            <h1 class="ls-brand-name">
                <a href="index.jsp" class="ls-ico-hours">
                    CarSell APP
                </a>
            </h1>

            <!-- Nome do produto/marca sem sidebar quando for o pre-painel  -->
        </div>


        <aside class="ls-sidebar">

            <div class="ls-sidebar-inner">
                <a href="#"  class="ls-go-prev"><span class="ls-text">Voltar à lista de serviços</span></a>

                <nav class="ls-menu">
                    <ul>
                        <li><a href="formulario.jsp"class="ls-ico-checkmark-circle" title="bubble sort">CADASTRAR</a></li>
                        <li><a href="#" class="ls-ico-checkmark-circle" title="selection sort">ALTERAR</a></li>
                        <li><a href="#" class="ls-ico-checkmark-circle" title="selection sort">RELATÓRIO</a></li>
                    </ul>
                </nav>
            </div>
        </aside>



        <script type="text/javascript" src="public/lib/jquery.min.js"></script>
        <script src="public/js/locastyle.js" type="text/javascript"></script>
        <script type="text/javascript" src="public/js/jquery-1.9.1.min.js"></script>

        <main class="ls-main ">
            <div class="container">
                <h1 class="ls-title-intro ls-ico-home">Página inicial</h1>
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="container">
                            <div class="view-form">                            
                                <form action="CadastraSV" name="cadastrasv" class="form-horizontal" method="post">
                                    <input type="hidden" id="id" name="id"/>

                                    <div class="panel panel-default">
                                        <div class="panel-heading"><span class="glyphicon glyphicon-apple"></span> Dados Pessoais</div>
                                        <div class="panel-body">                       
                                            <div class="form-group">
                                                <label for="nome" class="control-label col-md-2"><span class="obrigatorio">*</span> Nome</label>
                                                <div class="col-md-4">           
                                                    <input type="text" class="form-control" name="nome" maxlength="100" placeholder="Nome" required>
                                                </div>

                                                <label for="sexo" class="control-label col-md-2"><span class="obrigatorio">*</span> Sexo</label>
                                                <div class="col-md-4">           
                                                    <input type="text" class="form-control" name="sexo" maxlength="14" placeholder="Sexo" required>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label for="telefone" class="control-label col-md-2"><span class="obrigatorio">*</span> Telefone</label>
                                                <div class="col-md-4">           
                                                    <input type="text" class="form-control" name="telefone" maxlength="14" placeholder="Telefone" required>
                                                </div>
                                                <label for="whatsapp" class="control-label col-md-2"> WhatsApp</label>
                                                <div class="col-md-4">
                                                    <input  type="text" class="form-control telefone" maxlength="14" name="whatsapp" placeholder="WhatsApp" required />
                                                </div>
                                            </div> 

                                            <div class="form-group">
                                                <label for="Endereço" class="control-label col-md-2"> Endereço completo</label>
                                                <div class="col-md-4">
                                                    <input  type="text" class="form-control" maxlength="100" name="endereco" placeholder="Endereço completo" required />
                                                </div>

                                            </div>
                                            <div class="form-group">
                                                <label for="horario_trabalho" class="control-label col-md-2"> Horário de Trabalho</label>
                                                <div class="col-md-4">
                                                    <input  type="text" class="form-control" maxlength="100" name="horario_trabalho" placeholder="Horário de Trabalho" required />
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="panel panel-default">
                                        <div class="panel-heading"><span class="glyphicon glyphicon-lock"></span> Acesso</div>
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <label for="email" class="control-label col-md-2"><span class="obrigatorio">*</span> E-mail</label>
                                                <div class="col-md-4">
                                                    <input type="text" class="form-control" name="email" maxlength="100" placeholder="email@exemplo.com" required />
                                                </div> 
                                            </div>                          

                                            <div class="form-group">
                                                <label for="senha" class="control-label col-md-2"><span class="obrigatorio">*</span> Senha</label>
                                                <div class="col-md-4">
                                                    <input type="password" class="form-control" name="senha" maxlength="14" placeholder="Senha" required/>
                                                </div>
                                                <label for="confirmaSenha" class="control-label col-md-2"><span class="obrigatorio">*</span> Confirmar Senha</label>
                                                <div class="col-md-4">
                                                    <input type="password" class="form-control" name="confirmar_senha"  maxlength="14" placeholder="Confirmar Senha" required/>
                                                </div>
                                                <br/><br/><br/><br/>
                                                <!-- BOTÕES DE AÇÕES -->
                                                <div class="form-group">
                                                    <div style="alignment-adjust: central" ><center>
                                                            <span id="load"></span>
                                                            <input type="submit" name="btnsubmit" class="btn btn-success" aria-label="Left Align">
                                                            <input type="reset" name="btnreset" class="btn btn-danger" aria-label="Right Align">
                                                        </center>
                                                    </div>
                                                    <div class="col-md-9" style="text-align: right">
                                                        <span class="obrigatorio">*</span> Campos Obrigatórios
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>

        </main>
    </body>
</html>

