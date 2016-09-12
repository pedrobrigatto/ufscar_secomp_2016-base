package br.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufscar.secomp.devopsday.model.Session;

public interface SessionRepository extends PagingAndSortingRepository<Session, Long> {
	
	Session findDistinctByTitle (String title);
}
