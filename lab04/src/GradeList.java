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
        if (grades == null) {
            grades = new ArrayList<>();
        }
        grades.add(grade);
    }

    public Double averageGrade() {
        if (grades == null || grades.size() == 0) {
            return null;
        }
        double sum = 0;
        for (var grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private Double extremeGrade(ComparisonTrait comparison) {
        if (grades == null || grades.size() == 0) {
            return null;
        }
        double extremeVal = grades.get(0);
        for (var grade : grades) {
            if (comparison.compare(grade, extremeVal)) extremeVal = grade;
        }
        return extremeVal;
    }

    public Double minGrade() {
        return extremeGrade((x, y) -> x < y);
    }

    public Double maxGrade() {
        return extremeGrade((x, y) -> x > y);
    }
}
