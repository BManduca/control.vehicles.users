package orange.talents.control.vehicles.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import orange.talents.control.vehicles.users.entities.User;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "{NotBlank}")
    @Size(min=5, max=100)
    private String name;

    @NotBlank(message = "{NotBlank}")
    @Email(message = "{FormatEmail}")
    private String email;

    @NotBlank(message = "{NotBlank}")
    private String cpf;

    @NotBlank(message = "{NotBlank}")
    private LocalDate birthday;


    public UserDTO(User userEntity) {
        id = userEntity.getId();
        name = userEntity.getName();
        email = userEntity.getEmail();
        cpf = userEntity.getCpf();
        birthday = userEntity.getBirthday();
    }

}
