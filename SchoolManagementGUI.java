package PROJECT_SchoolManagementSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SchoolManagementGUI { // Lớp chính của giao diện quản lý trường học.

    private PersonList list; // Biến để quản lý danh sách các đối tượng Person.

    public SchoolManagementGUI() { // Constructor của lớp.
        list = new PersonList(); // Khởi tạo danh sách Person.
        createAndShowGUI(); // Gọi phương thức tạo và hiển thị GUI.
    }

    private void createAndShowGUI() { // Phương thức tạo giao diện người dùng.
        JFrame frame = new JFrame("School Management System"); // Tạo khung JFrame với tiêu đề.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đặt hành động khi đóng cửa sổ.
        frame.setSize(600, 500); // Đặt kích thước khung.

        JButton addStudentButton = new JButton("Add new student"); // Tạo nút để thêm sinh viên.
        JButton addTeacherButton = new JButton("Add new teacher"); // Tạo nút để thêm giáo viên.
        JButton deletePersonButton = new JButton("Delete person by ID"); // Tạo nút để xóa một người theo ID.
        JButton displayAllPersonButton = new JButton("Display all person"); // Tạo nút để hiển thị tất cả.
        JButton findPersonButton = new JButton("Find person by ID"); // Tạo nút để tìm người theo ID.
        JButton countPersonButton = new JButton("Count person in school"); // Tạo nút để đếm số người trong trường.
        JButton findtop3StudentButton = new JButton("Find top 3 students with highest GPA"); // Tạo nút để tìm top 3 sinh viên.

        JPanel panel = new JPanel(); // Tạo bảng điều khiển để chứa các nút.
        panel.add(addStudentButton); // Thêm nút thêm sinh viên vào bảng.
        panel.add(addTeacherButton); // Thêm nút thêm giáo viên vào bảng.
        panel.add(deletePersonButton); // Thêm nút xóa người vào bảng.
        panel.add(displayAllPersonButton); // Thêm nút hiển thị tất cả vào bảng.
        panel.add(findPersonButton); // Thêm nút tìm người vào bảng.
        panel.add(countPersonButton); // Thêm nút đếm người vào bảng.
        panel.add(findtop3StudentButton); // Thêm nút tìm top 3 sinh viên vào bảng.
        frame.add(panel); // Thêm bảng điều khiển vào khung.
        frame.setVisible(true); // Hiển thị khung giao diện.

        addStudentButton.addActionListener(new ActionListener() { // Thêm sự kiện cho nút thêm sinh viên.
            @Override
            public void actionPerformed(ActionEvent e) { // Hành động khi bấm nút.
                String id = JOptionPane.showInputDialog(frame, "Enter ID: "); // Nhập ID từ người dùng.
                String name = JOptionPane.showInputDialog(frame, "Enter full name: "); // Nhập tên từ người dùng.
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày.
                dateFormat.setLenient(false); // Đảm bảo định dạng ngày nghiêm ngặt.
                Date dateOfBirth = null; // Biến lưu ngày sinh.
                while (true) { // Lặp để đảm bảo nhập đúng ngày sinh.
                    String inputDate = JOptionPane.showInputDialog(frame, "Enter date of birth (dd/MM/yyyy): "); // Nhập ngày sinh.
                    try {
                        dateOfBirth = dateFormat.parse(inputDate); // Thử phân tích ngày.
                        break; // Nếu thành công, thoát vòng lặp.
                    } catch (ParseException ex) { // Nếu ngày không hợp lệ.
                        JOptionPane.showMessageDialog(frame, "Invalid date format. Please enter again in the format dd/MM/yyyy.",
                                "Error", JOptionPane.ERROR_MESSAGE); // Hiển thị thông báo lỗi.
                    }
                }
                double gpa = 0.0; // Biến lưu điểm GPA.
                while (true) { // Lặp để đảm bảo nhập đúng GPA.
                    String inputGpa = JOptionPane.showInputDialog(frame, "Enter gpa: "); // Nhập GPA.
                    try {
                        gpa = Double.parseDouble(inputGpa); // Thử chuyển đổi GPA sang số thực.
                        if (gpa >= 0.0 && gpa <= 4.0) { // Kiểm tra GPA trong khoảng hợp lệ.
                            break; // Nếu đúng, thoát vòng lặp.
                        } else {
                            JOptionPane.showMessageDialog(frame, "GPA must be between 0.0 and 4.0", "Error", JOptionPane.ERROR_MESSAGE); // Hiển thị lỗi.
                        }
                    } catch (NumberFormatException ex) { // Nếu không phải số thực.
                        JOptionPane.showMessageDialog(frame, "Invalid GPA. Please enter again", "Error", JOptionPane.ERROR_MESSAGE); // Hiển thị lỗi.
                    }
                }
                double tutionFee = 0.0; // Biến lưu học phí.
                String inputTutionFee = JOptionPane.showInputDialog(frame, "Enter tution fee: "); // Nhập học phí.
                tutionFee = Double.parseDouble(inputTutionFee); // Chuyển đổi học phí sang số thực.
                list.addPerson(new Student(gpa, tutionFee, id, name, dateOfBirth)); // Thêm sinh viên mới vào danh sách.
                JOptionPane.showMessageDialog(frame, "Add student successfully"); // Hiển thị thông báo thành công.
            }
        });

        addTeacherButton.addActionListener(new ActionListener() { // Thêm sự kiện cho nút thêm giáo viên.
            @Override
            public void actionPerformed(ActionEvent e) { // Hành động khi bấm nút.
                String id = JOptionPane.showInputDialog(frame, "Enter ID: "); // Nhập ID từ người dùng.
                String name = JOptionPane.showInputDialog(frame, "Enter full name: "); // Nhập tên từ người dùng.
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày.
                dateFormat.setLenient(false); // Đảm bảo định dạng ngày nghiêm ngặt.
                Date dateOfBirth = null; // Biến lưu ngày sinh.
                while (true) { // Lặp để đảm bảo nhập đúng ngày sinh.
                    String inputDate = JOptionPane.showInputDialog(frame, "Enter date of birth (dd/MM/yyyy): "); // Nhập ngày sinh.
                    try {
                        dateOfBirth = dateFormat.parse(inputDate); // Thử phân tích ngày.
                        break; // Nếu thành công, thoát vòng lặp.
                    } catch (ParseException ex) { // Nếu ngày không hợp lệ.
                        JOptionPane.showMessageDialog(frame, "Invalid date format. Please enter again in the format dd/MM/yyyy.",
                                "Error", JOptionPane.ERROR_MESSAGE); // Hiển thị thông báo lỗi.
                    }
                }
                int numberOfClasses = 0; // Biến lưu số lớp.
                String inputClasses = JOptionPane.showInputDialog(frame, "Enter the number of class: "); // Nhập số lớp.
                numberOfClasses = Integer.parseInt(inputClasses); // Chuyển đổi số lớp sang số nguyên.
                double baseSalary = 0.0; // Biến lưu lương cơ bản.
                String inputSalary = JOptionPane.showInputDialog(frame, "Enter base salary: "); // Nhập lương cơ bản.
                baseSalary = Double.parseDouble(inputSalary); // Chuyển đổi lương cơ bản sang số thực.
                list.addPerson(new Teacher(numberOfClasses, baseSalary, id, name, dateOfBirth)); // Thêm giáo viên mới vào danh sách.
                JOptionPane.showMessageDialog(frame, "Add teacher successfully"); // Hiển thị thông báo thành công.
            }
        });
        deletePersonButton.addActionListener(new ActionListener() { // Thêm sự kiện cho nút xóa người theo ID.
            @Override
            public void actionPerformed(ActionEvent e) { // Hành động khi bấm nút.
                String idDelete = JOptionPane.showInputDialog(frame, "Enter id to delete: "); // Nhập ID để xóa.
                String message = list.deletePersonByID(idDelete); // Gọi phương thức xóa người trong danh sách bằng ID.
                JOptionPane.showMessageDialog(frame, message); // Hiển thị kết quả (thành công hoặc thất bại).
            }
        });

        displayAllPersonButton.addActionListener(new ActionListener() { // Thêm sự kiện cho nút hiển thị tất cả.
            @Override
            public void actionPerformed(ActionEvent e) { // Hành động khi bấm nút.
                ArrayList<Person> people = list.displayAll(); // Lấy danh sách tất cả các đối tượng trong trường.
                StringBuilder message = new StringBuilder("Display all people in school: \n"); // Chuẩn bị chuỗi để hiển thị danh sách.
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày tháng.
                for (Person p : people) { // Duyệt qua danh sách các đối tượng.
                    if (p instanceof Student) { // Nếu đối tượng là sinh viên.
                        message.append("STUDENT ").append("ID: ").append(p.getId()).append("; ").append("Name: ").append(p.getName()).append("; ").append("Date of birth: ").append(dateFormat.format(p.getDateOfBirth())).append("; ").append("GPA: ").append(((Student) p).getGpa()).append("; ").append("Tution fee: ").append(((Student) p).getTuitionFee()).append("\n"); // Thêm thông tin sinh viên vào chuỗi.
                    } else if (p instanceof Teacher) { // Nếu đối tượng là giáo viên.
                        message.append("TEACHER ").append("ID: ").append(p.getId()).append("; ").append("Name: ").append(p.getName()).append("; ").append("Date of birth: ").append(dateFormat.format(p.getDateOfBirth())).append("; ").append("Number of classes: ").append(((Teacher) p).getNumberOfClasses()).append("; ").append("Base salary: ").append(((Teacher) p).getBaseSalary()).append("\n"); // Thêm thông tin giáo viên vào chuỗi.
                    }
                }
                if (people.isEmpty()) { // Nếu danh sách rỗng.
                    JOptionPane.showMessageDialog(frame, "No person in the list"); // Hiển thị thông báo không có người nào.
                } else {
                    JOptionPane.showMessageDialog(frame, message.toString()); // Hiển thị danh sách người trong trường.
                }
            }
        });

        findPersonButton.addActionListener(new ActionListener() { // Thêm sự kiện cho nút tìm người theo ID.
            @Override
            public void actionPerformed(ActionEvent e) { // Hành động khi bấm nút.
                String idFind = JOptionPane.showInputDialog(frame, "Enter id to find: "); // Nhập ID để tìm.
                Person find = list.findPersonByID(idFind); // Tìm kiếm đối tượng trong danh sách bằng ID.
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày tháng.
                if (find != null) { // Nếu tìm thấy đối tượng.
                    if (find instanceof Student) { // Nếu là sinh viên.
                        JOptionPane.showMessageDialog(frame, "STUDENT" + "\n"
                                + "ID: " + find.getId() + "\n"
                                + "Name: " + find.getName() + "\n"
                                + "Date of Birth: " + dateFormat.format(find.getDateOfBirth()) + "\n"
                                + "GPA: " + ((Student) find).getGpa() + "\n"
                                + "Tution fee: " + ((Student) find).getTuitionFee()); // Hiển thị thông tin sinh viên.
                    } else if (find instanceof Teacher) { // Nếu là giáo viên.
                        JOptionPane.showMessageDialog(frame, "TEACHER" + "\n"
                                + "ID: " + find.getId() + "\n"
                                + "Name: " + find.getName() + "\n"
                                + "Date of Birth: " + dateFormat.format(find.getDateOfBirth()) + "\n"
                                + "Number of classes: " + ((Teacher) find).getNumberOfClasses() + "\n"
                                + "Base salary: " + ((Teacher) find).getBaseSalary()); // Hiển thị thông tin giáo viên.
                    }
                } else { // Nếu không tìm thấy đối tượng.
                    JOptionPane.showMessageDialog(frame, "Cannot find person with ID: " + idFind); // Hiển thị thông báo không tìm thấy.
                }
            }
        });

        countPersonButton.addActionListener(new ActionListener() { // Thêm sự kiện cho nút đếm số lượng người.
            @Override
            public void actionPerformed(ActionEvent e) { // Hành động khi bấm nút.
                String message = list.countPerson(); // Gọi phương thức đếm số lượng người trong trường.
                JOptionPane.showMessageDialog(frame, message); // Hiển thị kết quả số lượng người.
            }
        });

        findtop3StudentButton.addActionListener(new ActionListener() { // Thêm sự kiện cho nút tìm top 3 sinh viên.
            @Override
            public void actionPerformed(ActionEvent e) { // Hành động khi bấm nút.
                ArrayList<Student> top3Student = list.findTop3Student(); // Lấy danh sách top 3 sinh viên có GPA cao nhất.
                StringBuilder message = new StringBuilder("Top 3 students with highest GPA\n"); // Chuẩn bị chuỗi để hiển thị.
                for (Student student : top3Student) { // Duyệt qua danh sách top 3 sinh viên.
                    message.append("STUDENT ").append("ID: ").append(student.getId()).append("; ").append("GPA: ").append(student.getGpa()).append("\n"); // Thêm thông tin sinh viên vào chuỗi.
                }
                JOptionPane.showMessageDialog(frame, message); // Hiển thị danh sách top 3 sinh viên.
            }
        });
    }

    public static void main(String[] args) { // Phương thức main để chạy chương trình.
        new SchoolManagementGUI(); // Tạo đối tượng GUI và hiển thị.
    }
}
