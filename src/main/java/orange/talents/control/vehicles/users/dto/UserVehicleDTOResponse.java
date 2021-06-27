package orange.talents.control.vehicles.users.dto;


import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import orange.talents.control.vehicles.users.entities.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserVehicleDTOResponse {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthday;
    private List<VehicleDTO> vehicles;

    public UserVehicleDTOResponse(User userEntity) {
        id = userEntity.getId();
        name= userEntity.getName();
        email = userEntity.getEmail();
        cpf = userEntity.getCpf();
        birthday = userEntity.getBirthday();
        vehicles = userEntity.getVehicles().stream().map(VehicleDTO::new).collect(Collectors.toList());
    }

}
