package com.github.elizabetht.mappers.modelBase;

import lombok.Data;

/**
 * Родительский класс сущности.
 */
@Data
public class Entity implements Comparable<Entity> {
    protected int id;

    public int compareTo(Entity o) {
        return (int) (this.id - o.id);
    }
}