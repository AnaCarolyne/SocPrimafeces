<%-- 
    Document   : relatorioEntregaKitPorEstadoKit
    Created on : 25/04/2017, 08:15:48
    Author     : Sony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset= "utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <center>
        <title>Relatorio</title>
        <style type="text/css"> 
            table{width:25%;
                  margin:0;padding:0;
                  font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;
                  color:#1c5d79}table,th,tr{border-collapse:collapse}caption{margin:0;padding:0;background:#f3f3f3;height:40px;line-height:40px;text-indent:28px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:left;letter-spacing:3px;border-top:dashed 1px #c2c2c2;border-bottom:dashed 1px #c2c2c2}thead{background-color:#FFF;border:none}thead tr th{height:32px;line-height:32px;text-align:center;color:#1c5d79;background-image:url(col_bg_new.gif);background-repeat:repeat-x;border-left:solid 1px #F90;border-right:solid 1px #F90;border-collapse:collapse}tbody tr{background:#dfedf3;font-size:13px}tbody tr.odd{background:azure}tbody tr.odd:hover,tbody tr:hover{background:#fff}tbody tr td,tbody tr th{padding:6px;border:1px solid #326e87}tbody tr th{background:#1c5d79;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:12px;padding:6px;text-align:center;font-weight:700;color:#FFF;border-bottom:solid 1px #fff}tbody tr th:hover{background:#fff}table a{color:#F60;text-decoration:none;font-size:13px;border-bottom:solid 1px #fff}table a:hover{color:#F90;border-bottom:none}tfoot{background:#f3f3f3;height:24px;line-height:24px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:center;letter-spacing:3px;border-top:solid 2px #326e87;border-bottom:dashed 1px #c2c2c2}tfoot tr th{border-top:solid 1px #326e87}tfoot tr td{text-align:right}
            h1{
                color: white;

                font-family: serif ;
                font-weight: bolder;
                font-size: 40px;
                text-align: center;

            } 
            td{
                font-size: 15px;
            }  
        </style>




    </head>
    <body>
        <div aligan="center">


            <table>
                <div style="background-color:#1c5d79;top: 0px;">
                    <h1>Relatorio Atleta Cod Inscrição  ${operacao}</h1>
                </div>

                <form id="testForm" action="RelatorioAtletaInscricaoController" method="post">


                    <tr>
                        <td>Codigo da Inscrição :</td> 
                        <td align="left"><input name="idInscricao" type="number"  min="1" size="100"> </td>

                    </tr>
                    <br>   
                    <center><br><td><td colspan = "2" align="left"><input type="submit" name="btnConfirmar" value="Imprimir" </br></center>
                    <a href="PesquisaRelatorioController" class="nounderline"><button>Voltar</a></button></td>
                    </br>
                    </tr>   
            </table>
            </form>                
        </div>
    </body>
</html>
