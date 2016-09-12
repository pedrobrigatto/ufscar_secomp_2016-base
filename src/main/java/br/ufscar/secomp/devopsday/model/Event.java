package br.ufscar.secomp.devopsday.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
public class Event extends DomainObject {

	private static final long serialVersionUID = -5598547396016865554L;
	
	private String name;
	private String description;
	private LocalDateTime firstDay;
	private LocalDateTime lastDay;
	private List<Session> sessions;
	
	public Event () {
		super();
	}
	
	public Event(String name, LocalDateTime firstDay, LocalDateTime lastDay, Speaker speaker) {
		this();
		this.name = name;
		this.firstDay = firstDay;
		this.lastDay = lastDay;
	}

	@Column (unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public LocalDateTime getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(LocalDateTime firstDay) {
		this.firstDay = firstDay;
	}

	@DateTimeFormat (iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonDeserialize (using = LocalDateTimeDeserializer.class)
	@JsonSerialize (using = LocalDateTimeSerializer.class)
	public LocalDateTime getLastDay() {
		return lastDay;
	}

	public void setLastDay(LocalDateTime lastDay) {
		this.lastDay = lastDay;
	}

	@OneToMany (cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, targetEntity = Session.class)
	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
}
