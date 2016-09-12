package br.com.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ufscar.secomp.devopsday.model.Attendee;

public interface AttendeeRepository extends PagingAndSortingRepository<Attendee, Long> {
	
	Attendee findDistinctByName (String name);
}
