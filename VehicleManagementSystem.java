import java.util.Scanner;

public class VehicleManagementSystem {

    public void frontCover(){
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("+                                                   +");
        System.out.println("+             Vehicle Management System             +");
        System.out.println("+                                                   +");
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String vehicelCategory, vehicleID, vehicleBrand, vehicleModel, builtYear;
        VehicleManagementSystem VMS = new VehicleManagementSystem();
        VMS.frontCover();

        while (true) {
            System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println(" Choose an Option (1/2/3)");
            System.out.println(" 1. Add a vehicle");
            System.out.println(" 2. Search a vehicle");
            System.out.println(" 3. Display All");
            String input = sc.nextLine();
            System.out.println();

            switch (input){
                case "1":
                System.out.println(" Enter vehicle Category     :");
                vehicelCategory = sc.nextLine();
                System.out.println(" Enter vehicle ID           :");
                vehicleID = sc.nextLine();
                System.out.println(" Enter vehicle Brand        :");
                vehicleBrand = sc.nextLine();
                System.out.println(" Enter vehicle Model        :");
                vehicleModel = sc.nextLine();
                System.out.println(" Enter vehicle Built Year   :");
                builtYear = sc.nextLine();

                switch (vehicelCategory){
                    case "car":
                        new Car(vehicleID,vehicleBrand,vehicleModel,builtYear);
                        break;
                    case "motorcycle":
                        new MotorCycle(vehicleID,vehicleBrand,vehicleModel,builtYear);
                        break;
                    case "truck":
                        new Truck(vehicleID,vehicleBrand,vehicleModel,builtYear);
                        break;
                    default:
                        new NewCategory(vehicelCategory,vehicleID,vehicleBrand,vehicleModel,builtYear);
                        break;
                }
                break;

                case "2":
                    System.out.println(" Enter vehicle Category     :");
                    vehicelCategory = sc.nextLine();
                    System.out.println(" Enter vehicle ID           :");
                    vehicleID = sc.nextLine();

                    switch (vehicelCategory.toLowerCase()){
                        case "car":
                            new Car(vehicelCategory,vehicleID);
                            break;
                        case "motorcycle":
                            new MotorCycle(vehicelCategory,vehicleID);
                            break;
                        case "truck":
                            new Truck(vehicelCategory,vehicleID);
                            break;
                        default:
                            new NewCategory(vehicelCategory,vehicleID);
                            break;
                    }

                    break;

                case "3":
                    AbstractVehicles storedVehicles = new Car();
                    break;

                default:
                    System.out.println(" Input not recognized..");
                    break;

            }
        }
    }
}

