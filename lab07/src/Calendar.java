import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Calendar {
    private ArrayList<ArrayList<Meeting>> meetings;

    public void setMeetings(ArrayList<ArrayList<Meeting>> meetings) {
        this.meetings = meetings;
    }

    public ArrayList<ArrayList<Meeting>> getMeetings() {
        return meetings;
    }

    public Calendar() {
        this(7);
    }

    private Calendar(int n) {
        ArrayList<ArrayList<Meeting>> days = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            days.add(new ArrayList<>());
        }
        this.meetings = days;
    }

    public void addMeeting(DayOfWeek day, Meeting meeting) {
        meetings.get(day.getValue() - 1).add(meeting);
    }

    public ArrayList<Meeting> getDailyMeetings(DayOfWeek day) {
        return meetings.get(day.getValue() - 1);
    }

    public ArrayList<Meeting> getDailyMeetings(DayOfWeek day, Predicate<Meeting> predicate) {
        ArrayList<Meeting> dailyMeetings = getDailyMeetings(day);
        ArrayList<Meeting> filteredDailyMeetings = new ArrayList<>();
        for (var meeting : dailyMeetings) {
            if (predicate.test(meeting)) {
                filteredDailyMeetings.add(meeting);
            }
        }
        return filteredDailyMeetings;
    }

    public ArrayList<Meeting> getDailyMeetings(DayOfWeek day, Priority priority) {
        ArrayList<Meeting> dailyMeetings = getDailyMeetings(day);
        ArrayList<Meeting> filteredDailyMeetings = new ArrayList<>();
        for (var meeting : dailyMeetings) {
            if (meeting.getPriority() == priority) {
                filteredDailyMeetings.add(meeting);
            }
        }
        return filteredDailyMeetings;
    }

    public void removeMeeting(DayOfWeek day, int index) {
        meetings.get(day.getValue() - 1).remove(index);
    }


}
