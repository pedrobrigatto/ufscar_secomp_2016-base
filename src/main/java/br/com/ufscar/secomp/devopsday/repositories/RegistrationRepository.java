package br.com.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.ufscar.secomp.devopsday.model.Registration;

@RepositoryRestResource (collectionResourceRel = "registration", path = "registration")
public interface RegistrationRepository extends PagingAndSortingRepository<Registration, Long> {
	
}
