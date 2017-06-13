<%-- 
 
    Created on : 11/10/2016, 10:18:06
        Author     :    Juliana
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <SCRIPT language="JavaScript">

        function campoNumerico(valor)
        {
            var caracteresValidos = "0123456789";
            var ehNumero = true;
            var umCaracter;
            for (i = 0; i < valor.length && ehNumero == true; i++)
            {
                umCaracter = valor.charAt(i);
                if (caracteresValidos.indexOf(umCaracter) == -1)
                {
                    ehNumero = false;
                }
            }
            return ehNumero;
        }

        function campoString(valor)
        {
            var caracteresValidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
            var ehString = true;
            var umCaracter;
            for (i = 0; i < valor.length && ehString == true; i++)
            {
                umCaracter = valor.charAt(i);
                if (caracteresValidos.indexOf(umCaracter) == -1)
                {
                    ehString = false;
                }
            }
            return ehString;
        }
        function validarFormulario(form) {
            var mensagem;
            mensagem = "";
            if (form.idAlimento.value == "") {
                mensagem = mensagem + "Informe o Id\n";
            }
            if (!campoNumerico(form.idAlimento.value)) {
                mensagem = mensagem + "O ID deve ser numerico\n";
            }
            if (form.nome.value == "") {
                mensagem = mensagem + "Informe o Nome do Alimento\n";
            }
            if (!campoString(form.nome.value)) {
                mensagem = mensagem + "O nome deve ser texto\n";
            }
            if (form.calorias.value == "") {
                mensagem = mensagem + "Informe a Caloria do Alimento\n";
            }
            if (!campoNumerico(form.calorias.value)) {
                mensagem = mensagem + "A Caloria deve ser numerico\n";
            }
            if (form.qtdcarboidrato.value == "") {
                mensagem = mensagem + "Informe a quantidade de Carboitrado\n";
            }
            if (!campoNumerico(form.qtdcarboidrato.value)) {
                mensagem = mensagem + "A quantidade deve ser numerico\n";
            }
            if (form.porcao.value == "") {
                mensagem = mensagem + "Informe a porção do alimento\n";
            }
            if (!campoNumerico(form.porcao.value)) {
                mensagem = mensagem + "A porção deve ser numerico\n";
            }

            if (mensagem == "") {
                return true;
            } else {
                alert(mensagem);
                return false;
            }
        }

        function enviarFormulario(form)
        {
            if (validarFormulario(form))
                form.submit();
        }


    </SCRIPT>

    <head>
        <meta charset= "utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <center>
        <title>Manter Alimento</title>
        <style type="text/css"> 
            table{width:100%;margin:0;padding:0;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;color:#1c5d79}table,td,th,tr{border-collapse:collapse}caption{margin:0;padding:0;background:#f3f3f3;height:40px;line-height:40px;text-indent:28px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:left;letter-spacing:3px;border-top:dashed 1px #c2c2c2;border-bottom:dashed 1px #c2c2c2}thead{background-color:#FFF;border:none}thead tr th{height:32px;line-height:32px;text-align:center;color:#1c5d79;background-image:url(col_bg_new.gif);background-repeat:repeat-x;border-left:solid 1px #F90;border-right:solid 1px #F90;border-collapse:collapse}tbody tr{background:#dfedf3;font-size:13px}tbody tr.odd{background:azure}tbody tr.odd:hover,tbody tr:hover{background:#fff}tbody tr td,tbody tr th{padding:6px;border:1px solid #326e87}tbody tr th{background:#1c5d79;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:12px;padding:6px;text-align:center;font-weight:700;color:#FFF;border-bottom:solid 1px #fff}tbody tr th:hover{background:#fff}table a{color:#F60;text-decoration:none;font-size:13px;border-bottom:solid 1px #fff}table a:hover{color:#F90;border-bottom:none}tfoot{background:#f3f3f3;height:24px;line-height:24px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:center;letter-spacing:3px;border-top:solid 2px #326e87;border-bottom:dashed 1px #c2c2c2}tfoot tr th{border-top:solid 1px #326e87}tfoot tr td{text-align:right}
        </style>




    </head>
    <body>
        <div aligan="center">
            <h1>Manter Alimento - ${operacao}</h1>
            <form id="testForm" action="ManterAlimentoController?acao=confirmar${operacao}" method="post" >
                <table>
                    <tr>
                        <td>Código do Alimento</td> 
                        <td><input type="text" name="idAlimento" value="${alimento.idAlimento}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td>Nome do Alimento:</td> 
                            <td><input type="text" name="nomeAlimento" value="${alimento.nomeAlimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td>Quantidade de Calorias:</td> 
                            <td><input type="text" name="calorias" value="${alimento.calorias}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td> Quantidade de Carboidrato:</td> 
                            <td><input type="text" name="qtdcarboidrato" value="${alimento.qtdcarboidrato}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr> 
                            <td>Quantidade de Porção:</td> 
                            <td align="left"><input name="porcao" type="number" value="${alimento.porcao}"  min="1" size="100"> </td>
                    </tr>


                    <tr>
                        <td>Suprimento:</td> 
                        <td>
                            <select name="idSuprimento" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="0" <c:if test="${alimento.suprimentoidSuprimento == null}"> selected</c:if>> </option>  
                                <c:forEach items="${suprimentos}" var="suprimento">
                                    <option value="${suprimento.idSuprimento}" <c:if test="${alimento.suprimentoidSuprimento.idSuprimento == suprimento.idSuprimento}"> selected</c:if>>${suprimento.idSuprimento}</option>  
                                </c:forEach>
                            </select>
                        </td>
                    </tr> 
                    <tr>
                    <br>   
                    <td><td colspan = "2" align="left">
                        <input type="submit" name="btnConfirmar" value="Confirmar" onclick="enviarFormulario(document.getElementById('testForm'))"> 
                        <input type="reset" value="Apagar">
                        </center></td>

                    </br>   
                    </tr> 


                </table>
            </form>                
        </div>
    </body>
</html>
