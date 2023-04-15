import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        printWelcomeMessage();

        boolean run = true;
        Scanner optionScanner = new Scanner(System.in);
        GradeList grades = new GradeList();

        while (run) {
            printMenu();
            int option = optionScanner.nextInt();
            switch (option) {
                case 1 -> addGrade(grades);
                case 2 -> getAvgGrade(grades);
                case 3 -> getMaxGrade(grades);
                case 4 -> getMinGrade(grades);
                case 5 -> run = false;
                default -> System.out.println("You chose invalid option");
            }
        }
    }

    static void printWelcomeMessage() {
        System.out.println("This program allows you to add grades to the list. It can be used to calculate the average grade, find the smallest or largest grade.");
    }

    static void printMenu() {
        System.out.println("Select an action:");
        System.out.println("[1] Add grade");
        System.out.println("[2] Get average grade");
        System.out.println("[3] Get the highest grade");
        System.out.println("[4] Get the lowest grade");
        System.out.println("[5] Exit the program");
    }

    static void addGrade(GradeList grades) {
        Scanner gradeScanner = new Scanner(System.in);
        System.out.print("Grade: ");
        double grade = gradeScanner.nextDouble();
        grades.addGrade(grade);
    }

    static void getAvgGrade(GradeList grades) {
        Double avgGrade = grades.averageGrade();
        if (avgGrade == null) {
            printEmpty();
        } else {
            System.out.printf("Average grade: %f\n", avgGrade);
        }
    }

    static void getMinGrade(GradeList grades) {
        Double minGrade = grades.minGrade();
        if (minGrade == null) {
            printEmpty();
        } else {
            System.out.printf("The lowest grade: %f\n", minGrade);
        }
    }

    static void getMaxGrade(GradeList grades) {
        Double maxGrade = grades.maxGrade();
        if (maxGrade == null) {
            printEmpty();
        } else {
            System.out.printf("The lowest grade: %f\n", maxGrade);
        }
    }

    static void printEmpty() {
        System.out.println("List of grades is empty.");
    }
}