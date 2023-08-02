<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar</title>
</head>
<body>
	
	<h1>Alteração dos Dados do Usuário</h1>
	
	<form method="post" action="alterar">
		Código: <input type="text" name="txtcodigo" value="${usuario.codigo}" readonly required><br><br>
		Nome: <input type="text" name="txtnome" value="${usuario.nome}" required><br><br>
		
		Data de Nascimento: <input type="date" name="txtdatanascimento" 
				value='<fmt:formatDate value="${usuario.dataNascimento}" pattern="yyyy-MM-dd" />' required><br><br>
		
		
		Login: <input type="text" name="txtlogin" value="${usuario.login }" required><br><br>
		Senha: <input type="text" name="txtsenha" value="${usuario.senha }" required><br><br>
		<input type="submit" value="Salvar">
	</form>

</body>
</html>
