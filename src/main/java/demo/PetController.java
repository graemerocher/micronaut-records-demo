package demo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.util.List;

@Controller("/pets")
@ExecuteOn(TaskExecutors.IO)
record PetController(PetRepository repository) {
    @Get("/healthy")
    List<Pet> listHealthyPets() {
        return repository.findAllByHealthyTrue();
    }
}
