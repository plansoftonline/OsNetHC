<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.plansoftonline.servlet.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cadastro de SLA</title>
	<link rel=stylesheet type="text/css" href="css/estilos.css">  
</head>

<body>

<div id="container">  	
     
<%-- 	<c:import url="cabecalho.jsp"></c:import> --%>
<!-- 	<div id="menu"> -->
<%-- 		<c:import url="menuLateral.jsp"></c:import>  		 --%>
<!-- 	</div>  	 -->
	
	   
	<div id="contents">  		
	   <jsp:useBean id="dao" class="com.plansoftonline.dao.SlaDao"></jsp:useBean>
	 
	   <h1>Manutenção de SLA</h1>

	    <div id="boxmodel2">
		     <hr />
		     <form action="ServletCadSla" method="post">
		         ${msgErro != null ? msgErro : '' }
		         <table cellpadding="2" cellspacing="2">
		          		<tr>
		          			<td>
				          		Código:
				          	</td>
				          	<td>
				          		<input type="text" name="txtCodigo" size="5" value="${ (empty txtCodigo) ? null : txtCodigo }"> <br>
				          	</td>
				         </tr>
				          	
				         <tr>
		          			<td>
				          		Descrição:
				          	</td>
				          	<td>
			  		            <input type="text" name="txtDescricao" size="100" maxlength="100" value="${txtDescricao}" > <br>
			  		        </td>
			  		     </tr>
			  		     
				         <tr>
		          			<td>
					          Tempo (min):
				          	</td>
				          	<td>
					          <input type="text" name="txtTempo" size="20" maxlength="14" value="${txtTempo}"> <br>
			  		        </td>
			  		     </tr>
				          
				         <tr>
		          			<td>
					          Criado em:
				          	</td>
				          	<td>
					          <input type="text" name="txtData" size="10" maxlength="10" value="${txtData}"
					                 title="Campo no formato dd/mm/yyyy"> <br>
			  		        </td>
			  		     </tr>

				         <tr>
		          			<td>
						          <input type="submit" name="txtConfirma" value="Gravar">
				          	</td>
				          	<td>
						          <input type="reset" name="txtLimpa" value="Limpar" >
			  		        </td>
			  		     </tr>
		          </table>
		     </form>
		     <hr />
	    </div>
	</div>
<%-- 	<c:import url="rodape.jsp"></c:import> --%>
	  	
</div>

     
</body>
</html>