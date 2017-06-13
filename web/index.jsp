<%-- 
    Document   : teste
    Created on : 20/12/2016, 09:22:50
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>SOC</title>
        <style>

            button{
                border: black;
                padding: 10px 15px;
                font-weight: bolder;
                
                
                
            }


            #footer {
                width: 100%;
                bottom: 0;
                padding: 0px 0px;
                position: absolute;
                background: transparent;
            }

            #footer p {
                color: black;
                font-size: 20px;
                text-align: center;
            }
            #posicao {
                position: absolute; 
                font-family: sans-serif;
                left: 500px; /* posiciona a 90px para a esquerda */ 
                top: 100px; /* posiciona a 70px para baixo */
            }
            #imgposicao {
                position: absolute; 
                left: 400px; /* posiciona a 90px para a esquerda */ 
                top: 340px; /* posiciona a 70px para baixo */
            }
            a.nounderline:link 
            { 
                background-color: transparent;
                color: lime;
                
                
            } 
            #test{background-color: transparent;
                color: lime;
                
            }
         button:hover {

           box-shadow:0 5px 0 #191970;
                
            }
        </style>
    </head>
    <body>
        <div id="footer">
            <p>SOC - Sistema Organizador de Corrida --  IF Sudeste MG, Câmpus Juiz de Fora  --  Desenvolvido por: Ana Carolyne | Henry | Juliana</p>

        </div>
        <div id="posicao">
            <center><h1> Seja Bem Vindo ao... </h1></center>
            <center><h1>Sistema Organizador de Corrida</h1></center>
            <center><a href="principal.jsp" class="nounderline" id="teste"><button>Entrar</button></a></center>   

        </div>
        <img id="imgposicao" src="http://www.iefap.com.br/images/userfiles/images/corrida.png" alt="corrida" style="width:700px;height:200px;" >

    </body>

</html>
