package it.pop.petclinic.services.map;


import it.pop.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).lastName("Smith").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1l);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(1l));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        Owner owner = Owner.builder().id(2L).build();
        ownerServiceMap.save(owner);
        assertEquals(2, ownerServiceMap.findAll().size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName("Smith");
        assertEquals("Smith", owner.getLastName());
    }
}