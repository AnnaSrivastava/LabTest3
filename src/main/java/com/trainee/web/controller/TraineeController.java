package com.trainee.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trainee.model.dao.Trainee;
import com.trainee.model.service.TraineeService;
import com.trainee.model.service.TraineeServiceImpl;

@WebServlet("/TraineeController.do")
public class TraineeController extends HttpServlet {
	
	private Logger logger =LoggerFactory.getLogger(TraineeController.class);
	
	private static final long serialVersionUID = 1L;

	private TraineeService traineeService = new TraineeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("showall".equals(action)) {
			List<Trainee> trainees = traineeService.getAllTrainees();
			request.setAttribute("trainees", trainees);
			RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
			rd.forward(request, response);
		}
		else if("addtrainee".equals(action)) {
			request.getRequestDispatcher("addtrainee.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int traineeID=Integer.parseInt(request.getParameter("traineeID").trim());
		String traineeName = request.getParameter("traineeName");
		String Branch = request.getParameter("Branch");
		String PercentageStr = request.getParameter("Percentage");
		Double Percentage=Double.parseDouble(PercentageStr);
		Trainee trainee=new Trainee(traineeName, Branch, Percentage);
		
		if(traineeID==0) {
			traineeService.addTrainee(trainee);
			logger.info("trainee is added ");
		}
		
		//PRG pattern
		response.sendRedirect("TraineeController.do?action=showall");
	}

}
