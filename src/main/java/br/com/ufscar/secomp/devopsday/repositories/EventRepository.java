package br.com.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.ufscar.secomp.devopsday.model.Event;

@RepositoryRestResource (collectionResourceRel = "event", path = "event")
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
	Event findDistinctEventByName (String name);
}
