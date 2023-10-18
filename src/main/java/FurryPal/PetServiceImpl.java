package FurryPal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetsRepo petsRepo;

    @Override
    public Pets savePets(Pets pets) {
        return petsRepo.save(pets);
    }

    @Override
    public List<Pets> fetchAllPets() {
        List<Pets> allPets = petsRepo.findAll();
        return allPets;
    }

    @Override
    public Pets getPetsById(Integer id) {
        Optional<Pets> pets = petsRepo.findById(id);
        if (pets.isPresent()) {
            return pets.get();
        }
        return null;
    }

    @Override
    public Pets updatePetsById(Integer id, Pets pets) {
        Optional<Pets> pets1 = petsRepo.findById(id);

        if (pets1.isPresent()) {
            Pets originalPets = pets1.get();

            if (Objects.nonNull(pets.getName()) && !"".equalsIgnoreCase(pets.getName())) {
                originalPets.setName(pets.getName());
            }
            // if (Objects.nonNull(employee.getEmployeeSalary()) && employee.getEmployeeSalary() != 0) {
            //     originalEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            // }
            return petsRepo.save(originalPets);
        }
        return null;
    }

    @Override
    public String deletePetsById(Integer id) {
        if (petsRepo.findById(id).isPresent()) {
            petsRepo.deleteById(id);
            return "Pet deleted successfully";
        }
        return "No such pet in the database";
    }
}
