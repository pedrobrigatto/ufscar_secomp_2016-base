package br.ufscar.secomp.devopsday.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Speaker extends DomainObject {

	private static final long serialVersionUID = -72183063540821040L;
	
	private String name;
	private String miniBio;
	
	public Speaker() {
		super();
	}
	
	public Speaker(String name) {
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

	public String getMiniBio() {
		return miniBio;
	}

	public void setMiniBio(String miniBio) {
		this.miniBio = miniBio;
	}
}
