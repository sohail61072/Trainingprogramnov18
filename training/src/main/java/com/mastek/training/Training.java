package com.mastek.training;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="Spring_boot_training")
@XmlRootElement
public class Training {

	
	int trainingId;
	@FormParam("coursename")
	String coursename;
	@FormParam("date")
	String date;
	@FormParam("location")
	String location;
	
	Set<Participant> participants = new HashSet<>();
	
	
	@XmlTransient
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="JPA_TRAINING",
	//the foreign key for the current class
	joinColumns= {@JoinColumn(name="FK_TrainingId")},
//foreign key for the collection type class	
	inverseJoinColumns= {@JoinColumn(name="FK_ParticipantId")})
	public Set<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Training [trainingId=" + trainingId + ", coursename=" + coursename + ", date=" + date + ", location="
				+ location + "]";
	}

	
	
}
