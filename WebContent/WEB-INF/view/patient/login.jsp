<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<c:set var="pageTitle" value="Login" scope="request"/>
<c:import url="/WEB-INF/view/common/Top.jsp" charEncoding="utf-8" />
<main>
	<div class="container maxwidth600">
		<form action="${base}/login" class="col" method="post">
			<div class="row center">
				<h5 class="header col s12 light"></h5>
				<input class="header col s12 light" type="text" name="login" placeholder="Login:">
			</div>
			<div class="row center">
				<h5 class="header col s12 light"></h5>	
				<input class="header col s12 light" type="password" name="password" placeholder="Password:">
			</div>	
			<div class="row center">
				<h5 class="header col s12 light"></h5>	
				<button
				class="btn col s12 waves-effect waves-light indigo darken-4"
				type="submit" name="ok" value="Sign In">
				<i class="material-icons center">Submit</i>
				</button>
			</div>	
			<div class="row center">
				<i class="material-icons center"> <a href="${base}/patientcreate"
				id="download-button"
				class="btn-large col s12 waves-effect waves-light indigo darken-4 registerbutton">Register</a>
				</i>
			</div>	
		</form>	
	</div>	
</main>
<c:import url="/WEB-INF/view/common/Footer.jsp" charEncoding="utf-8" />