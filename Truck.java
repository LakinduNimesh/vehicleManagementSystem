import java.util.Scanner;

public class Truck extends AbstractVehicles{


    Scanner sc = new Scanner(System.in);

    Truck(String vehicleCategory, String vehicleID){
        vehicleSearch(vehicleCategory,vehicleID);

    }
    private void vehicleSearch(String vehicleCategory, String vehicleID){
        TruckSearch(vehicleCategory,vehicleID);
    }
    Truck(String vehicleID,String vehicleBrand, String vehicleModel,String builtYear){
        vehicleAdd(vehicleID,vehicleBrand,vehicleModel,builtYear);
    }

    private void vehicleAdd(String vehicleID, String vehicleBrand, String vehicleModel, String builtYear){
        setVehicleCategory("truck");
        setVehicleID(vehicleID);
        setVehicleBrand(vehicleBrand);
        setVehicleModel(vehicleModel);
        setBuiltYear(builtYear);
        getPayLoadCapacity();
        getEngineOnOff(sc);
        saveVehicle();
        updateChange(getVehicleID(),sc);
    }

    public void getPayLoadCapacity(){
        System.out.println();
        System.out.println(" What is the Payload capacity of the Truck :");
        setPayloadCapacity(sc.nextLine());
    }

    public void setPayloadCapacity(String payLoadCapacity){
        setVehicleFeature(String.valueOf(payLoadCapacity) + "KG");

    }

    public void TruckSearch(String vehicleCategory, String vehicleID){

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
