package com.trainee.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainee.model.dao.Trainee;
import com.trainee.model.service.TraineeService;
import com.trainee.model.service.TraineeServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private TraineeService traineeService=new TraineeServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		try {
			Trainee trainee = traineeService.getTrainee(username);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("trainee", trainee);
			response.sendRedirect("TraineeController.do?action=showall");
			
		} catch (Exception ex) {
			response.sendRedirect("login.jsp?message=login failed");
		}
	}

}
