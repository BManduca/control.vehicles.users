package orange.talents.control.vehicles.users.repository;

import orange.talents.control.vehicles.users.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVehicle extends JpaRepository<Vehicle, Long> {

}
