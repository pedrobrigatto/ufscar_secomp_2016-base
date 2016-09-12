package br.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufscar.secomp.devopsday.model.Event;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
	Event findDistinctEventByName (String name);
}
