
package PROJECT_SchoolManagementSystem;

import java.util.Date;
// Lớp cha đại diện cho một con người
public class Person {
    private String id, name; // Thuộc tính id và tên
    private Date dateOfBirth; // Thuộc tính ngày sinh

    // Constructor với tham số
    public Person(String id, String name, Date dateOfBirth) {
        this.id = id; // Gán giá trị id
        this.name = name; // Gán giá trị tên
        this.dateOfBirth = dateOfBirth; // Gán giá trị ngày sinh
    }

    // Constructor mặc định
    public Person() {}

    // Getter và Setter cho id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    // Getter và Setter cho name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho dateOfBirth
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

