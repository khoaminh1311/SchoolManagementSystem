package PROJECT_SchoolManagementSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SchoolManagementGUI {

    private PersonList list;

    public SchoolManagementGUI() {
        list = new PersonList();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("School Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        JButton addStudentButton = new JButton("Add new student");
        JButton addTeacherButton = new JButton("Add new teacher");
        JButton deletePersonButton = new JButton("Delete person by ID");
        JButton displayAllPersonButton = new JButton("Display all person");
        JButton findPersonButton = new JButton("Find person by ID");
        JButton countPersonButton = new JButton("Count person in school");
        JButton findtop3StudentButton = new JButton("Find top 3 students with highest GPA");

        JPanel panel = new JPanel();
        panel.add(addStudentButton);
        panel.add(addTeacherButton);
        panel.add(deletePersonButton);
        panel.add(displayAllPersonButton);
        panel.add(findPersonButton);
        panel.add(countPersonButton);
        panel.add(findtop3StudentButton);
        frame.add(panel);
        frame.setVisible(true);

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("Enter ID: ");
                String name = JOptionPane.showInputDialog("Enter full name: ");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                Date dateOfBirth = null;
                while (true) {
                    String inputDate = JOptionPane.showInputDialog("Enter date of birth (dd/MM/yyyy): ");
                    try {
                        dateOfBirth = dateFormat.parse(inputDate);
                        break;
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid date format. Please enter again in the format dd/MM/yyyy.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                double gpa = 0.0;
                while (true) {

                    String inputGpa = JOptionPane.showInputDialog("Enter gpa: ");
                    try {
                        gpa = Double.parseDouble(inputGpa);
                        if (gpa >= 0.0 && gpa <= 4.0) {
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "GPA must be between 0.0 and 4.0", "Error", JOptionPane.ERROR_MESSAGE);

                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid GPA. Please enter again", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                double tutionFee = 0.0;
                String inputTutionFee = JOptionPane.showInputDialog("Enter tution fee: ");
                tutionFee = Double.parseDouble(inputTutionFee);
                list.addPerson(new Student(gpa, tutionFee, id, name, dateOfBirth));
                JOptionPane.showMessageDialog(frame, "Add student successfully");
            }
        });
        addTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog("Enter ID: ");
                String name = JOptionPane.showInputDialog("Enter full name: ");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                Date dateOfBirth = null;
                while (true) {
                    String inputDate = JOptionPane.showInputDialog("Enter date of birth (dd/MM/yyyy): ");
                    try {
                        dateOfBirth = dateFormat.parse(inputDate);
                        break;
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid date format. Please enter again in the format dd/MM/yyyy.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                int numberOfClasses = 0;
                String inputClasses = JOptionPane.showInputDialog("Enter the number of class: ");
                numberOfClasses = Integer.parseInt(inputClasses);
                double baseSalary = 0.0;
                String inputSalary = JOptionPane.showInputDialog("Enter base salary: ");
                baseSalary = Double.parseDouble(inputSalary);
                list.addPerson(new Teacher(numberOfClasses, baseSalary, id, name, dateOfBirth));
                JOptionPane.showMessageDialog(frame, "Add teacher successfully");
            }
        });
        deletePersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idDelete = JOptionPane.showInputDialog("Enter id to delete: ");
                String message = list.deletePersonByID(idDelete);
                JOptionPane.showMessageDialog(frame, message);
            }
        });
        displayAllPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Person> people = list.displayAll();
                StringBuilder message = new StringBuilder("Display all people in school: \n");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                for (Person p : people) {
                    if (p instanceof Student) {
                        message.append("STUDENT ").append("ID: ").append(p.getId()).append("; ").append("Name: ").append(p.getName()).append("; ").append("Date of birth: ").append(dateFormat.format(p.getDateOfBirth())).append("; ").append("GPA: ").append(((Student) p).getGpa()).append("; ").append("Tution fee: ").append(((Student) p).getTutionFee()).append("\n");
                    } else if (p instanceof Teacher) {
                        message.append("TEACHER ").append("ID: ").append(p.getId()).append("; ").append("Name: ").append(p.getName()).append("; ").append("Date of birth: ").append(dateFormat.format(p.getDateOfBirth())).append("; ").append("Number of classes: ").append(((Teacher) p).getNumberOfClasses()).append("; ").append("Base salary: ").append(((Teacher) p).getBaseSalary()).append("\n");
                    }
                }
                if (people.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No person in the list");
                } else {
                    JOptionPane.showMessageDialog(frame, message.toString());
                }
            }
        });
        findPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idFind = JOptionPane.showInputDialog("Enter id to find: ");
                Person find = list.findPersonByID(idFind);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                if (find != null) {
                    if (find instanceof Student) {
                        JOptionPane.showMessageDialog(null, "STUDENT" + "\n"
                                + "ID: " + find.getId() + "\n"
                                + "Name: " + find.getName() + "\n"
                                + "Date of Birth: " + dateFormat.format(find.getDateOfBirth()) + "\n"
                                + "GPA: " + ((Student) find).getGpa() + "\n"
                                + "Tution fee: " + ((Student) find).getTutionFee());
                    } else if (find instanceof Teacher) {
                        JOptionPane.showMessageDialog(null, "TEACHER" + "\n"
                                + "ID: " + find.getId() + "\n"
                                + "Name: " + find.getName() + "\n"
                                + "Date of Birth: " + dateFormat.format(find.getDateOfBirth()) + "\n"
                                + "Number of classes: " + ((Teacher) find).getNumberOfClasses() + "\n"
                                + "Tution fee: " + ((Teacher) find).getBaseSalary());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot find person with ID: " + idFind);
                }
            }
        });
        countPersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = list.countPerson();
                JOptionPane.showMessageDialog(frame, message);
            }
        });
        findtop3StudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Student> top3Student = list.findTop3Student();
                StringBuilder message = new StringBuilder("Top 3 students with highest GPA\n");
                for (Student student : top3Student) {
                    message.append("STUDENT ").append("ID: ").append(student.getId()).append("; ").append("GPA: ").append(student.getGpa()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, message);
            }
        });
    }

    public static void main(String[] args) {
        new SchoolManagementGUI();
    }
}
