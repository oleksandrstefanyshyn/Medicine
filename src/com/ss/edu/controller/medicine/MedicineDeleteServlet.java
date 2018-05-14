package com.ss.edu.controller.medicine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.edu.dto.MedicineDto;
import com.ss.edu.tool.Context;

@WebServlet("/medicinedelete")
public class MedicineDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MedicineDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = (String) request.getSession().getAttribute("login");
		
		boolean result = (login != null 
				&& !login.isEmpty()) 
				&&  (request.getParameter("id")) != null 
				&&	(!request.getParameter("id").isEmpty()) ;
		if (result) {
			Long id = Long.parseLong(request.getParameter("id"));
			if (Context.getInstance().getMedicineService().isExistId(id)) {
				MedicineDto medicineDto = new MedicineDto(id);
				Context.getInstance().getMedicineService().removeMedicine(medicineDto);
			}
			response.sendRedirect("/HospitalNewWeb/patientmedicines");
			//request.getRequestDispatcher("/patientdoctors").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Access Denied! Log in first");
			request.getRequestDispatcher("/WEB-INF/view/patient/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
