package com.mastek.training;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Spring_boot_participant")
@XmlRootElement

public class Participant {
	
	int participantId;
	@FormParam("name")
	String name;
	Set<Training> training = new HashSet<>();
	
	
	@ManyToMany(mappedBy="participants")
	@XmlTransient
	public Set<Training> getTraining() {
		return training;
	}
	public void setTraining(Set<Training> training) {
		this.training = training;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getParticipantId() {
		return participantId;
	}
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", name=" + name + "]";
	}
	
 

}
