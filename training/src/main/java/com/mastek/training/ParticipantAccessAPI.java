package com.mastek.training;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/participant")

public class ParticipantAccessAPI {
	
	ParticipantJPARepository prepository;

	public ParticipantJPARepository getPrepository() {
		return prepository;
	}
	
	@Autowired
	public void setPrepository(ParticipantJPARepository prepository) {
		this.prepository = prepository;
	}
	
	@Path("/list")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Participant> listParticipants(){
		return getPrepository().findAll();
		
	}
	
	@POST
	@Path("/add")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public Participant addParticipant(@BeanParam Participant newParticipant) {
		getPrepository().save(newParticipant);
		return newParticipant;
		
	}
	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Participant deleteParticipant(int participantId) {
		Participant deleteParticipant = getPrepository().findById(participantId).get();
		getPrepository().delete(deleteParticipant);
		return deleteParticipant;
	}
}
	