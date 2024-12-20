package PROJECT_SchoolManagementSystem;

import java.util.ArrayList;

public class PersonList {

    ArrayList<Person> personList = new ArrayList<>();

    void addPerson(Person person) {
        personList.add(person);
    }

    String deletePersonByID(String id) {
        for (Person p : personList) {
            if (id.equals(p.getId())) {
                personList.remove(p);
                return "Delete person with ID " + id + " successfully";
            }
        }
        return "Cannot find person with ID: " + id;
    }

    Person findPersonByID(String id) {
        for (Person p : personList) {
            if (id.equalsIgnoreCase(p.getId())) {
                return p;
            }
        }
        return null;
    }

    ArrayList<Person> displayAll() {
        return personList;
    }

    String countPerson() {
        int numTeacher = 0;
        int numStudent = 0;
        for (Person p : personList) {
            if (p instanceof Student) {
                numStudent++;
            } else if (p instanceof Teacher) {
                numTeacher++;
            }
        }
        return "Number of student: " + numStudent + " \nNumber of teacher: " + numTeacher;
    }
    ArrayList<Student> findTop3Student() {
        ArrayList<Student> students = new ArrayList<>();
        Student top1 = null, top2 =null, top3 = null;
        for(Person person:personList) {
        if(person instanceof Student) {
            students.add((Student) person);
        }
    }
        for(Student student:students) {
            if(top1 == null|| student.getGpa()>top1.getGpa()) {
                top3 = top2;
                top2= top1; 
                top1= student;
            }
            else if(top2 == null||student.getGpa()>top2.getGpa()) {
                top3 = top2;
                top2= student;
            } else if(top3==null||student.getGpa()>top3.getGpa()) {
                top3 = student;
            }
        }
        ArrayList<Student> top3Student = new ArrayList<>();
        if(top1 != null) {
        top3Student.add(top1);
        }
        if(top2 != null) {
        top3Student.add(top2);
        }
        if(top3 != null) {
        top3Student.add(top3);
        }
        return top3Student;
    }

}
