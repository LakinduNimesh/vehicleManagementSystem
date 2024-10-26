import java.util.Scanner;

public class NewCategory extends AbstractVehicles{


    Scanner sc = new Scanner(System.in);

    NewCategory(String vehicleCategory, String vehicleID){
        vehicleSearch(vehicleCategory,vehicleID);

    }
    private void vehicleSearch(String vehicleCategory, String vehicleID){
        NewCategorySearch(vehicleCategory,vehicleID);
    }
    NewCategory(String vehicleCategory,String vehicleID,String vehicleBrand, String vehicleModel,String builtYear){
        vehicleAdd(vehicleCategory,vehicleID,vehicleBrand,vehicleModel,builtYear);
    }

    private void vehicleAdd(String vehicleCategory,String vehicleID, String vehicleBrand, String vehicleModel, String builtYear){
        setVehicleCategory(vehicleCategory);
        setVehicleID(vehicleID);
        setVehicleBrand(vehicleBrand);
        setVehicleModel(vehicleModel);
        setBuiltYear(builtYear);
        getNewFearure();
        getEngineOnOff(sc);
        saveVehicle();
        updateChange(getVehicleID(),sc);
    }

    public void getNewFearure(){
        System.out.println();
        System.out.println(" What is the Features of the Vehicle :");
        setNewFeature(sc.nextLine());
    }

    public void setNewFeature(String payLoadCapacity){
        setVehicleFeature(String.valueOf(payLoadCapacity));

    }

    public void NewCategorySearch(String vehicleCategory, String vehicleID){

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
