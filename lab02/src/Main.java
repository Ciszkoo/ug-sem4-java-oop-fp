import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showWelcomeMessage();

        Cylinder cylinder = new Cylinder();
        boolean run = true;
        Scanner optionScanner = new Scanner(System.in);

        while (run) {
            showMenu();
            int option = optionScanner.nextInt();
            switch (option) {
                case 1 -> showParameters(cylinder);
                case 2 -> changeHeight(cylinder);
                case 3 -> changeRadius(cylinder);
                case 4 -> showCylinderProperties(cylinder);
                case 5 -> run = false;
                default -> System.out.println("Incorrect option selected, please try again :)");
            }
        }

        optionScanner.close();
    }

    private static void showCylinderProperties(Cylinder cylinder) {
        System.out.printf("Surface area of the base of a cylinder: %f\n", cylinder.baseArea());
        System.out.printf("Lateral surface area of a cylinder: %f\n", cylinder.lateralArea());
        System.out.printf("Total surface area of a cylinder: %f\n", cylinder.surfaceArea());
        System.out.printf("Volume of a cylinder: %f\n", cylinder.volume());
    }

    private static double readParameter() {
        Scanner parameterScanner = new Scanner(System.in);
        return parameterScanner.nextDouble();
    }

    private static void changeRadius(Cylinder cylinder) {
        System.out.println("Enter the new radius of the cylinder: ");
        cylinder.setRadius(readParameter());
    }

    private static void changeHeight(Cylinder cylinder) {
        System.out.println("Enter the new height of the cylinder: ");
        cylinder.setHeight(readParameter());
    }

    private static void showParameters(Cylinder cylinder) {
        System.out.printf("Current radius: %f; current height: %f\n", cylinder.getRadius(), cylinder.getHeight());
    }

    private static void showWelcomeMessage() {
        System.out.println("The program allows to calculate the properties of a cylinder, with a given base radius and height, such as:");
        System.out.println("-> surface area of the base");
        System.out.println("-> lateral surface area");
        System.out.println("-> total surface area");
        System.out.println("-> volume\n");
    }

    private static void showMenu() {
        System.out.println("Which function do you want to use?");
        System.out.println("[1] Display the current radius and height of the cylinder");
        System.out.println("[2] Change the height of the cylinder");
        System.out.println("[3] Change the radius of the cylinder");
        System.out.println("[4] Calculate the surface area of the base, lateral surface area, total surface area and volume");
        System.out.println("[5] Exit the program");
    }
}