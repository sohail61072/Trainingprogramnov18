package com.mastek.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TrainingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TrainingApplication.class, args);
		TrainingAccessAPI trainingAPI = ctx.getBean(TrainingAccessAPI.class);
		ParticipantAccessAPI participantAPI = ctx.getBean(ParticipantAccessAPI.class);
		
		
		
		
		Training newTraining = new Training();
//		newTraining.setCoursename("MYSQL");
//		newTraining.setDate("20/11/11");
//		newTraining.setLocation("UK");
//		
//		
//		
//		trainingAPI.addTraining(newTraining);
//		
//		for (Training t : trainingAPI.listTrainings()) {
//			
//			System.out.println(t);
//			
//		}
//		
//		ctx.close();
//

		Participant newParticipant = new Participant();
//		newParticipant.setName("Kavinsky");	
//		
		
//		participantAPI.addParticipant(newParticipant);
//		
//		for (Participant p : participantAPI.listParticipants()) {
//			
//			System.out.println(p);
//			
//		}
//		
		
//		newTraining.getParticipants().add(newParticipant);
//		newParticipant.getTraining().add(newTraining);
//		trainingAPI.addTraining(newTraining);
//		participantAPI.addParticipant(newParticipant);
//		for (Training t : trainingAPI.listTrainings()) {
//			
//			System.out.println(t);
//			
//		}
		
	//	trainingAPI.addNewParticipantToTraining(9, 8);
		
}}