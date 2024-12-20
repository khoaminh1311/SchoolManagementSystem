package PROJECT_SchoolManagementSystem;

import java.util.Date;

public class Teacher extends Person {

    int numberOfClasses;
    double baseSalary;

    public Teacher(int numberOfClasses, double baseSalary, String id, String name, Date dateOfBirth) {
        super(id, name, dateOfBirth);
        this.numberOfClasses = numberOfClasses;
        this.baseSalary = baseSalary;
    }

    public Teacher() {
    }

    public double caluclateIncome() {
        return numberOfClasses * baseSalary;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
