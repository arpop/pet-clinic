package it.pop.petclinic.repositories;

import it.pop.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
    Vet findByLastName(String lastName);
}
