package orange.talents.control.vehicles.users.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import orange.talents.control.vehicles.users.api.dto.VehicleDTO;
import orange.talents.control.vehicles.users.api.dto.YearDTO;
import orange.talents.control.vehicles.users.api.dto.BrandDTO;
import orange.talents.control.vehicles.users.api.dto.ModelListDTO;


@FeignClient(name = "ApiFipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface ApiFipe {
    //material base -> http://deividfortuna.github.io/fipe/

    /*
    * Criando endpoint para listar as marcas do tipo de veículo que você deseja
    * Request
    * GET: https://parallelum.com.br/fipe/api/v1/carros/marcas
    * */
    @GetMapping("/carros/marcas")
    List<BrandDTO> getBrandVehicleList();


    /*
    * agora iremos obter a listagem de veículos de uma determinada marca, com o código da marca desejada
    * ex: VW - VolksWagen (59)
    * Request
    * GET: https://parallelum.com.br/fipe/api/v1/carros/marcas/{codeBrand}/modelos
    * */
    @GetMapping("/carros/marcas/{codeBrand}/modelos")
    ModelListDTO getModelsList(@PathVariable String codeBrand);


    /*
    * Após escolher o veículo desejado é possível consultar os modelos e os anos disponíveis
    * para uma futura consulta de preços.    Ex.: AMAROK High.CD 2.0 16V TDI 4x4 Dies.
    *
    * Request
    * GET: https://parallelum.com.br/fipe/api/v1/carros/marcas/{codeBrand}}/modelos/{codeModel}/anos
    * */
    @GetMapping("/carros/marcas/{codeBrand}/modelos/{codeModel}/anos")
    List<YearDTO> getYearsVehicleList(
            @PathVariable String codeBrand,
            @PathVariable String codeModel
    );

    /*
    * Por fim, ao adicionarmos mais um parâmetro, será possível visualizar o preço corrente
    * da tabela Fipe para o veículo/modelo/ano
    *
    * Ex.: valor de um veículo do ano 2014, a gasolina, utilizaremos o id 2014-3
    *
    * Request
    * GET: https://parallelum.com.br/fipe/api/v1/carros/marcas/{codeBrand}}/modelos/{codeModel}/anos/{codeYear}
    *
    * */
    @GetMapping("/carros/marcas/{codeBrand}/modelos/{codeModel}/anos/{codeYear}")
    VehicleDTO getSpecificVehicle(
            @PathVariable String codeBrand,
            @PathVariable String codeModel,
            @PathVariable String codeYear
    );

}
