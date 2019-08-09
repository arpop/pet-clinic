package it.pop.petclinic.services;

import it.pop.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLastName(String lastName);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
