<%-- 
    Created on : 11/10/2016, 10:18:06
    Author     : Juliana
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
            var caracteresValidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ  ";
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
            if (form.idSuprimento.value == "") {
                mensagem = mensagem + "Informe o Id\n";
            }
            if (!campoNumerico(form.idSuprimento.value)) {
                mensagem = mensagem + "O ID deve ser numerico\n";
            }
            if (form.nome.value == "") {
                mensagem = mensagem + "Informe o Nome do Suprimento\n";
            }
            if (!campoString(form.nome.value)) {
                mensagem = mensagem + "O nome deve ser texto\n";
            }
            if (form.descricao.value == "") {
                mensagem = mensagem + "Informe a Descricao do Cargo\n";
            }
            if (!campoString(form.descricao.value)) {
                mensagem = mensagem + "A Descricao deve ser texto\n";
            }
            if (form.quantidade.value == "") {
                mensagem = mensagem + "Informe a quantidade \n";
            }
            if (!campoNumerico(form.quantidade.value)) {
                mensagem = mensagem + "A quantidade deve ser numerico\n";
            }
            if (form.marca.value == "") {
                mensagem = mensagem + "Informe a marca do Suprimento\n";
            }
            if (!campoString(form.marca.value)) {
                mensagem = mensagem + "A marca deve ser texto\n";
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
        <title>Manter Suprimento</title>
        <style type="text/css"> 
            table{width:100%;margin:0;padding:0;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;color:#1c5d79}table,td,th,tr{border-collapse:collapse}caption{margin:0;padding:0;background:#f3f3f3;height:40px;line-height:40px;text-indent:28px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:left;letter-spacing:3px;border-top:dashed 1px #c2c2c2;border-bottom:dashed 1px #c2c2c2}thead{background-color:#FFF;border:none}thead tr th{height:32px;line-height:32px;text-align:center;color:#1c5d79;background-image:url(col_bg_new.gif);background-repeat:repeat-x;border-left:solid 1px #F90;border-right:solid 1px #F90;border-collapse:collapse}tbody tr{background:#dfedf3;font-size:13px}tbody tr.odd{background:azure}tbody tr.odd:hover,tbody tr:hover{background:#fff}tbody tr td,tbody tr th{padding:6px;border:1px solid #326e87}tbody tr th{background:#1c5d79;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:12px;padding:6px;text-align:center;font-weight:700;color:#FFF;border-bottom:solid 1px #fff}tbody tr th:hover{background:#fff}table a{color:#F60;text-decoration:none;font-size:13px;border-bottom:solid 1px #fff}table a:hover{color:#F90;border-bottom:none}tfoot{background:#f3f3f3;height:24px;line-height:24px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:center;letter-spacing:3px;border-top:solid 2px #326e87;border-bottom:dashed 1px #c2c2c2}tfoot tr th{border-top:solid 1px #326e87}tfoot tr td{text-align:right}
        </style>
    </head>
    <body>
        <div aligan="center">
            <h1>Manter Suprimento - ${operacao}</h1>
            <form id="testForm" action="ManterSuprimentoController?acao=confirmar${operacao}" method="post"onsubmit="return validarFormulario(this)">
                <table>
                    <tr>
                        <td>Código do Suprimento</td> 
                        <td><input type="text" name="idSuprimento" value="${suprimento.idSuprimento}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td>Nome do Suprimento:</td> 
                            <td><input type="text" name="nomeSuprimento" value="${suprimento.nomeSuprimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>

                        <tr>
                            <td> Descricao:</td> 
                            <td><input type="text" name="descricao" value="${suprimento.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr> 
                            <td>Quantidade:</td> 
                            <td align="left"><input name="quantidade" type="number" value="${suprimento.quantidade}"  min="1" size="100"> </td>

                    </tr>
                    
                    <tr> 
                        <td>Marca:</td> 
                        <td><input type="text" name="marca" value="${suprimento.marca}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                      <tr>
                            <td>Corrida:</td> 
                            <td>
                                <select name="idCorrida" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                    <option value="0" <c:if test="${suprimento.corridaidCorrida == null}"> selected</c:if>> </option>  
                                    <c:forEach items="${corridas}" var="corrida">
                                        <option value="${corrida.idCorrida}" <c:if test="${suprimento.corridaidCorrida.idCorrida == corrida.idCorrida}"> selected</c:if>>${corrida.nomeCorrida}</option>  
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>     
                </table>
                    <center>
                    <button type="submit">Confirmar</button>
                    <button type="reset">Apagar</button>
                </center>
            </form>                
        </div>
    </body>
</html>
