<%-- 
    Document   : manterAtleta
    Created on : 18/10/2016, 14:28:34
    Author     : Usuário
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                var caracteresValidos = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ çâãá";
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
                if (form.idFuncionario.value == ""){
                    mensagem = mensagem + "Informe o Id\n";
                }
                if (!campoNumerico(form.idFuncionario.value)){
                    mensagem = mensagem + "O ID deve ser numerico\n";
                }
                if (form.nome.value == ""){
                    mensagem = mensagem + "Informe o Nome do Funcionario\n";
                }
                if (!campoString(form.nome.value)){
                    mensagem = mensagem + "O nome deve ser texto\n";
                } 
                if (form.telefone.value == ""){
                    mensagem = mensagem + "Informe o telefone\n";
                }
                if (!campoNumerico(form.telefone.value)){
                    mensagem = mensagem + "O telefone deve ser numerico\n";
                }
                if (form.celular.value == ""){
                    mensagem = mensagem + "Informe o celular\n";
                }
                if (!campoNumerico(form.celular.value)){
                    mensagem = mensagem + "O celular deve ser numerico\n";
                }
                if (form.logradouro.value == ""){
                    mensagem = mensagem + "Informe o Logradouro\n";
                }
                if (!campoString(form.logradouro.value)){
                    mensagem = mensagem + "O Logradouro deve ser texto\n";
                } 
                
                if (form.bairro.value == ""){
                    mensagem = mensagem + "Informe o Bairro\n";
                }
                if (!campoString(form.bairro.value)){
                    mensagem = mensagem + "O Bairro deve ser texto\n";
                } 
                if (form.cidade.value == ""){
                    mensagem = mensagem + "Informe a Cidade\n";
                }
                if (!campoString(form.cidade.value)){
                    mensagem = mensagem + "Cidade deve ser texto\n";
                } 
                if (form.uf.value == ""){
                    mensagem = mensagem + "Informe a UF\n";
                }
                if (!campoString(form.uf.value)){
                    mensagem = mensagem + "Uf deve ser texto\n";
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
        <meta charset= "utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <center>
        <title>Manter Funcionário</title>
        <style type="text/css"> 
           table{width:100%;margin:0;padding:0;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;color:#1c5d79}table,td,th,tr{border-collapse:collapse}caption{margin:0;padding:0;background:#f3f3f3;height:40px;line-height:40px;text-indent:28px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:left;letter-spacing:3px;border-top:dashed 1px #c2c2c2;border-bottom:dashed 1px #c2c2c2}thead{background-color:#FFF;border:none}thead tr th{height:32px;line-height:32px;text-align:center;color:#1c5d79;background-image:url(col_bg_new.gif);background-repeat:repeat-x;border-left:solid 1px #F90;border-right:solid 1px #F90;border-collapse:collapse}tbody tr{background:#dfedf3;font-size:13px}tbody tr.odd{background:azure}tbody tr.odd:hover,tbody tr:hover{background:#fff}tbody tr td,tbody tr th{padding:6px;border:1px solid #326e87}tbody tr th{background:#1c5d79;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:12px;padding:6px;text-align:center;font-weight:700;color:#FFF;border-bottom:solid 1px #fff}tbody tr th:hover{background:#fff}table a{color:#F60;text-decoration:none;font-size:13px;border-bottom:solid 1px #fff}table a:hover{color:#F90;border-bottom:none}tfoot{background:#f3f3f3;height:24px;line-height:24px;font-family:"Trebuchet MS",Trebuchet,Arial,sans-serif;font-size:14px;font-weight:700;color:#555d6d;text-align:center;letter-spacing:3px;border-top:solid 2px #326e87;border-bottom:dashed 1px #c2c2c2}tfoot tr th{border-top:solid 1px #326e87}tfoot tr td{text-align:right}
           </style>
    </head>
    <body>
        <div aligan="center">
                <h1>Manter Funcionario- ${operacao}</h1>
                <form id="testForm" action="ManterFuncionarioController?acao=confirmar${operacao}" method="post" >
                    <table>
                        <tr>
                            <td>Código do Funcionario</td> 
                            <td><input type="text" name="idFuncionarios" value="${funcionario.idFuncionarios}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if></td>
                        </tr>
                        <tr>
                            <td>Nome:</td> 
                            <td><input type="text" name="nomeFuncionario" value="${funcionario.nomeFuncionario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                        
                         <tr>
                            <td>Nascimento:</td> 
                            <td><input type="text" name="nascimento" value="${funcionario.nascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                                                
                        <tr>
                            <td>Cpf:</td> 
                            <td><input type="text" name="cpf" value="${funcionario.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                      
                         <tr>
                            <td>Rg:</td> 
                            <td><input type="text" name="rg" value="${funcionario.rg}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                       <tr>
                            <td>Sexo:</td> 
                            <td><input type="text" name="sexo" value="${funcionario.sexo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                       <tr>
                            <td>Telefone:</td> 
                            <td><input type="text" name="telefone" value="${funcionario.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                       <tr>
                            <td>Celular:</td> 
                            <td><input type="text" name="celular" value="${funcionario.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                      
                        <tr>
                            <td>Senha:</td> 
                            <td><input type="text" name="senha" value="${funcionario.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                        <tr>
                            <td>Login:</td> 
                            <td><input type="text" name="login" value="${funcionario.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                        <tr>
                            <td>Logradouro:</td> 
                            <td><input type="text" name="logradouro" value="${funcionario.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                         <tr>
                            <td>Bairro:</td> 
                            <td><input type="text" name="bairro" value="${funcionario.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                         <tr>
                            <td>Cidade:</td> 
                            <td><input type="text" name="cidade" value="${funcionario.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
                         <tr>
                            <td>Uf:</td> 
                            <td><input type="text" name="uf" value="${funcionario.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if></td>
                        </tr>
             
                        <tr>
                            <td>Cargo Atual:</td> 
                            <td>
                                <select name="idCargo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                    <option value="0" <c:if test="${funcionario.cargo == null}"> selected</c:if>> </option>  
                                    <c:forEach items="${cargos}" var="cargo">
                                        <option value="${cargo.idCargo}" <c:if test="${funcionario.cargoa.idCargo == cargo.idCargo}"> selected</c:if>>${cargo.nomeCargo}</option>  
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>   
                        
                        
                         <tr>
                            <td>Corrida:</td> 
                            <td>
                                <select name="idCorrida" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                    <option value="0" <c:if test="${funcionario.corrida == null}"> selected</c:if>> </option>  
                                    <c:forEach items="${corridas}" var="corrida">
                                        <option value="${corrida.idCorrida}" <c:if test="${funcionario.corrida.idCorrida == corrida.idCorrida}"> selected</c:if>>${corrida.idCorrida}</option>  
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
