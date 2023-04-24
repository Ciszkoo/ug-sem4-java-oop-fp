import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program sluzy do planowania spotkan w danym tygodniu");

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
                default -> System.out.println("Wybierz poprawna opcje");
            }
        }

        scanner.close();
    }

    public static void removeMeeting(Calendar calendar) {
        DayOfWeek day = getDayFromUser();
        ArrayList<Meeting> meetings = calendar.getDailyMeetings(day);
        Scanner scanner = new Scanner(System.in);

        printMeetings(meetings, "Brak spotkan w wybranym dniu.");

        System.out.println("Podaj numer spotkania ktore chcesz usunac: ");
        int index = scanner.nextInt();

        calendar.removeMeeting(day, index);
    }

    public static void showDailyMeetingsFiltered(Calendar calendar) {
        DayOfWeek day = getDayFromUser();
        Priority priority = getPriorityFromUser();
//        ArrayList<Meeting> meetings = calendar.getDailyMeetings(day, priority);
        ArrayList<Meeting> meetings = calendar.getDailyMeetings(day, m -> m.getPriority() == priority);

        printMeetings(meetings, "Brak spotkan o wybranym priorytecie w wybranym dniu.");

    }

    public static void showDailyMeetings(Calendar calendar) {
        DayOfWeek day = getDayFromUser();
        ArrayList<Meeting> meetings = calendar.getDailyMeetings(day);

        printMeetings(meetings, "Brak spotkan w wybranym dniu.");
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
        System.out.println("Podaj godzine zakonczenia spotkania (format HH MM)");
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        return LocalTime.of(hour, minute);
    }

    public static LocalTime getStartFromUser() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Podaj godzine rozpoczecia spotkania (format HH MM)");
            int hour = scanner.nextInt();
            int minute = scanner.nextInt();
            LocalTime time = LocalTime.of(hour, minute);
            if (time.isBefore(Meeting.MIN_START_TIME)) {
                System.out.println("Spotkanie musi sie zaczynac najwczesniej o 8:00");
            } else {
                return time;
            }
        }
    }

    public static String getDescriptionFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj opis spotkania:");

        return scanner.nextLine();
    }

    public static Priority getPriorityFromUser() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz priorytet spotkania:");
            System.out.printf("[1] Niski%n[2] Sredni%n[3] Wysoki%n");
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
            System.out.println("Wybierz dzien:");
            System.out.printf("[1] Poniedzialek%n[2] Wtorek%n[3] Sroda%n[4] Czwartek%n[5] Piatek%n[6] Sobota%n[7] Niedziela%n");
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
        System.out.println("[1] Dodaj spotkanie");
        System.out.println("[2] Usun spotkanie");
        System.out.println("[3] Wyswietl spotkania z danego dnia");
        System.out.println("[4] Wyswietl spotkania z danego dnia o konkretnym priorytecie");
        System.out.println("[5] Zakoncz dzialanie programu");
    }


}