package demo;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
record Pet(
        @Nullable @GeneratedValue @Id Long id,
        String name,
        int age,
        boolean healthy) {

    Pet(String name, int age) {
        this(null, name, age, true);
    }

    Pet(String name, int age, boolean healthy) {
        this(null, name, age, healthy);
    }
}
