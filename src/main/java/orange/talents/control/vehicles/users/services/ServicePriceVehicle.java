package orange.talents.control.vehicles.users.services;

import java.util.List;

import orange.talents.control.vehicles.users.api.ApiFipe;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import orange.talents.control.vehicles.users.api.dto.YearVehicleDTO;
import orange.talents.control.vehicles.users.api.dto.BrandVehicleDTO;
import orange.talents.control.vehicles.users.api.dto.ModelVehicleListDTO;


@Service
public class ServicePriceVehicle {

    @Autowired
    private ApiFipe apiFipe;

    private String codeBrand;
    private String codeModel;
    private String codeYear;

    public String getFipePrice(String brand, String model, String year) {

        getCodeBrandVehicle(brand);
        getCodeModelVehicle(model);
        getCodeYearVehicle(year);

        return apiFipe.getSpecificVehicle(codeBrand, codeModel, codeYear).getPrice();

    }

    public String getCodeBrandVehicle(String nameBrandVehicle) {

        codeBrand = null;

        List<BrandVehicleDTO> brandsVehicle = apiFipe.getBrandVehicleList();

        brandsVehicle.forEach(brandVehicle -> {
            if (brandVehicle.getNameBrand().contains(nameBrandVehicle)) {
                codeBrand = brandVehicle.getCodeBrand();
            }
        });
        return codeBrand;
    }

    public String getCodeModelVehicle(String nameModelVehicle) {

        codeModel = null;

        ModelVehicleListDTO modelVehicleListDto = apiFipe.getModelsVehicleList(codeBrand);

        modelVehicleListDto.getModelsList().forEach(modelVehicle -> {
            if (modelVehicle.getNameModel().contains(nameModelVehicle)) {
                codeModel = modelVehicle.getCodeModel();
            }
        });

        return codeModel;

    }

    public String getCodeYearVehicle(String nameYearVehicle) {

        codeYear = null;

        List<YearVehicleDTO> yearsVehicle = apiFipe.getYearsVehicleList(codeBrand, codeModel);

        yearsVehicle.forEach(yearVehicle -> {
            if (yearVehicle.getNameYear().contains(nameYearVehicle)) {
                codeYear = yearVehicle.getCodeYear();
            }
        });

        return codeYear;

    }

}
