package it.pop.petclinic.services.springdatajpa;

import it.pop.petclinic.model.Owner;
import it.pop.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String SMITH = "Smith";
    public static final String WESSON = "Wesson";
    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerSDJpaService ownerService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1l).lastName(SMITH).build());
        owners.add(Owner.builder().id(2l).lastName(WESSON).build());

        Mockito.when(ownerService.findAll()).thenReturn(owners);
        assertEquals(2, ownerService.findAll().size());
    }

    @Test
    void findById() {
        Owner wesson = Owner.builder().id(2l).lastName(WESSON).build();
        Mockito.when(ownerRepository.findById(2L)).thenReturn(Optional.of(wesson));
        assertEquals(WESSON, ownerService.findById(2l).getLastName());
    }

    @Test
    void save() {
        Owner smith = Owner.builder().lastName(SMITH).build();
        Mockito.when(ownerRepository.save(smith)).thenReturn(smith);
        Owner savedSmith = ownerService.save(smith);
        assertNotNull(savedSmith);
        Mockito.verify(ownerRepository).save(Mockito.any());
    }

    @Test
    void delete() {
        Owner smith = Owner.builder().lastName(SMITH).build();
        ownerService.delete(smith);
        Mockito.verify(ownerRepository, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        Owner smith = Owner.builder().id(1L).lastName(SMITH).build();
        ownerService.deleteById(smith.getId());
        Mockito.verify(ownerRepository).deleteById(Mockito.anyLong());
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(1l).lastName(SMITH).build();
        Mockito.when(ownerService.findByLastName(SMITH)).thenReturn(returnOwner);
        Owner smith = ownerRepository.findByLastName(SMITH);

        assertEquals(SMITH, smith.getLastName());
        Mockito.verify(ownerRepository).findByLastName(Mockito.any());
    }
}