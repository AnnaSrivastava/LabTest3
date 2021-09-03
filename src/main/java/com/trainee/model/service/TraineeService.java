package com.trainee.model.service;

import java.util.List;
import com.trainee.model.dao.Trainee;


public interface TraineeService {
	public List<Trainee> getAllTrainees();
	public Trainee addTrainee(Trainee trainee);
	public Trainee getTrainee(String username);
}
