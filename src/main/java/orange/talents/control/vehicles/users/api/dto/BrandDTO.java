package orange.talents.control.vehicles.users.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {

    @JsonProperty("nome")
    private String nameBrand;

    @JsonProperty("codigo")
    private String codeBrand;

}
