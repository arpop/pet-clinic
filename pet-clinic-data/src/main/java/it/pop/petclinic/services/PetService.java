package it.pop.petclinic.services;

import it.pop.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findByLastName(String lastName);

    Pet save(Pet owner);

    Set<Pet> findAll();
}
