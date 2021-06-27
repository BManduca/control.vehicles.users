package orange.talents.control.vehicles.users.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import orange.talents.control.vehicles.users.dto.VehicleDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import orange.talents.control.vehicles.users.services.ServiceVehicle;

@RestController
@RequestMapping("/vehicle")
public class ControllerVehicle {

    @Autowired
    public ServiceVehicle serviceVehicle;

    @PostMapping("/{userId}")
    public ResponseEntity<?> vehicleCreate(
            @Valid
            @RequestBody VehicleDTO vehicleDTO,
            @PathVariable Long userId) {

        return serviceVehicle.VehicleRegister(vehicleDTO, userId);
    }

}
