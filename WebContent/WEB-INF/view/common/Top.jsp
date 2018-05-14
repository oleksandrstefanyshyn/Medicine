<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css">
<link type="text/css" rel="stylesheet" href="resources/css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>${pageTitle}</title>
</head>
<body>
	<nav class="teal accent-3" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="${base}/patientmedicines" class="brand-logo">MEDICINE LIST</a>
			<ul class="right hide-on-med-and-down">
				<li><a class="purple-text text-darken-4" href="${base}/patientedit?login=${patientMedicineDto.patientLogin}">${patientMedicineDto.patientLogin}</a></li>
				<li><a href="${base}/logout">Logout</a></li>
			</ul>
		</div>
	</nav>