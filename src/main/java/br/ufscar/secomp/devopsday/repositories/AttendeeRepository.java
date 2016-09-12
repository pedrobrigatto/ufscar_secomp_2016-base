package br.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufscar.secomp.devopsday.model.Attendee;

public interface AttendeeRepository extends PagingAndSortingRepository<Attendee, Long> {
	
	Attendee findDistinctByName (String name);
}
