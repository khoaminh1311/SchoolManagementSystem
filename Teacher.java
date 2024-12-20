package PROJECT_SchoolManagementSystem;

import java.util.Date;

// Lớp đại diện cho giáo viên, kế thừa từ Person
public class Teacher extends Person {

    private int numberOfClasses; // Số lớp dạy
    private double baseSalary; // Lương cơ bản

    // Constructor với tham số
    public Teacher(int numberOfClasses, double baseSalary, String id, String name, Date dateOfBirth) {
        super(id, name, dateOfBirth); // Gọi constructor lớp cha
        this.numberOfClasses = numberOfClasses; // Gán giá trị số lớp
        this.baseSalary = baseSalary; // Gán giá trị lương cơ bản
    }

    // Constructor mặc định
    public Teacher() {
    }

    // Getter và Setter cho số lớp
    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    // Getter và Setter cho lương cơ bản
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
