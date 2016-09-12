package br.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufscar.secomp.devopsday.model.Registration;

public interface RegistrationRepository extends PagingAndSortingRepository<Registration, Long> {
	
}
