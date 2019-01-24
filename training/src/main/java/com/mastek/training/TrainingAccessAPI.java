package com.mastek.training;

import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/training/")
public class TrainingAccessAPI {
	
	TrainingJPARepository trepository;
	ParticipantJPARepository participantrepository;
	
	

	public ParticipantJPARepository getParticipantrepository() {
		return participantrepository;
	}
	@Autowired
	public void setParticipantrepository(ParticipantJPARepository participantrepository) {
		this.participantrepository = participantrepository;
	}

	public TrainingJPARepository getTrepository() {
		return trepository;
	}

	@Autowired
	public void setTrepository(TrainingJPARepository trepository) {
		this.trepository = trepository;
	}
	//Url: http://localhost:9900/training/list
	@Path("/list")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Training> listTrainings(){
		return getTrepository().findAll();
		
	}
	
	@POST
	@Path("/add")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public Training addTraining(@BeanParam Training newTraining) {
		getTrepository().save(newTraining);
		return newTraining;
		
	}
	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Training deleteTraining(int trainingId) {
		Training deleteTraining = getTrepository().findById(trainingId).get();
		getTrepository().delete(deleteTraining);
		return deleteTraining;
	}
	@POST
	@Path("/assign")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Transactional
	public void addNewParticipantToTraining(@FormParam("trainingId")int trainingId,@FormParam("participantId") int participantId) {
		Participant p = getParticipantrepository().findById(participantId).get();
		Training t = getTrepository().findById(trainingId).get();
		
		if(!t.getParticipants().contains(p)) {
			t.getParticipants().add(p);
			
		}
		p.getTraining().add(t);
		getTrepository().save(t);
	}
	@GET
	@Path("/assigned")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Transactional
	public Set<Participant> getParticipants(@QueryParam("trainingId")int trainingId){
		Training t = getTrepository().findById(trainingId).get();
		
		if(!t.getParticipants().isEmpty()) {
			return t.getParticipants();
		}
		else {
		return null;
		
	}

	}
}
