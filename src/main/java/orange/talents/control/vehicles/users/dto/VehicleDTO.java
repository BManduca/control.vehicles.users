package orange.talents.control.vehicles.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import orange.talents.control.vehicles.users.entities.Vehicle;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private Long id;

    @NotBlank(message = "{NotBlank}")
    private String brand;

    @NotBlank(message = "{NotBlank}")
    private String model;

    @NotBlank(message = "{NotBlank}")
    private String year;

    @NotBlank(message = "{NotBlank}")
    private String rotationDay;

    @NotBlank(message = "{NotBlank}")
    private Boolean activeRotationDay;

    @NotBlank(message = "{NotBlank}")
    private String price;

    public VehicleDTO(Vehicle vehicleEntity) {
        id = vehicleEntity.getId();
        price = vehicleEntity.getPrice();
        brand = vehicleEntity.getBrand();
        model = vehicleEntity.getModel();
        year = vehicleEntity.getYear();
        rotationDay = vehicleEntity.getRotationDay();
        activeRotationDay = vehicleEntity.getActiveRotationDay();
    }

}
