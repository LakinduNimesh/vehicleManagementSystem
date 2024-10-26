
import java.util.ArrayList;

interface Vehicle {
    void engineStatus(String es);
    void showVehicles();
    void saveVehicle();


    ArrayList<String> companyVehicles = new ArrayList<>();
}
