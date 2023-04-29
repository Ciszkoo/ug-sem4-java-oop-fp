import java.time.LocalTime;

public class Meeting {

    final static LocalTime MIN_START_TIME = LocalTime.of(8, 0);

    private String description;
    private LocalTime start;
    private LocalTime end;
    private Priority priority;

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setStart(LocalTime start) {
        this.start = start;
    }
    public LocalTime getStart() {
        return start;
    }
    public void setEnd(LocalTime end) {
        this.end = end;
    }
    public LocalTime getEnd() {
        return end;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public Priority getPriority() {
        return priority;
    }

    public Meeting() {}
    public Meeting(String description, LocalTime start, LocalTime end, Priority priority) {
        this.description = description;
        this.start = start;
        this.end = end;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Start: " + start + "; End: " + end + "; Priority: " + priority.getValue() + "; Description: " + description;
    }
}

enum Priority {
    LOW("Low"), MEDIUM("Medium"), HIGH("High");

    private final String value;

    Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}