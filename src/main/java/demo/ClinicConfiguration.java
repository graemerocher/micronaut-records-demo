package demo;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.EachProperty;
import io.micronaut.core.bind.annotation.Bindable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@ConfigurationProperties("clinic")
record ClinicConfiguration(String name) {
    @EachProperty("pets")
    static record PetConfiguration(
            @NotBlank
            String name,
            @Max(20)
            int age,
            @Bindable(defaultValue = "true")
            boolean healthy
    ) {}
}
