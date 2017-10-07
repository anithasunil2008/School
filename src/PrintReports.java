import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import util.*;
import school.*;

import java.util.ArrayList;
import java.util.Iterator;

public class PrintReports {
    String print;
    String studentEntryPrompt;
    Student s;
    Teacher t;
    int roomNumber;

    ArrayList<Displayable> crList = new ArrayList<Displayable>();
    ArrayList<Displayable> stuList = new ArrayList<Displayable>();



    public static void main(String[] args) {
        new PrintReports();
    }

    public PrintReports() {

        do {
            Classroom cr = enterClassroom();
            crList.add(cr);
            print = KeyboardReader.getPromptedString("Enter Another Classroom? (Yes/No): ");
        } while (print.equals("yes") || print.equals("YES") || print.equals("Y") || print.equals("y") || print.equals("Yes"));
        report(crList);
    }


    public Classroom enterClassroom() {

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
            studentEntryPrompt = KeyboardReader.getPromptedString("Enter Another Student? (Yes/No):");
            stuList.add(stu);
        } while (studentEntryPrompt.equals("yes") || studentEntryPrompt.equals("YES") || studentEntryPrompt.equals("Y") || studentEntryPrompt.equals("y") || studentEntryPrompt.equals("Yes"));

        Classroom classRoom = new Classroom(roomNumber, teacher, stuList);

        return classRoom;
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
        //s = new Student();
        String stuFirstName = KeyboardReader.getPromptedString("Enter Student First Name: ");
        String stuLastName = KeyboardReader.getPromptedString("Enter Student Last Name: ");
        try {
            int stuId = KeyboardReader.getPromptedInt("Enter Student ID:");
            {
                if (stuId <= 0) {
                    System.out.println("Student Id must be greater than zero");
                }
            }
            String stuGrade = KeyboardReader.getPromptedString("Enter Student Final Grade:");
            //s.setStudentId(stuId);
            //s.setFinalGrade(stuGrade);
            s = new Student (stuId, stuFirstName, stuLastName, stuGrade);
        } catch (NumberFormatException e) {
            System.out.println("Please enter the valid number.");
        }
        //s.setFirstName(stufirstName);
        //s.setLastName(stulastName);
        stuList.add(s);
        System.out.println("\n");
        return s;
    }

    public void report(ArrayList<Displayable> classRoomList) {
        System.out.println("\n-----------------------------------------\n");

        for (int i = 0; i < classRoomList.size(); i++){
            Classroom cr = (Classroom) classRoomList.get(i);
            //Print room number
            System.out.println(cr.display());
            //Print teacher details
            System.out.println("Teacher Details : " + cr.getTeacher().display());
            //Print student details
            for (int j = 0; j< cr.getStudents().size(); j++) {
                Student stu = (Student) cr.getStudents().get(j);
                System.out.println(stu.display());
            }
        }
        System.out.println("\n-----------------------------------------\n");
    }
}
