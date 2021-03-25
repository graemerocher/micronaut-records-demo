package demo;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class DemoTest {

    @Inject
    ClinicConfiguration configuration;

    @Inject
    PetClient client;

    @Test
    void testItWorks() {
        final List<Pet> pets = client.listHealthPets();
        assertEquals(
                2,
                pets.size()
        );
    }

    @Client("/pets")
    interface PetClient {
        @Get("/healthy")
        List<Pet> listHealthPets();
    }

}
