package it.pop.petclinic.services;

import it.pop.petclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastName);
}
