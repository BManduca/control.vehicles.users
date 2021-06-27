package orange.talents.control.vehicles.users.controller;


import orange.talents.control.vehicles.users.dto.UserDTO;
import orange.talents.control.vehicles.users.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class ControllerUser {

    @Autowired
    private ServiceUser serviceUser;

    @PostMapping
    public ResponseEntity<?> userCreate(
            @Valid
            @RequestBody UserDTO userDTO) {
        return serviceUser.UserRegister(userDTO);
    }

    @GetMapping("/{id}/vehicle")
    public ResponseEntity<?> findVehicleUserById(@PathVariable Long id) {
        return serviceUser.findVehicleUserById(id);
    }

}
