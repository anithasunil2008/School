import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import util.*;
import school.*;

import java.util.ArrayList;

public class PrintReports {
    String print;
    String msg1;
    Student s;
    Teacher t;
    int roomNumber;

    Classroom c;

    ArrayList<Displayable> crList = new ArrayList<Displayable>();
    //ArrayList<Displayable> tecList = new ArrayList<Displayable>();
    ArrayList<Displayable> stuList = new ArrayList<Displayable>();



    public static void main(String[] args) {
        new PrintReports();
    }

    public PrintReports() {

        do {
            enterClassroom();
            print = KeyboardReader.getPromptedString("Enter Another Classroom? (Yes/No): ");
        } while (print.equals("yes") || print.equals("YES") || print.equals("Y") || print.equals("y"));
        report();
    }


    public void enterClassroom() {

        System.out.println("First You Need To Create A Classroom\n");

        //Enter Class Room number
        do {
            roomNumber = KeyboardReader.getPromptedInt("Enter Room Number: ");
            {
                if (roomNumber < 100) {
                    System.out.println("Room Number must be greater than 100");
                }
            }
        } while (roomNumber < 100);

        //Entering teacher details
        Displayable teacher = enterTeacher();

        //Enter student details
        do {
            Displayable stu = enterStudent();
            msg1 = KeyboardReader.getPromptedString("Enter Another Student? (Yes/No):");
            stuList.add(stu);
        } while (msg1.equals("yes") || msg1.equals("YES") || msg1.equals("Y") || msg1.equals("y"));

        Classroom classRoom = new Classroom(roomNumber, teacher, (Displayable) stuList);

        crList.add(classRoom);

        //return crList;
    }


    public Displayable enterTeacher() {

        System.out.println("\nNow You Need To Enter A Teacher For The Classroom.\n");
        String firstName = KeyboardReader.getPromptedString("Enter Teacher First Name: ");
        String lastName = KeyboardReader.getPromptedString("Enter Teacher Last Name: ");
        String subject = KeyboardReader.getPromptedString("Enter Subject Taught: ");
        t = new Teacher(firstName, lastName, subject);
        //tecList.add(t);
        System.out.println("\n");
        return t;
    }

    public Displayable enterStudent() {

        System.out.println("Now You Need To Add Students For The Classroom\n");
        s = new Student();
        String stufirstName = KeyboardReader.getPromptedString("Enter Student First Name: ");
        String stulastName = KeyboardReader.getPromptedString("Enter Student Last Name: ");
        try {
            int stuId = KeyboardReader.getPromptedInt("Enter Student ID:");
            {
                if (stuId <= 0) {
                    System.out.println("Student Id must be greater than zero");
                }
            }
            int stuGrade = KeyboardReader.getPromptedInt("Enter Student Final Grade:");
            s.setStudentId(stuId);
            s.setFinalGrade(stuGrade);
        } catch (NumberFormatException e) {
            System.out.println("Please enter the valid number.");
        }
        s.setFirstName(stufirstName);
        s.setLastName(stulastName);
        stuList.add(s);
        System.out.println("\n");
        return s;
    }

    public void report(ArrayList<Displayable> classRoomList) {
        System.out.println("\n-----------------------------------------\n");
        for (int i = 0; i < classRoomList.size(); i++)
            for (Classroom classroom : classRoomList.get(i).getClassroom()) {
                System.out.println("Room No = " + classroom.display());
                System.out.println("Teacher Info:");
                String teacherInfo = classroom.getTeacher().display();
            }


        System.out.println("\n-----------------------------------------\n");
    }
}
