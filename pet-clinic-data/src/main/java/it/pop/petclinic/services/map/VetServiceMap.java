package it.pop.petclinic.services.map;

import it.pop.petclinic.model.Vet;
import it.pop.petclinic.services.CrudService;
import it.pop.petclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return this.findAll().stream()
                             .filter(v -> v.getLastName().equals(lastName))
                             .findFirst().orElse(null);
    }
}
