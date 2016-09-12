package br.com.ufscar.secomp.devopsday.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
public class Session extends DomainObject {

	private static final long serialVersionUID = 7864551895790956927L;
	
	private String title;
	private String description;
	private LocalDateTime startingTime;
	private LocalDateTime endingTime;
	private Speaker speaker;
	private List<Attendee> attendees;
	
	public Session () {
		super();
	}
	
	public Session(String title, LocalDateTime startingTime, LocalDateTime endingTime, Speaker speaker) {
		this();
		this.title = title;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.speaker = speaker;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@DateTimeFormat (iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonDeserialize (using = LocalDateTimeDeserializer.class)
	@JsonSerialize (using = LocalDateTimeSerializer.class)
	public LocalDateTime getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(LocalDateTime startingTime) {
		this.startingTime = startingTime;
	}

	@DateTimeFormat (iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonDeserialize (using = LocalDateTimeDeserializer.class)
	@JsonSerialize (using = LocalDateTimeSerializer.class)
	public LocalDateTime getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(LocalDateTime endingTime) {
		this.endingTime = endingTime;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@OneToMany (cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, targetEntity = Attendee.class)
	public List<Attendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}
}
