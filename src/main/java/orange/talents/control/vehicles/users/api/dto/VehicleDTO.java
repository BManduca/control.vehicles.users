package orange.talents.control.vehicles.users.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    @JsonProperty("Valor")
    private String price;

    @JsonProperty("Marca")
    private String brand;

    @JsonProperty("Modelo")
    private String model;

    @JsonProperty("AnoModelo")
    private String yearModel;

    @JsonProperty("Combustivel")
    private String fuel;

    @JsonProperty("CodigoFipe")
    private String codeFipe;

    @JsonProperty("MesReferencia")
    private String monthRefer;

    @JsonProperty("TipoVeiculo")
    private String type;

    @JsonProperty("SiglaCombustivel")
    private String initialsFuel;

}
