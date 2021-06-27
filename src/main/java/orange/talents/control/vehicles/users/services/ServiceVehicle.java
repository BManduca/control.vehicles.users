package orange.talents.control.vehicles.users.services;

import org.springframework.stereotype.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import orange.talents.control.vehicles.users.entities.User;
import orange.talents.control.vehicles.users.dto.VehicleDTO;
import orange.talents.control.vehicles.users.entities.Vehicle;
import orange.talents.control.vehicles.users.repository.RepositoryUser;
import orange.talents.control.vehicles.users.repository.RepositoryVehicle;



@Service
public class ServiceVehicle {

    @Autowired
    public RepositoryVehicle repositoryVehicle;

    @Autowired
    public RepositoryUser repositoryUser;

    @Autowired
    public ServiceRotationDay serviceRotationDay;

    @Autowired
    public ServicePriceVehicle servicePriceVehicle;

    public ResponseEntity<?> VehicleRegister(VehicleDTO vehicleDTO, Long userId) {

        if (repositoryUser.findById(userId).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário não foi encontrado no sistema, favor verificar a consistência do id!");
        }

        User user = repositoryUser.findById(userId).get();

        Vehicle vehicle = new Vehicle();

        String year = vehicleDTO.getYear();

        String brand = vehicleDTO.getBrand();

        String model = vehicleDTO.getModel();

        String rotationDay = serviceRotationDay.getRotationDay(year);

        Boolean activeRotationDay = serviceRotationDay.activeRotationDayVehicle(rotationDay);

        String price = servicePriceVehicle.getFipePrice(brand, model, year);

        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setYear(year);
        vehicle.setRotationDay(rotationDay);
        vehicle.setActiveRotationDay(activeRotationDay);
        vehicle.setPrice(price);
        vehicle.setUser(user);

        repositoryVehicle.save(vehicle);

        VehicleDTO displayVehicleDTO = new VehicleDTO(vehicle);

        return ResponseEntity.status(HttpStatus.CREATED).body(displayVehicleDTO);

    }

}
