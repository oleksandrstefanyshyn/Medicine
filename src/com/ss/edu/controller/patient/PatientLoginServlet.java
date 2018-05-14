package com.ss.edu.controller.patient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.edu.dto.LoginDto;
import com.ss.edu.tool.Context;

@WebServlet("/login")
public class PatientLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public PatientLoginServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/patient/login.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = (request.getParameter("login") != null)
	              && (!request.getParameter("login").isEmpty())
	              && (request.getParameter("password") != null)
	              && (!request.getParameter("password").isEmpty());
		
		if (result) {
			LoginDto loginDto = new LoginDto(request.getParameter("login"), request.getParameter("password"));
			result = Context.getInstance().getLoginService().
					isLogged(loginDto);
		}		
		
		if (result) {
			request.getSession().setAttribute("login", request.getParameter("login"));
			//request.getRequestDispatcher("/patientdoctors").forward(request, response);
			response.sendRedirect("/HospitalNewWeb/patientmedicines");
		} else {			
			request.setAttribute("errorMessage", "Invalid login or password, try again");
		//	System.out.println("Invalid PatientName or Password");
			//Replece /WEB-INF/view/login.jsp on /login
			request.getRequestDispatcher("/WEB-INF/view/patient/login.jsp").forward(request, response);
		}
	}
}
