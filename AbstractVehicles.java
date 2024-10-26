import java.util.Scanner;

abstract class AbstractVehicles implements Vehicle {
    private String vehicleCategory;
    private String vehicleID;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleFeature;
    private String builtYear;
    private String EngineStatus;


    private void engineOn(){
        System.out.println();
        System.out.println(" Engine has Started....");
        System.out.println();
    }

    private void engineOff(){
        System.out.println();
        System.out.println(" Engine has Stopped...");
        System.out.println();
    }

    public void engineOnOff(String es){
        if (es.equalsIgnoreCase("start")){
            setEngineStatus(es);
            engineOn();
        } else if (es.equalsIgnoreCase("stop")) {
            setEngineStatus(es);
            engineOff();

        }
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setBuiltYear(String builtYear) {
        this.builtYear = builtYear;
    }

    public String getBuiltYear() {
        return builtYear;
    }

    public void setVehicleFeature(String vehicleFeature) {
        this.vehicleFeature = vehicleFeature;
    }

    public String getVehicleFeature() {
        return vehicleFeature;
    }

    public void setEngineStatus(String engineStatus) {
        EngineStatus = engineStatus;
    }

    public String getEngineStatus() {
        return EngineStatus;
    }

    private String search(String vehicleID){
        if(companyVehicles.isEmpty()){
            System.out.println(" No vehicle details found...");
            return " ";
        }

        for(int i = 0; i < companyVehicles.size(); i++){
            if(vehicleID.equals(companyVehicles.get(i))){

                if(i >= 1 && (i + 5) < companyVehicles.size()){
                    return companyVehicles.get(i-1) + " " +
                            companyVehicles.get(i) + " " +
                            companyVehicles.get(i+1) + " " +
                            companyVehicles.get(i+2) + " " +
                            companyVehicles.get(i+3) + " " +
                            companyVehicles.get(i+4) + " " +
                            companyVehicles.get(i+5);
                }
            }
        }
        System.out.println(" Vehicle not found with ID: " + vehicleID);
        return " ";
    }

    public void save(String vehicleInfo){

        String[] vehicleList = vehicleInfo.split(" ");
        for(String detail : vehicleList){
            companyVehicles.add(detail);
        }
    }

    public void delete(String vehicleID){
        int vehicleNum = -1;

        for(int i = 0; i < companyVehicles.size(); i++){
            if(vehicleID.equals(companyVehicles.get(i))){
                vehicleNum = (i-1);
                break;
            }
        }

        if(vehicleNum >= 0){
            for(int i = 0; i < 7; i++){
                if(vehicleNum < companyVehicles.size()){
                    companyVehicles.remove(vehicleNum);
                }
            }
        }
    }

    public String getSearch(String vehicleID){
        return search(vehicleID);
    }

    public String getSearch(String vehicleCategory,String vehicleID){
        String vehicleInfo = search(vehicleID);

        if (" ".equals(vehicleInfo)){
            System.out.println();
            System.out.println( vehicleCategory + " not found..");
            return " ";
        }

        String[] vehicleList = vehicleInfo.split(" ");
        if (vehicleList[0].equals(vehicleCategory)){
            return  vehicleInfo;
        }
        return " ";
    }

    public void allVehicles(){
        if (companyVehicles.isEmpty()){
            System.out.println(" There are no vehicle details..");
        } else {

            for (int i=0; i<companyVehicles.size(); i+=7){

                System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
                System.out.println();
                System.out.println("             " + companyVehicles.get(i));
                System.out.println();
                System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
                System.out.println();

                System.out.println(" Vehicle ID            : " + companyVehicles.get(i+1));
                System.out.println(" Vehicle Brand         : " + companyVehicles.get(i+2));
                System.out.println(" Vehicle Model         : " + companyVehicles.get(i+3));
                System.out.println(" Vehicle Year          : " + companyVehicles.get(i+4));
                System.out.println(" Vehicle Features      : " + companyVehicles.get(i+5));
                System.out.println(" Vehicle Engine Status : " + companyVehicles.get(i+6));
                System.out.println("=====================================================");
                System.out.println();


            }
        }
    }

    @Override
    public void engineStatus(String es){
        engineOnOff(es);
    }

    public void getEngineOnOff(Scanner sc){
        System.out.println();
        System.out.println(" What is the current Engine Status (start/stop) :");
        String currentEngineState = sc.nextLine().toLowerCase();

        if (currentEngineState.equals("start") || currentEngineState.equals("stop") ){
            engineStatus(currentEngineState);
        }else {
            System.out.println(" Invalid Input");
            getEngineOnOff(sc);
        }
    }

    @Override
    public void showVehicles(){
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println(" Vehicle ID            :" + getVehicleID());
        System.out.println(" Vehicle Brand         :" + getVehicleBrand());
        System.out.println(" Vehicle Model         :" + getVehicleModel());
        System.out.println(" Vehicle Built Year    :" + getBuiltYear());
        System.out.println(" Vehicle Features      :" + getVehicleFeature());
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

    }

    @Override
    public void saveVehicle(){
        String vehicleInfo = getVehicleCategory() + " " + getVehicleID() + " " + getVehicleBrand() + " " + getVehicleModel() + " " + getBuiltYear() + " " + getVehicleFeature() + " " + getEngineStatus();
        save(vehicleInfo);
        showVehicles();

    }

    public void updateEngineStatus(String vehicleID){
        String vehicleInfo = getSearch(vehicleID);

        if (vehicleInfo.trim().isEmpty()){
            System.out.println(" Vehicle not found!");
            return;
        }

        delete(vehicleID);

        String[] vehicleList = vehicleInfo.split(" ");

        String newEngineStatus;
        if ("stop".equals(vehicleList[6])){
            newEngineStatus = "start";
            System.out.println(" Changed the Engine Status..");
            System.out.println(" Engine has Started..");
        } else {
            newEngineStatus = "stop";
            System.out.println(" Changed the Engine Status..");
            System.out.println(" Engine has Stopped..");
        }

        // Reconstruct vehicle info with new engine status
        String newVehicleInfo = String.format("%s %s %s %s %s %s %s",
                vehicleList[0], vehicleList[1], vehicleList[2],
                vehicleList[3], vehicleList[4], vehicleList[5],
                newEngineStatus);

        save(newVehicleInfo);
        showVehicles();
    }


    public void updateChange(String vehicleID, Scanner sc){
        System.out.println();
        System.out.println("Do you want to change the Engine Status? Enter ('y' for YES/'n' for NO) ");
        String input = sc.nextLine();

        switch (input){
            case "y":
                updateEngineStatus(vehicleID);
                break;
            case "n":
                System.out.println();
                break;
            default:
                System.out.println(" Invalid input..");
                updateChange(vehicleID,sc);
                break;

        }
    }
}









































