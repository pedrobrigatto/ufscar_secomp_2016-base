package br.com.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.ufscar.secomp.devopsday.model.Attendee;

@RepositoryRestResource (collectionResourceRel = "attendee", path = "attendee")
public interface AttendeeRepository extends PagingAndSortingRepository<Attendee, Long> {
	
	Attendee findDistinctByName (String name);
}
