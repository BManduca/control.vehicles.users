package orange.talents.control.vehicles.users.services;

import java.util.List;

import orange.talents.control.vehicles.users.api.ApiFipe;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import orange.talents.control.vehicles.users.api.dto.YearDTO;
import orange.talents.control.vehicles.users.api.dto.BrandDTO;
import orange.talents.control.vehicles.users.api.dto.ModelListDTO;


@Service
public class ServicePriceVehicle {

    @Autowired
    private ApiFipe apiFipe;

    private String codeBrand;
    private String codeModel;
    private String codeYear;

    public String getFipePrice(String brand, String model, String year) {

        getCodeBrand(brand);
        getCodeModel(model);
        getCodeYear(year);

        return apiFipe.getSpecificVehicle(codeBrand, codeModel, codeYear).getPrice();

    }

    public String getCodeBrand(String nameBrand) {

        codeBrand = null;

        List<BrandDTO> brands = apiFipe.getBrandVehicleList();

        brands.forEach(brandVehicle -> {
            if (brandVehicle.getNameBrand().contains(nameBrand)) {
                codeBrand = brandVehicle.getCodeBrand();
            }
        });
        return codeBrand;
    }

    public String getCodeModel(String nameModel) {

        codeModel = null;

        ModelListDTO modelListDto = apiFipe.getModelsList(codeBrand);

        modelListDto.getModelsList().forEach(model -> {
            if (model.getNameModel().contains(nameModel)) {
                codeModel = model.getCodeModel();
            }
        });

        return codeModel;

    }

    public String getCodeYear(String nameYear) {

        codeYear = null;

        List<YearDTO> years = apiFipe.getYearsVehicleList(codeBrand, codeModel);

        years.forEach(yearVehicle -> {
            if (yearVehicle.getNameYear().contains(nameYear)) {
                codeYear = yearVehicle.getCodeYear();
            }
        });

        return codeYear;

    }

}
