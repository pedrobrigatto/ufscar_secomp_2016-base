package br.ufscar.secomp.devopsday.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Attendee extends DomainObject {

	private static final long serialVersionUID = 7760775338969558386L;
	
	private String name;
	private String reference;
	
	public Attendee () {
		super();
	}
	
	public Attendee (String name) {
		this();
		this.name = name;
	}

	@Column (unique = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}	
}
