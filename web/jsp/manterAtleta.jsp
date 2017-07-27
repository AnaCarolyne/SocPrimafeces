<%-- 
    Document   : manterAdministrador
    Created on : 11/10/2016, 10:18:06
    Author     : Math
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
                var caracteresValidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ @";
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
                if (form.idAtleta.value == ""){
                    mensagem = mensagem + "Informe o Id\n";
                }
                if (!campoNumerico(form.idAtleta.value)){
                    mensagem = mensagem + "O ID deve ser numerico\n";
                }
                if (form.nome.value == ""){
                    mensagem = mensagem + "Informe o Nome do Alimento\n";
                }
                if (!campoString(form.nome.value)){
                    mensagem = mensagem + "O nome deve ser texto\n";
                } 
                
                if (form.logradouro.value == ""){
                    mensagem = mensagem + "Informe o Logradouro\n";
                }
                if (!campoString(form.logradouro.value)){
                    mensagem = mensagem + "O logradouro deve ser texto\n";
                } 
                
                if (form.numero.value == ""){
                    mensagem = mensagem + "Informe o numero\n";
                }
                if (!campoNumerico(form.numero.value)){
                    mensagem = mensagem + "O numero deve ser numerico\n";
                }
                
                
                
                if (form.bairro.value == ""){
                    mensagem = mensagem + "Informe o Bairro\n";
                }
                if (!campoString(form.bairro.value)){
                    mensagem = mensagem + "O bairro deve ser texto\n";
                } 
                
                if (form.cidade.value == ""){
                    mensagem = mensagem + "Informe a Cidade\n";
                }
                if (!campoString(form.cidade.value)){
                    mensagem = mensagem + "A cidade deve ser texto\n";
                } 
                
                if (form.estado.value == ""){
                    mensagem = mensagem + "Informe o Estado\n";
                }
                if (!campoString(form.estado.value)){
                    mensagem = mensagem + "O Estado deve ser texto\n";
                } 
                
                if (form.cpf.value == ""){
                    mensagem = mensagem + "Informe o Cpf\n";
                }
                if (!campoNumerico(form.idAtleta.value)){
                    mensagem = mensagem + "O cpf deve ser numerico\n";
                }
                
                if (form.telefone.value == ""){
                    mensagem = mensagem + "Informe o telefone\n";
                }
                if (!campoNumerico(form.telefone.value)){
                    mensagem = mensagem + "O telefone deve ser numerico\n";
                }
                if (form.celular.value == ""){
                    mensagem = mensagem + "Informe o Celular\n";
                }
                if (!campoNumerico(form.celular.value)){
                    mensagem = mensagem + "O celular deve ser numerico\n";
                }
                if (form.portDeficiencia.value == ""){
                    mensagem = mensagem + "Para SIM digite 1, NÃo digite 0\n";
                }
                if (!campoNumerico(form.portDeficiencia.value)){
                    mensagem = mensagem + "O Portador de Deficiencia deve ser 1 para SIM ou 0 para NAO\n";
                }
                if (form.contEmergencia.value == ""){
                    mensagem = mensagem + "Informe o Contado de Emergencia\n";
                }
                if (!campoNumerico(form.contEmergencia.value)){
                    mensagem = mensagem + "O Contato de Emergencia deve ser numerico\n";
                }
                if (form.cep.value == ""){
                    mensagem = mensagem + "Informe o Cep\n";
                }
                if (!campoNumerico(form.cep.value)){
                    mensagem = mensagem + "O cep deve ser numerico\n";
                }
                
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            
            function enviarFormulario(form)
            {
                if (validarFormulario(form)) form.submit();
            }
            
    </SCRIPT>
    <head>
        <head>
        <meta charset= "utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <center>
        <title>Manter Atleta</title>
        <style type="text/css"> 
           table{width:100%;margin:0;padding:0;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;color:#1c5d79}table,td,th,tr{border-collapse:collapse}caption{margin:0;padding:0;background:#f3f3f3;height:40px;line-height:40px;text-indent:28px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:left;letter-spacing:3px;border-top:dashed 1px #c2c2c2;border-bottom:dashed 1px #c2c2c2}thead{background-color:#FFF;border:none}thead tr th{height:32px;line-height:32px;text-align:center;color:#1c5d79;background-image:url(col_bg_new.gif);background-repeat:repeat-x;border-left:solid 1px #F90;border-right:solid 1px #F90;border-collapse:collapse}tbody tr{background:#dfedf3;font-size:13px}tbody tr.odd{background:azure}tbody tr.odd:hover,tbody tr:hover{background:#fff}tbody tr td,tbody tr th{padding:6px;border:1px solid #326e87}tbody tr th{background:#1c5d79;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:12px;padding:6px;text-align:center;font-weight:700;color:#FFF;border-bottom:solid 1px #fff}tbody tr th:hover{background:#fff}table a{color:#F60;text-decoration:none;font-size:13px;border-bottom:solid 1px #fff}table a:hover{color:#F90;border-bottom:none}tfoot{background:#f3f3f3;height:24px;line-height:24px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:center;letter-spacing:3px;border-top:solid 2px #326e87;border-bottom:dashed 1px #c2c2c2}tfoot tr th{border-top:solid 1px #326e87}tfoot tr td{text-align:right}
           </style>
    </head>
    <body>
        <div aligan="center">
                <h1>Manter Atleta - ${operacao}</h1>
                 <form id="testForm" action="ManterAtletaController?acao=confirmar${operacao}" method="post" >
                    <table>
                        <tr>
                            <td>Código do Atleta</td> 
                            <td><input type="text" name="idAtleta" value="${atleta.idAtleta}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Nome do Atleta:</td> 
                                <td><input type="text" name="nomeAtleta" value="${atleta.nomeAtleta}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Data de Nascimento:</td> 
                                <td><input type="text" name="dataNascimento" value="${atleta.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Logradouro:</td> 
                                <td><input type="text" name="logradouro" value="${atleta.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>numero:</td> 
                                <td><input type="text" name="numero" value="${atleta.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>complemento:</td> 
                                <td><input type="text" name="complemento" value="${atleta.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>bairro:</td> 
                                <td><input type="text" name="bairro" value="${atleta.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>cidade:</td> 
                                <td><input type="text" name="cidade" value="${atleta.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>estado:</td> 
                                <td><input type="text" name="estado" value="${atleta.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>cpf:</td> 
                                <td><input type="text" name="cpf" value="${atleta.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>rg:</td> 
                                <td><input type="text" name="rg" value="${atleta.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            
                            <tr>
                                <td> Sexo:</td> 
                                <td><input type="text" name="sexo" value="${atleta.sexo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Telefone:</td> 
                                <td><input type="text" name="telefone" value="${atleta.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr> 
                                <td>celular:</td> 
                                <td><input type="text" name="celular" value="${atleta.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        
                        
                        <tr> 
                                <td>Portador de Deficiencia:</td> 
                                <td><input type="text" name="portDeficiencia" value="${atleta.portDeficiencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                         <tr> 
                                <td>contEmergencia:</td> 
                                <td><input type="text" name="contEmergencia" value="${atleta.contEmergencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        
                        </tr> <td>login:</td> 
                                <td><input type="text" name="login" value="${atleta.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>senha:</td> 
                                <td><input type="text" name="senha" value="${atleta.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                        <tr> 
                            
                            
                                <td>Email:</td> 
                                <td><input type="text" name="email" value="${atleta.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                         <tr> 
                                <td>cep:</td> 
                                <td><input type="text" name="cep" value="${atleta.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr> 
                                <td>Tipo Sanguineo:</td> 
                                <td><input type="text" name="tipoSanguineo" value="${atleta.tipoSanguineo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        
                        <td>Inscricao</td> 
                            <td>
                                <select name="idInscricao" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                    <option value="0" <c:if test="${atleta.inscricaoidInscricao == null}"> selected</c:if>> </option>  
                                    <c:forEach items="${inscricaos}" var="inscricao">
                                        <option value="${inscricao.idInscricao}" <c:if test="${atleta.inscricaoidInscricao.idInscricao == inscricao.idInscricao}"> selected</c:if>>${inscricao.numeroDePeito}</option>  
                                    </c:forEach>
                                </select>
                            </td>
                        <tr>
                         <br>   
                         <td><td colspan = "2" align="left">
                             <input type="submit" name="btnConfirmar" value="Confirmar" onclick="enviarFormulario(document.getElementById('testForm'))">
                             <input type="reset" value="Apagar"></center></td>
                         
                         </br>   
                    </tr>   
                    </table>
                 </form>                
        </div>
    </body>
</html>