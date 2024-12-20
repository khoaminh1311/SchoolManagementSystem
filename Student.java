package PROJECT_SchoolManagementSystem;

import java.util.Date;

public class Student extends Person {

    private double gpa, tutionFee;

    public Student(double gpa, double tutionFee, String id, String name, Date dateOfBirth) {
        super(id, name, dateOfBirth);
        this.gpa = gpa;
        this.tutionFee = tutionFee;
    }

    public Student() {
    }

    public double caluclateIncome() {
        if (gpa > 3.5) {
            return tutionFee * 0.5;
        } else {
            return tutionFee;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getTutionFee() {
        return tutionFee;
    }

    public void setTutionFee(double tutionFee) {
        this.tutionFee = tutionFee;
    }
}
