package PROJECT_SchoolManagementSystem;

import java.util.Date;

// Lớp đại diện cho sinh viên, kế thừa từ Person
public class Student extends Person {

    private double gpa, tuitionFee; // Thuộc tính GPA và học phí

    // Constructor với tham số
    public Student(double gpa, double tuitionFee, String id, String name, Date dateOfBirth) {
        super(id, name, dateOfBirth); // Gọi constructor lớp cha
        this.gpa = gpa; // Gán giá trị GPA
        this.tuitionFee = tuitionFee; // Gán giá trị học phí
    }

    // Constructor mặc định
    public Student() {
    }

    // Getter và Setter cho GPA
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // Getter và Setter cho học phí
    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }
}
