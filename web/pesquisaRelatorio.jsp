<%-- 
    Document   : pesquisaRelatorio
    Created on : 25/04/2017, 08:19:40
    Author     : Sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            #rodape {

                width: 1000px;

                margin-top: 30px;

                padding: 10px;


            }
            h1{
                color: white;
                font-family: sans-serif ;
                font-weight: bolder;
                font-size: 30px;
                text-align: center;
            }
            td button:hover
            {

                background-color: darkblue;
                color: orange;
            }

            button{

                border-color: graytext;
                padding: 3px 7px;
                font-weight: bolder;
                color: #0000000;
                background-color: transparent;   


            }



        </style>




    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Relatório</title>
</head>
<body>
    <div style="background-color:#1c5d79;top: 0px;">
        <h1>Relatório do Sistema Organizador de Corrida  ${operacao}</h1>
    </div>






<center><table border="0"></center>
<tr><td><br><a href="RelatorioAtletaController"><button>Relatorio Atleta</button></a></br></td> <td> <br>   <a href="RelatorioAlimentoController"><button>Relatorio Alimento</button></a></br> </td> </tr>
<tr><td><br><a href="RelatorioCargoController"><button>Relatorio Cargo</button></a></br></td> <td> <br>   <a href="RelatorioChipController"><button>Relatorio Chip</button></a></br> </td> </tr>
<tr><td><br><a href="RelatorioCorridaController"><button>Relatorio Corrida</button></a></br></td> <td> <br>   <a href="RelatorioEntregaKitController"><button>Relatorio EntregaKit</button></a></br> </td> </tr>
<tr><td> <br>  <a href="RelatorioInscricaoController"><button>Relatorio Inscricao</button></a></br> </td>        <td> <br>   <a href="RelatorioFuncionarioController"><button>Relatorio Funcionario</button></a></br> </td> </tr>

<tr><td><br>  <a href="RelatorioKitProvaController"><button>Relatorio KitProva</button></a></br></td> <td><br>  <a href="RelatorioLoteController"><button>Relatorio Lote</button></a></br></td></tr>
<tr><td><br> <a href="RelatorioModalidadeController"><button>Relatorio Modalidade</button></a></br> </td> <td><br><a href="RelatorioObjetoKitController"><button>Relatorio ObjetoKit</button></a></br></td> </tr>
<tr> <td> <br>  <a href="RelatorioOrganizadorController"><button>Relatorio Organizador</button></a></br> </td><td><br><a href="RelatorioSuprimentoController"><button>Relatorio Suprimento</button></a></br></td> </tr>
<tr> <td> <br>  <a href="RelatorioInscricaoLoteKitProvaController"><button>Inscrição KitProva com Lote</button></a></br> </td><td><br><a href="RelatorioFuncionarioCorridaCargoController"><button>Funcionario Cargo Corrida</button></a></br></td> </tr>

       
</table>
    <br> 
<center><table border="0"></center>
 
        <h1 style="color:#1c5d79 ">Relatório com Parametro ${operacao}</h1>
    
 
  <tr> <td> <br>  <a href="relatorioEntregaKitPorEstado.jsp"><button>EntregaKit Por Estado</button></a></br> </td> <td> <br>  <a href="relatorioFuncionarioPorUfCorrida.jsp"><button>Funcionario por Uf da Corrida</button></a></br> </td> </tr>
  <tr> <td> <br>  <a href="relatorioKitProvacomChipSeparadoporSexo.jsp"><button>KitProva Separado Por Sexo</button></a></br> </td> <td> <br> <a href="relatorioInscricaoPorModalidade.jsp"><button>Inscricao Por Modalidade</button></a></br> </td> </tr> 
   <tr> <td> <br>  <a href="relatorioAlimentoSuprimento.jsp"><button>Alimento Por Suprimento</button></a></br> </td> <td> <br> <a href="relatorioKitProvaTamanho.jsp"><button>KitProva Tamanho</button></a></br> </td> </tr>
   <tr> <td> <br>  <a href="relatorioAtletaInscricao.jsp"><button>Atleta por CodInscrição</button></a></br> </td> <td> <br> <a href="relatorioFuncionarioCargoSeparadoPorSexo.jsp"><button>Funcionario Cargo Por Sexo</button></a></br> </td> </tr> 
   <tr> <td> <br>  <a href=" relatorioModalidadePorProva.jsp"><button>Modalidade Tipo de Prova</button></a></br> </td> <td> <br> <a href="relatorioSuprimentoNomeCorrida.jsp"><button>Suprimento Nome com Corrida</button></a></br> </td> </tr> 
 
   

</table>
    </br>    
<div id= "rodape">
    <center><br><a href="principal.jsp" class="nounderline"><button>Voltar Para Tela Principal </button></a></td></br></center>
</div>

</body>
</html>