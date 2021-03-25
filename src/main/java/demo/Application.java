package demo;

import demo.ClinicConfiguration.PetConfiguration;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
record Application(
        PetRepository repository,
        List<PetConfiguration> configurations) {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @EventListener
    void startup(StartupEvent startupEvent) {
        repository.saveAll(
                configurations.stream()
                .map((config) -> new Pet(config.name(), config.age(), config.healthy()))
                .collect(Collectors.toList())
        );
    }
}
