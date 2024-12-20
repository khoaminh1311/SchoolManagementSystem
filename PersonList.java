package PROJECT_SchoolManagementSystem;

import java.util.ArrayList;

// Lớp quản lý danh sách Person
public class PersonList {

    private ArrayList<Person> personList = new ArrayList<>(); // Danh sách các đối tượng Person

    // Thêm một người vào danh sách
    public void addPerson(Person person) {
        personList.add(person);
    }

    // Xóa người theo ID
    public String deletePersonByID(String id) {
        for (Person p : personList) {
            if (id.equals(p.getId())) { //nếu tìm được id trong danh sách
                personList.remove(p); // Xóa người khỏi danh sách
                return "Delete person with ID " + id + " successfully"; //in thông báo xóa thành công
            }
        }
        return "Cannot find person with ID: " + id; // Không tìm thấy ID
    }

    // Tìm người theo ID
    public Person findPersonByID(String id) {
        for (Person p : personList) {
            if (id.equalsIgnoreCase(p.getId())) { //nếu tìm được id trong danh sách
                return p; // Trả về người tìm được
            }
        }
        return null; // Không tìm thấy
    }

    // Hiển thị toàn bộ danh sách
    public ArrayList<Person> displayAll() {
        return personList;//in ra toàn bộ người trong danh sách
    }

    public String countPerson() {
        // Hàm để đếm số lượng sinh viên và giáo viên trong danh sách.  

        int numTeacher = 0;
        // Biến numTeacher dùng để đếm số lượng giáo viên, khởi tạo giá trị ban đầu là 0.  

        int numStudent = 0;
        // Biến numStudent dùng để đếm số lượng sinh viên, khởi tạo giá trị ban đầu là 0.  

        for (Person p : personList) {
            // Duyệt qua từng phần tử trong danh sách personList.  

            if (p instanceof Student) {
                // Nếu đối tượng là instance của lớp Student.  
                numStudent++;
                // Tăng biến đếm số lượng sinh viên lên 1.  
            } else if (p instanceof Teacher) {
                // Nếu đối tượng là instance của lớp Teacher.  
                numTeacher++;
                // Tăng biến đếm số lượng giáo viên lên 1.  
            }
        }

        return "Number of student: " + numStudent + " \nNumber of teacher: " + numTeacher;
        // Trả về chuỗi chứa số lượng sinh viên và giáo viên.  
    }

    // Tìm top 3 sinh viên có GPA cao nhất
    public ArrayList<Student> findTop3Student() { // Phương thức để tìm 3 sinh viên có GPA cao nhất.
        ArrayList<Student> students = new ArrayList<>(); // Danh sách lưu trữ các sinh viên.
        Student top1 = null, top2 = null, top3 = null; // Biến để lưu trữ 3 sinh viên có GPA cao nhất.

        for (Person person : personList) { // Duyệt qua danh sách các đối tượng trong personList.
            if (person instanceof Student) { // Kiểm tra nếu đối tượng là instance của Student.
                students.add((Student) person); // Thêm sinh viên vào danh sách students.
            }
        }

        for (Student student : students) { // Duyệt qua danh sách sinh viên.
            if (top1 == null || student.getGpa() > top1.getGpa()) { // Kiểm tra nếu sinh viên này có GPA cao hơn top1.
                top3 = top2; // Gán top2 cho top3.
                top2 = top1; // Gán top1 cho top2.
                top1 = student; // Gán sinh viên hiện tại cho top1.
            } else if (top2 == null || student.getGpa() > top2.getGpa()) { // Kiểm tra nếu sinh viên này có GPA cao hơn top2.
                top3 = top2; // Gán top2 cho top3.
                top2 = student; // Gán sinh viên hiện tại cho top2.
            } else if (top3 == null || student.getGpa() > top3.getGpa()) { // Kiểm tra nếu sinh viên này có GPA cao hơn top3.
                top3 = student; // Gán sinh viên hiện tại cho top3.
            }
        }

        ArrayList<Student> top3Student = new ArrayList<>(); // Danh sách lưu trữ 3 sinh viên có GPA cao nhất.
        if (top1 != null) { // Kiểm tra nếu top1 không null.
            top3Student.add(top1); // Thêm top1 vào danh sách top3Student.
        }
        if (top2 != null) { // Kiểm tra nếu top2 không null.
            top3Student.add(top2); // Thêm top2 vào danh sách top3Student.
        }
        if (top3 != null) { // Kiểm tra nếu top3 không null.
            top3Student.add(top3); // Thêm top3 vào danh sách top3Student.
        }
        return top3Student; // Trả về danh sách 3 sinh viên có GPA cao nhất.
    }

}
