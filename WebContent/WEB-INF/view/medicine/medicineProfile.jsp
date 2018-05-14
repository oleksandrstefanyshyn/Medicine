<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<c:set var="pageTitle" value="Medicine profile" scope="request"/>
<c:import url="/WEB-INF/view/common/Top.jsp" charEncoding="utf-8" />
	
<main>	
	<div class="container maxwidth800">
		<div class="row center">
			<c:choose>
				<c:when test="${medicineDto == null}">
				<h5>Add Medicine, please</h5>
				</c:when>
				<c:otherwise>
				<h5>Editing medicine:</h5>	
				</c:otherwise>
			</c:choose>	
		</div>
		
		<div class="row center">
		<c:choose>
			<c:when test="${medicineDto != null}">
					<form action="${base}/medicineedit" method="post">
			</c:when>
			<c:otherwise>
					<form action="${base}/medicinecreate" method="post">
			</c:otherwise>
		</c:choose>
			
			<input type="text" name="title" placeholder="Title: " 
					value="${medicineDto.title}">
		</div>		
		<div class="row center">	
			<input type="text" name="description"	 placeholder="Description:"
					value="${medicineDto.description}">
		</div>			
		<div class="row center">		
			<button
				class="btn col s12 waves-effect waves-light indigo darken-4"
				type="submit" name="ok" value="Submit">
				<i class="material-icons center">Submit</i>
			</button>	
		</div>
		<div class="row center">
			<i class="material-icons center">
				<a href="${base}/patientmedicines"
				id="download-button"
				class="btn-large col s12 waves-effect waves-light pink darken-4">
				Cancel
				</a>			 	
				</i>					
		</div>	
		</form>
	</div>	
</main>		
<c:import url="/WEB-INF/view/common/Footer.jsp" charEncoding="utf-8" />