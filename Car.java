import java.util.List;
import java.util.Scanner;

public class Car extends AbstractVehicles{

    Scanner sc = new Scanner(System.in);

    Car(){
        vehicleShow();
    }

    private void vehicleShow(){
        allVehicles();
    }

    Car(String vehicleCategory, String vehicleID){
        vehicleSearch(vehicleCategory,vehicleID);
    }
    private void vehicleSearch(String vehicleCategory, String vehicleID){
        carSearch(vehicleCategory,vehicleID);
    }

    Car(String vehicleID, String vehicleBrand,String vehicleModel, String builtYear){
        vehicleAdd(vehicleID,vehicleBrand,vehicleModel,builtYear);
    }

    private void vehicleAdd(String vehicleID, String vehicleBrand, String vehicleModel, String builtYear){
        setVehicleCategory("car");
        setVehicleID(vehicleID);
        setVehicleBrand(vehicleBrand);
        setVehicleModel(vehicleModel);
        setBuiltYear(builtYear);
        getDoorCount();
        getEngineOnOff(sc);
        saveVehicle();
        updateChange(getVehicleID(),sc);
    }

    public void getDoorCount(){
        System.out.println();
        System.out.println(" How many Doors does the car have ? ");
        setDoorCount(sc.nextLine());
    }

    public void setDoorCount(String count){
        setVehicleFeature(count + "Doors");
    }

    public void carSearch(String vehicleCategory, String vehicleID){

        String vehicleInfo = getSearch(vehicleCategory,vehicleID);
        if (" ".equals(vehicleInfo)){
            System.out.println();
            System.out.println(" Invalid Input..");
            return;
        }

        String[] vehicleList = vehicleInfo.split(" ");

        setVehicleID(vehicleList[1]);
        setVehicleBrand(vehicleList[2]);
        setVehicleModel(vehicleList[3]);
        setBuiltYear(vehicleList[4]);
        setVehicleFeature(vehicleList[5]);
        setEngineStatus(vehicleList[6]);

        showVehicles();
        updateChange(vehicleID,sc);
    }
}
