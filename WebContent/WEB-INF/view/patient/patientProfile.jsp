<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<c:set var="pageTitle" value="Patient profile" scope="request"/>
<c:import url="/WEB-INF/view/common/Top.jsp" charEncoding="utf-8" />

<main>
	<div class="container maxwidth600">
		<div class="row center">
			<c:choose>
				<c:when test="${patientDto != null}">
					<h5>${patientDto.name}</h5>
				</c:when>					
				<c:otherwise>
					<h5>Creating new patient:</h5>	
				</c:otherwise>
			</c:choose>	
		</div>
		
		<div class="row center" >
			<c:choose>
				<c:when test="${patientDto != null}">
					<form action="${base}/patientedit" method="post">
				</c:when>
				<c:otherwise>
					<form action="${base}/patientcreate" method="post">
				</c:otherwise>
			</c:choose>
				<div class="row center">
					<input type="hidden" name="id" value="${patientDto.id}">
					<input type="text" name="name" placeholder="Name: " value="${patientDto.name}">
				</div>	
				
				<div class="row center">
					<input type="text" name="login" placeholder="Login: " value="${patientDto.login}">
				</div>
	
				<div class="row center">
					<input type="password" name="password" placeholder="Password: ">
				</div>			
				
				<div class="row center">
					<input type="text" name="age" placeholder="Age: ">	
				</div>
					
				<div class="row center">
					<button
						class="btn col s12 waves-effect waves-light indigo darken-4"
						type="submit" name="ok" value="Submit">
						<i class="material-icons center">Submit</i>
					</button>
				</div>	
				
				<div class="row center">	 
					 <c:if test="${patientDto != null}" >
					 	<i class="material-icons center">
					 	<a href="${base}/patientmedicines"
					 	id="download-button"
					 	class="btn-large col s12 waves-effect waves-light pink darken-4">
					 	Cancel</a>			 	
						</i>			 
					 </c:if>
				</div>	 
				
				<div class="row center">	 
					 <c:if test="${patientDto == null}" >
					 	<i class="material-icons center">
					 	<a href="${base}/login"
					 	id="download-button"
					 	class="btn-large col s12 waves-effect waves-light pink darken-4">
					 	Cancel</a>			 	
						</i>			 
					 </c:if>
				</div>	 
		</div>	
	</div>		  
</main>				
<c:import url="/WEB-INF/view/common/Footer.jsp" charEncoding="utf-8" />