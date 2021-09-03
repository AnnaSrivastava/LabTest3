package com.trainee.model.dao;
import java.util.List;

public interface TraineeDao {
	public List<Trainee> getAllTrainees();
	public Trainee addTrainee(Trainee trainee);
	public Trainee getTrainee(String username);
}
