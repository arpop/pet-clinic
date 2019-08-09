package it.pop.petclinic.model;

import java.io.Serializable;

/**
 * Base for all entities of the project
 * */
public class BaseEntity implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
}
