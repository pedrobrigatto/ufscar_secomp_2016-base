package br.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.ufscar.secomp.devopsday.model.Speaker;

public interface SpeakerRepository extends PagingAndSortingRepository<Speaker, Long> {
	
	Speaker findDistinctSpeakerByName (String name);
}
