package FurryPal;

import java.util.List;

public interface PetService {

    Pets savePets(Pets pets);

    List<Pets> fetchAllPets();

    Pets getPetsById(Integer id);

    Pets updatePetsById(Integer id, Pets pets);

    String deletePetsById(Integer id);
}
