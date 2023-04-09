import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("The program calculates the factorial of a number n provided by the user or the nth power of the number 2.");

        boolean run = true;
        Scanner optionScanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);

        while (run) {
            System.out.println("Choose an option");
            System.out.println("[1] Calculate factorial of n");
            System.out.println("[2] Calculate nth power of 2");
            int option = optionScanner.nextInt();
            switch (option) {
                case 1 -> factorialHandler();
                case 2 -> powerHandler();
                default -> {
                }
            }

            System.out.print("Do you want to continue running the program? [Y/N]: ");
            String next = strScanner.nextLine();

            if (next.equals("N")) {
                run = false;
            }
        }

        optionScanner.close();
        strScanner.close();
    }

    private static void powerHandler() {
        Scanner numberScanner = new Scanner(System.in);

        System.out.print("Enter the power of 2 you want to calculate: ");
        int number = numberScanner.nextInt();

        long power = twoPowerN(number);
        System.out.printf("Result: 2^%d = %d\n", number, power);

    }

    private static void factorialHandler() {
        Scanner numberScanner = new Scanner(System.in);

        System.out.print("Enter the number whose factorial you want to calculate: ");
        int number = numberScanner.nextInt();

        long factorial = factorial(number);
        System.out.printf("Result: %d! = %d\n", number, factorial);

    }

    private static long factorial(int n) {

        long product = 1;

        for (int i = 1; i <= n; i++) {
            product *= i;
        }

        return product;
    }

    private static long twoPowerN(int exponent) {

        if (exponent == 0) return 1;

        long base = 2;

        for (int i = 1; i <= exponent; i++) {
            base *= 2;
        }

        return base;
    }
}