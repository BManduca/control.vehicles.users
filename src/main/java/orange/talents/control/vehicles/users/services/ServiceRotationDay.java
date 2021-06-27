package orange.talents.control.vehicles.users.services;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Service
public class ServiceRotationDay {
    public String getRotationDay(String yearVehicle) {

        String lastNumberOfPlate = String.valueOf(yearVehicle.charAt(yearVehicle.length() - 1));
        String dayOfWeekVehicle;

        switch (lastNumberOfPlate) {
            case "0":
            case "1":
                dayOfWeekVehicle = "segunda-feira";
                break;

            case "2":
            case "3":
                dayOfWeekVehicle = "terça-feira";
                break;

            case "4":
            case "5":
                dayOfWeekVehicle = "quarta-feira";
                break;

            case "6":
            case "7":
                dayOfWeekVehicle = "quinta-feira";
                break;

            case "8":
            case "9":
                dayOfWeekVehicle = "sexta-feira";
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + lastNumberOfPlate);
        }
        return dayOfWeekVehicle;
    }

    public Boolean activeRotationDayVehicle(String RotationDay) {
        LocalDate presentDay = LocalDate.now();

        DayOfWeek dayOfWeek = presentDay.getDayOfWeek();

        Locale brLocation = new Locale("pt","BR");

        String brToday = dayOfWeek.getDisplayName(TextStyle.FULL, brLocation);

        return RotationDay.equals(brToday);
    }

}
