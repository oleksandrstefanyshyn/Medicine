package com.ss.edu.controller.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.edu.dto.LoginDto;
import com.ss.edu.dto.PatientMedicineDto;
import com.ss.edu.tool.Context;

@WebServlet("/patientmedicines")
public class PatientMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
   
    public PatientMedicineServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("medicineDto");
		String loginname = (String) request.getSession().getAttribute("login");
		
		if (loginname != null && (!loginname.isEmpty())) {
			LoginDto loginDto = new LoginDto(loginname, new String());
			PatientMedicineDto patientMedicineDto = Context.getInstance().getPatientMedicineService()
														.getPatientMedicines(loginDto);
			request.setAttribute("patientMedicineDto", patientMedicineDto);			
			request.getRequestDispatcher("/WEB-INF/view/common/patientMedicines.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Access Denied! Log in first");			
			request.getRequestDispatcher("/WEB-INF/view/patient/login.jsp").forward(request, response);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
