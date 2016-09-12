package br.ufscar.secomp.devopsday.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
public class Registration extends DomainObject {

	private static final long serialVersionUID = -5140906509138484515L;
	
	private LocalDateTime date;
	private Attendee attendee;
	private Session session;
	
	public Registration() {
		super();
	}
	
	public Registration(LocalDateTime date, Attendee attendee, Session session) {
		this();
		this.date = date;
		this.attendee = attendee;
		this.session = session;
	}

	@DateTimeFormat (iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonDeserialize (using = LocalDateTimeDeserializer.class)
	@JsonSerialize (using = LocalDateTimeSerializer.class)
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Attendee getAttendee() {
		return attendee;
	}

	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}
