package br.com.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ufscar.secomp.devopsday.model.Registration;

public interface RegistrationRepository extends PagingAndSortingRepository<Registration, Long> {
	
}
