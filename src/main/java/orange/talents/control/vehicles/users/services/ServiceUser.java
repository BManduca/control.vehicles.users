package orange.talents.control.vehicles.users.services;

import orange.talents.control.vehicles.users.dto.UserDTO;
import orange.talents.control.vehicles.users.dto.UserVehicleDTOResponse;
import orange.talents.control.vehicles.users.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import orange.talents.control.vehicles.users.repository.RepositoryUser;


@Service
public class ServiceUser {

    @Autowired
    public RepositoryUser repositoryUser;

    @Autowired
    public ServiceVehicle serviceVehicle;


    public ResponseEntity<?> UserRegister(UserDTO userDTO) {

        if (repositoryUser.existsUserByEmail(userDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O email inserido já se encontra cadastrado em nosso sistema!");
        }

        if (repositoryUser.existsUserByCpf(userDTO.getCpf())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O CPF inserido já se encontra cadastrado em nosso sistema!");
        }

        User user = new User();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setCpf(userDTO.getCpf());
        user.setBirthday(userDTO.getBirthday());

        repositoryUser.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro de usuário efetuado com sucesso!");
    }

    public ResponseEntity<?> findVehicleUserById(Long id) {

        if (repositoryUser.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário não foi encontrado em nosso sistema, favor verificar a veracidade do id!");
        }

        User user = repositoryUser.findById(id).get();

        UserVehicleDTOResponse userVehicleDTOResponse = new UserVehicleDTOResponse(user);

        return ResponseEntity.status(HttpStatus.FOUND).body(userVehicleDTOResponse);

    }

}
