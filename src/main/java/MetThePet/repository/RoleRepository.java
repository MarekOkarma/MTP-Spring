package MetThePet.repository;

import MetThePet.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role , Integer> {

    Role findByName(String name); //znajdz mi w bazie danych obiekt typu string name
}
