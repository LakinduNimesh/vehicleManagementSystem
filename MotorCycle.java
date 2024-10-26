import java.util.Scanner;

public class MotorCycle extends AbstractVehicles{


    Scanner sc = new Scanner(System.in);

    MotorCycle(String vehicleCategory, String vehicleID){
        vehicleSearch(vehicleCategory,vehicleID);

    }
    private void vehicleSearch(String vehicleCategory, String vehicleID){
        MotorCycleSearch(vehicleCategory,vehicleID);
    }
    MotorCycle(String vehicleID,String vehicleBrand, String vehicleModel,String builtYear){
        vehicleAdd(vehicleID,vehicleBrand,vehicleModel,builtYear);
    }

    private void vehicleAdd(String vehicleID, String vehicleBrand, String vehicleModel, String builtYear){
        setVehicleCategory("motorcycle");
        setVehicleID(vehicleID);
        setVehicleBrand(vehicleBrand);
        setVehicleModel(vehicleModel);
        setBuiltYear(builtYear);
        getEngineCapacity();
        getEngineOnOff(sc);
        saveVehicle();
        updateChange(getVehicleID(),sc);
    }

    public void getEngineCapacity(){
        System.out.println();
        System.out.println(" What is the Engine capacity of the MotorCycle :");
        setEngineCapacity(sc.nextLine());
    }

    public void setEngineCapacity(String capacity){
        setVehicleFeature(capacity + "CC");

    }

    public void MotorCycleSearch(String vehicleCategory, String vehicleID){

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
