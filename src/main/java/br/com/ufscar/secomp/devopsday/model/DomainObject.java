package br.com.ufscar.secomp.devopsday.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class DomainObject implements Serializable {

	private static final long serialVersionUID = 6276312463361395392L;
	
	private Long id;
	
	public DomainObject() {}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
