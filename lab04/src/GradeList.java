import java.util.ArrayList;

public class GradeList {

    private ArrayList<Double> grades;

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }

    public GradeList() {
    }

    public GradeList(ArrayList<Double> grades) {
        this.grades = grades;
    }

    public void addGrade(double grade) {
        this.grades.add(grade);
    }

    public Double averageGrade() {
        if (grades.size() == 0) {
            return null;
        } else {
            int sum = 0;
            for (var grade : grades) {
                sum += grade;
            }
            return (double) sum / (double) grades.size();
        }
    }

    public Double minGrade() {
        if (grades.size() == 0) {
            return null;
        } else {
            double min = grades.get(0);
            for (var grade : grades) {
                if (grade < min) min = grade;
            }
            return min;
        }
    }

    public Double maxGrade() {
        if (grades.size() == 0) {
            return null;
        } else {
            double max = grades.get(0);
            for (var grade : grades) {
                if (grade > max) max = grade;
            }
            return max;
        }
    }
}
