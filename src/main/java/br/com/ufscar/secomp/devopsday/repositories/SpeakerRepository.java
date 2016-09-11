package br.com.ufscar.secomp.devopsday.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.ufscar.secomp.devopsday.model.Speaker;

@RepositoryRestResource (collectionResourceRel = "speaker", path = "speaker")
public interface SpeakerRepository extends PagingAndSortingRepository<Speaker, Long> {
	
	Speaker findDistinctSpeakerByName (String name);
}
