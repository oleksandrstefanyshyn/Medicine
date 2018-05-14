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
import com.ss.edu.service.PatientMedicineService;
import com.ss.edu.tool.Context;

@WebServlet("/medicineedit")
public class MedicineProfileEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MedicineProfileEditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatientDto patientDto = Context.getInstance().getPatientProfileService().getPatientDto(request.getParameter("login"));
		MedicineDto medicineDto = Context.getInstance().getMedicineService().getMedicineDto(Long.parseLong(request.getParameter("id")));
		if (medicineDto != null) {
			request.getSession().setAttribute("login", patientDto.getLogin());
			request.getSession().setAttribute("medicineDto", medicineDto);
			request.getSession().setAttribute("medicineId", medicineDto.getId());
		}
		request.getRequestDispatcher("/WEB-INF/view/medicine/medicineProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean result = (request.getParameter("title") != null)&&(!request.getParameter("title").isEmpty())
							&&(request.getParameter("description") != null)&&(!request.getParameter("description").isEmpty());
	
		String login = (String) request.getSession().getAttribute("login");
		
		if (result) {
			PatientDto patientDto = Context.getInstance().getPatientProfileService().getPatientDto(login);
			Long id = (Long) request.getSession().getAttribute("medicineId");
			MedicineDto medicineDto = Context.getInstance().getMedicineService().getMedicineDto(id);
			
			//request.getSession().removeAttribute("medicineDto");
			
			medicineDto.setTitle(request.getParameter("title"));
			medicineDto.setDescription(request.getParameter("description"));
			result = Context.getInstance().getMedicineService().setMedicineDto(medicineDto);
		}
		
		if (result) {
			LoginDto loginDto = new LoginDto(login, new String());
			PatientMedicineDto patientMedicineDto = Context.getInstance().getPatientMedicineService()
					.getPatientMedicines(loginDto);
			request.getSession().setAttribute("patientMedicineDto", patientMedicineDto);
			response.sendRedirect("/HospitalNewWeb/patientmedicines");
			//request.getRequestDispatcher("/patientdoctors").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Can't edit medicine, try again");
			request.getRequestDispatcher("/WEB-INF/view/medicine/medicineProfile.jsp").forward(request, response);
		}
	}

}
