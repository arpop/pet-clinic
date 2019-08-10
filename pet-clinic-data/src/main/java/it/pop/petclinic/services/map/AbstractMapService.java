package it.pop.petclinic.services.map;

import it.pop.petclinic.model.BaseEntity;
import org.springframework.util.CollectionUtils;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T entity) {

        if (Objects.nonNull(entity)){
            if(Objects.isNull(entity.getId())) {
                entity.setId(getNextId());
            }
        } else {
            throw new RuntimeException("Entity to save cannot be null");
        }
        map.put(entity.getId(), entity);
        return entity;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T entity) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
    }

    private Long getNextId() {
        if (CollectionUtils.isEmpty(map)) {
            return 1L;
        }
        return Collections.max(map.keySet()) + 1;
    }
}
