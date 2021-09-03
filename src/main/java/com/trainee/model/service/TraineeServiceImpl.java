package com.trainee.model.service;

import java.util.List;

import com.trainee.model.dao.Trainee;
import com.trainee.model.dao.TraineeDao;
import com.trainee.model.dao.TraineeDaoImpl;


public class TraineeServiceImpl implements TraineeService{
private TraineeDao traineeDao;
	
	public TraineeServiceImpl() {
		traineeDao=new TraineeDaoImpl();
	}

	@Override
	public List<Trainee> getAllTrainees() {
		return traineeDao.getAllTrainees();
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		return traineeDao.addTrainee(trainee);
	}
	
	@Override
	public Trainee getTrainee(String username) {
		return traineeDao.getTrainee(username);
	}
}
