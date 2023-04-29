import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program allows to plan weekly meetings");

        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new Calendar();

        while (run) {
            printMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> addMeeting(calendar);
                case 2 -> removeMeeting(calendar);
                case 3 -> showDailyMeetings(calendar);
                case 4 -> showDailyMeetingsFiltered(calendar);
                case 5 -> run = false;
                default -> System.out.println("Choose valid option");
            }
        }

        scanner.close();
    }

    public static void removeMeeting(Calendar calendar) {
        DayOfWeek day = getDayFromUser();
        ArrayList<Meeting> meetings = calendar.getDailyMeetings(day);
        Scanner scanner = new Scanner(System.in);

        printMeetings(meetings, "There is no meetings scheduled for this day.");

        System.out.println("Enter number of meeting you want to delete: ");
        int index = scanner.nextInt();

        calendar.removeMeeting(day, index);
    }

    public static void showDailyMeetingsFiltered(Calendar calendar) {
        DayOfWeek day = getDayFromUser();
        Priority priority = getPriorityFromUser();
//        ArrayList<Meeting> meetings = calendar.getDailyMeetings(day, priority);
        ArrayList<Meeting> meetings = calendar.getDailyMeetings(day, m -> m.getPriority() == priority);

        printMeetings(meetings, "There is no meetings scheduled for this day with selected priority.");

    }

    public static void showDailyMeetings(Calendar calendar) {
        DayOfWeek day = getDayFromUser();
        ArrayList<Meeting> meetings = calendar.getDailyMeetings(day);

        printMeetings(meetings, "There is no meetings scheduled for this day.");
    }

    public static void printMeetings(ArrayList<Meeting> meetings, String noMeetingsMsg) {

        if (meetings.size() == 0) {
            System.out.println(noMeetingsMsg);
            return;
        }

        for (int i = 0; i < meetings.size(); i++) {
            System.out.println("[" + i + "] " + meetings.get(i));
        }
        System.out.println();
    }

    public static void addMeeting(Calendar calendar) {
        DayOfWeek day = getDayFromUser();
        Priority priority = getPriorityFromUser();
        String description = getDescriptionFromUser();
        LocalTime startTime = getStartFromUser();
        LocalTime endTime = getEndFromUser();

        calendar.addMeeting(day, new Meeting(description, startTime, endTime, priority));
    }

    public static LocalTime getEndFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter end time for the meeting (HH MM)");
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        return LocalTime.of(hour, minute);
    }

    public static LocalTime getStartFromUser() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter start time of the meeting (HH MM)");
            int hour = scanner.nextInt();
            int minute = scanner.nextInt();
            LocalTime time = LocalTime.of(hour, minute);
            if (time.isBefore(Meeting.MIN_START_TIME)) {
                System.out.println("Meeting can't start before 8:00 a.m.");
            } else {
                return time;
            }
        }
    }

    public static String getDescriptionFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter description:");

        return scanner.nextLine();
    }

    public static Priority getPriorityFromUser() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose priority of the meeting:");
            System.out.printf("[1] Low%n[2] Medium%n[3] High%n");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    return Priority.LOW;
                }
                case 2 -> {
                    return Priority.MEDIUM;
                }
                case 3 -> {
                    return Priority.HIGH;
                }
            }

        }
    }

    public static DayOfWeek getDayFromUser() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose day:");
            System.out.printf("[1] Monday%n[2] Tuesday%n[3] Wednesday%n[4] Thursday%n[5] Friday%n[6] Saturday%n[7] Sunday%n");
            int choice  = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    return DayOfWeek.MONDAY;
                }
                case 2 -> {
                    return DayOfWeek.TUESDAY;
                }
                case 3 -> {
                    return DayOfWeek.WEDNESDAY;
                }
                case 4 -> {
                    return DayOfWeek.THURSDAY;
                }
                case 5 -> {
                    return DayOfWeek.FRIDAY;
                }
                case 6 -> {
                    return DayOfWeek.SATURDAY;
                }
                case 7 -> {
                    return DayOfWeek.SUNDAY;
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("[1] Add meeting");
        System.out.println("[2] Delete meeting");
        System.out.println("[3] Show meetings for a specified day");
        System.out.println("[4] Show meetings for a specified day with selected priority");
        System.out.println("[5] Close the program");
    }


}