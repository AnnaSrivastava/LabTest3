package com.trainee.model.dao;

import com.trainee.model.service.TraineeService;
import com.trainee.model.service.TraineeServiceImpl;

public class Main {

	public static void main(String[] args) {
		TraineeService dao=new TraineeServiceImpl();
		System.out.println(dao.getTrainee("Ananya"));		
	}
}
