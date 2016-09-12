package br.com.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ufscar.secomp.devopsday.model.Event;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
	Event findDistinctEventByName (String name);
}
