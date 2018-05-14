package com.ss.edu.controller.patient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.edu.dto.PatientDto;
import com.ss.edu.tool.Context;

@WebServlet("/patientedit")
public class PatientProfileEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatientProfileEditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		PatientDto patientDto = Context.getInstance().getPatientProfileService().getPatientDto(login);
		if (patientDto != null) {
			request.getSession().setAttribute("patientDto", patientDto);
		}
		request.getRequestDispatcher("/WEB-INF/view/patient/patientProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean result = validationPatient("name", "login", "password", "age", request);
		
		if (result) {
			PatientDto patientDto = new PatientDto(
										Long.parseLong(request.getParameter("id")),
										request.getParameter("name"), 
										request.getParameter("login"), 
										request.getParameter("password"),
										Integer.parseInt(request.getParameter("age")));
			result = Context.getInstance().getPatientProfileService().setPatientDto(patientDto);
		}
		if (result) {
			response.sendRedirect("/HospitalNewWeb/login");
			//request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		} else {
			request./*getSession().*/setAttribute(/*"errorPatientProfile"*/"errorMessage" , "Can't edit patient, try again");
			request.getRequestDispatcher("/WEB-INF/view/patient/patientProfile.jsp").forward(request, response);
		}
	}
	
	private boolean validationPatient(String name, String login, String password, String age, HttpServletRequest request) {
		boolean result = 
		request.getParameter(name) != null
				&& !request.getParameter(name).isEmpty()
				&& request.getParameter(login) !=null
				&& !request.getParameter(login).isEmpty()
				&& request.getParameter(password) !=null
				&& !request.getParameter(password).isEmpty()
				&& request.getParameter(age) !=null
				&& !request.getParameter(age).isEmpty();
		return result;
	}
}
