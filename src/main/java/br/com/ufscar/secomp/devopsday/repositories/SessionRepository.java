package br.com.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.ufscar.secomp.devopsday.model.Session;

@RepositoryRestResource (collectionResourceRel = "session", path = "session")
public interface SessionRepository extends PagingAndSortingRepository<Session, Long> {
	
	Session findDistinctByTitle (String title);
}
