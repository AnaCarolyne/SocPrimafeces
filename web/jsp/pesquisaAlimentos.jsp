<%-- 
    Created on : 20/09/2016, 09:25:00
    Author     : Juliana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
         
        <meta charset= "utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Alimentos </title>
       <style type="text/css"> 
           table{
               width:100%;margin:0;padding:0;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;color:#1c5d79}
           table,td,th,tr{border-collapse:collapse}
           caption{margin:0;padding:0;background:#f3f3f3;height:40px;line-height:40px;text-indent:28px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:left;letter-spacing:3px;border-top:dashed 1px #c2c2c2;border-bottom:dashed 1px #c2c2c2}
           thead{background-color:#FFF;border:none}thead tr th{height:32px;line-height:32px;text-align:center;color:#1c5d79;background-image:url(col_bg_new.gif);background-repeat:repeat-x;border-left:solid 1px #F90;border-right:solid 1px #F90;border-collapse:collapse}
           tbody tr{background:#dfedf3;font-size:13px}
           tbody tr.odd{background:azure}
           tbody tr.odd:hover,tbody tr:hover{background:#fff}
           tbody tr td,tbody tr th{padding:6px;border:1px solid #326e87}
           tbody tr th{background:#1c5d79;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:12px;padding:6px;text-align:center;font-weight:700;color:#FFF;border-bottom:solid 1px #fff}
           tbody tr th:hover{background:#326e87}table a{color:#F60;text-decoration:none;font-size:13px;border-bottom:solid 1px #fff}
           table a:hover{color:#F90;border-bottom:none}tfoot{background:#f3f3f3;height:24px;line-height:24px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:center;letter-spacing:3px;border-top:solid 2px #326e87;border-bottom:dashed 1px #c2c2c2}
           tfoot tr th{border-top:solid 1px #326e87}tfoot tr td{text-align:right}
           </style>
           

    </head>
    <body>
    <center><h1>Pesquisa de Alimentos  ${operacao}</h1></center>
         <form action="ManterAlimentoController?acao=prepararIncluir" method="post" name="frmManterAlimento" onsubmit="return validarFormulario(this)">
            <center>
             <table border= 1>
            <tr>
              
                <th>Codigo Alimento</th>
                <th>Nome do Alimento</th>                
                <th>Calorias</th>
                <th> Quantidade de Carboidrato</th> 
                <th>Porção</th>
                <th colspan="2">Ação</th>
             
            </tr>
            <c:forEach items="${alimentos}" var="alimento">
                <tr>
                    <td><c:out value="${alimento.idAlimento}"/></td>
                    <td><c:out value="${alimento.nomeAlimento}"/></td>
                    <td><c:out value="${alimento.calorias}"/></td>
                    <td><c:out value="${alimento.qtdcarboidrato}"/></td>
                     <td><c:out value="${alimento.porcao}"/></td>
                    
                    <td><a href="ManterAlimentoController?acao=prepararEditar&idAlimento=<c:out value="${alimento.idAlimento}" />">Editar</a></td>
                    <td><a href="ManterAlimentoController?acao=prepararExcluir&idAlimento=<c:out value="${alimento.idAlimento}" />">Excluir</a></td>
                </tr>      
            </c:forEach>
        </table>
         </center>   
              <br>
            <br>
             <tr>
              <center><input type="submit" name="bntIncluir" value="Incluir"> <a href="principal.jsp" class="nounderline"><button>Voltar</a></button></center>
              </tr>
              </br>
           </form>
            
      </center> 

    </body>
</html>

