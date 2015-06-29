<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page language="java" import="com.plansoftonline.dao.SlaDao" %>
<%@ page language="java" import="com.plansoftonline.beans.*" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel=stylesheet type="text/css" href="css/estilos.css">  
</head>

<body>
    
<div id="container">  	
     
	<div id="contents">  		
	   <jsp:useBean id="dao" class="com.plansoftonline.dao.SlaDao"></jsp:useBean>
	 
	   <h1>Manutenção de Sla's</h1>
	  
	   <div id="boxmodel2">
	   		<form action="consultaSla" method="post">
	   		       Código: <input type="text" name="txtCodigo" size="10">
	   		       Descrição: <input type="text" name="txtDescricao" size="40">
	   		       <p>
	   		       <input type="submit" value="Consultar">
	   		</form>
       </div>
	   

	   <div id="boxmodel2">
		   <table border="1" cellpadding="1" cellspacing="1" class="tabela" width="90%">
			   <caption>Tabela de Slas</caption>
			   <tr>
			   	   <th colspan="2">Opções</th>
			   	   <th>Código</th>
			       <th>Descrição</th>
			       <th>Tempo (min)</th>
			       <th>Criado em</th>
			       
			   </tr>
		
			   <c:forEach items="${lista}" var="sla">

			   		<tr>
			   			<td width="2%">
			                 <a href="altSla?id=${sla.codigo}&descricao=${sla.descricao}&tempo=${sla.tempo}&data=${sla.criado_em}"><img alt="alterar" src="images/alterar.jpg"/></a>
			            </td>
			   			<td width="2%">
			                 <a href="excluiSla?id=${sla.codigo}" onclick="if (!confirm('Confirma a exclusão desse Sla?')) return false"><img alt="excluir" src="images/excluir.jpg"/></a>
			            </td>
			   		
			   			<td width="5%">
			                 ${sla.codigo}
			            </td>
			   			<td width="30%">
			                 ${sla.descricao}
			            </td>
			   			<td width="15%">
			                 ${sla.tempo}
			            </td>
			   			<td width="10%">
			                 ${sla.criado_em}
			            </td>
			        </tr>
			   </c:forEach>
	   </table>
	   </div>
	   <a href="cadastroSla.jsp"><img alt="novo" src="images/novo.jpg"/></a>
	</div>
	
	  	
</div>


 
     
</body>

</html>