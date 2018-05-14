package com.ss.edu.controller.medicine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.edu.dto.MedicineDto;
import com.ss.edu.dto.LoginDto;
import com.ss.edu.dto.PatientMedicineDto;
import com.ss.edu.dto.PatientDto;
import com.ss.edu.tool.Context;

@WebServlet("/medicinecreate")
public class MedicineProfileCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MedicineProfileCreateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("medicineDto");
		String login = request.getParameter("login");
		PatientDto patientDto = Context.getInstance().getPatientProfileService().getPatientDto(login);
		if (patientDto != null) {
			request.getSession().setAttribute("patientLogin", patientDto.getLogin());
		}
		request.getRequestDispatcher("/WEB-INF/view/medicine/medicineProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result = validationMedicine("title", "description", request);
		
		String paientLogin = (String) request.getSession().getAttribute("patientLogin");
		if (result) {
			PatientDto patientDto = Context.getInstance().getPatientProfileService().getPatientDto(paientLogin);
			MedicineDto medicineDto = new MedicineDto(-1L, request.getParameter("title"), 
													 request.getParameter("description"),
													 patientDto.getId());
			result = Context.getInstance().getMedicineService().setMedicineDto(medicineDto);
		}
		if (result) {
			LoginDto loginDto = new LoginDto(paientLogin, new String());
			PatientMedicineDto patientMedicineDto = Context.getInstance()
					.getPatientMedicineService().getPatientMedicines(loginDto);
			request.getSession().setAttribute("patientMedicineDto", patientMedicineDto);
			response.sendRedirect("/HospitalNewWeb/patientmedicines");
			//request.getRequestDispatcher("/WEB-INF/view/patientdoctors.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Can't add medicine, try again");
			request.getRequestDispatcher("/WEB-INF/view/medicine/medicineProfile.jsp").forward(request, response);
		}
	}
	
	private boolean validationMedicine(String title, String description, HttpServletRequest request) {
		
		boolean result = request.getParameter(title) != null
				&& !request.getParameter(title).isEmpty()
				&&request.getParameter(description) != null
				&& !request.getParameter(description).isEmpty();
		return result;
	}

}
