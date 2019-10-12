package it.pop.petclinic.services.map;

import it.pop.petclinic.model.Specialty;
import it.pop.petclinic.model.Vet;
import it.pop.petclinic.services.SpecialtyService;
import it.pop.petclinic.services.VetService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        if (CollectionUtils.isNotEmpty(vet.getSpecialties())) {
            vet.getSpecialties().stream().filter(s -> s.getId() == null).forEach(specialty ->  {
                Specialty savedSpecialty = specialtyService.save(specialty);
                specialty.setId(savedSpecialty.getId());
            });
        }
        return super.save(vet);
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
