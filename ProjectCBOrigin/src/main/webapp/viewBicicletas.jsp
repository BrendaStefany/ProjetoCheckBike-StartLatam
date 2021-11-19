<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualização de Bicicletas</title>
</head>

<body>
	<%@ page
		import="com.crudjspjava.dao.BicicletaDao, com.crudjspjava.bean.Bicicleta, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<h1>Listagem de Bicicletas</h1>

	<%
	List<Bicicleta> list = BicicletaDao.getAllBicicletas();
	request.setAttribute("list", list);
	%>

	<table>
		<tr>
			<th>ID</th>
			<th>Descrição</th>
			<th>Modelo</th>
		</tr>
		<c:forEach items="${list}" var="bicicletas">
			<tr>
				<td>${bicicletas.getId}</td>
				<td>${bicicletas.getDescricao}</td>
				<td>${bicicletas.getModelo}</td>

			</tr>
		</c:forEach>
	</table>


</body>
</html>