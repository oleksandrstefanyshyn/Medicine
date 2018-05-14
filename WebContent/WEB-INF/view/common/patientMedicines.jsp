<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<c:set var="pageTitle" value="List of Medicines" scope="request"/>
<c:import url="/WEB-INF/view/common/Top.jsp" charEncoding="utf-8" />
	
	<main>
		<div class="container">
		
		  	<div class="row center">
		  		<h5>List of Medicines:</h5> 
		  	</div>
		
			<div class="row left">	 
				<i class="material-icons center">
					<a href="${base}/medicinecreate?login=${patientMedicineDto.patientLogin}" 
							id="download-button" 
							class="btn-large col s12 waves-effect waves-light pink darken-4">
							 		Add Medicine
					</a>		 	
				</i>				 			 
			</div>	
			
			<div class="row center">
				<div class="col s12">
					<c:choose>    
					    <c:when test="${!empty patientMedicineDto.medicines}">
					    	<table class="striped" width=100%>
								<tr>
									<th width=5%>Position</th>
									<th width=25%>Title</th>
									<th width=50%>Description</th>
									<th width=10%></th>
									<th width=10%></th>
								</tr>
									<c:forEach items="${patientMedicineDto.medicines}" var="medicine"
										varStatus="count">
										<tr>
											<td>${count.count}</td>
											<td>${medicine.title}</td>
											<td>${medicine.description}</td>
											<td>
												<i class="material-icons center">
													<a href="${base}/medicineedit?login=${patientMedicineDto.patientLogin}&id=${medicine.id}" 
														id="download-button" 
														class="btn-small col s12 waves-effect waves-light pink darken-4">
							 							Edit
													</a>		 	
												</i>		
											</td>
											<td>
												<i class="material-icons center">
													<a href="${base}/medicinedelete?id=${medicine.id}" 
														id="download-button" 
														class="btn-small col s12 waves-effect waves-light pink darken-4">
							 							Delete
													</a>		 	
												</i>		
											</td>
										</tr>
									</c:forEach>
							</table>
					    </c:when>
					    <c:otherwise>
					    	<h4>Medicine's list is empty! Please add medicine</h4>
					    </c:otherwise>
					</c:choose>
				</div>	
			</div> 
		</div>	
	</main>			    
<c:import url="/WEB-INF/view/common/Footer.jsp" charEncoding="utf-8" />		