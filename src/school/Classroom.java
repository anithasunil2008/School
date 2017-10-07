package school;

import util.*;

import java.lang.String;
import java.util.ArrayList;

public class Classroom extends Person implements Displayable {

    private int roomNumber;
    private Displayable teacher;
    private ArrayList<Displayable> studentList;


    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getroomNumber() {
        return roomNumber;
    }

    public void setTeacher(Displayable teacher) {
        this.teacher = teacher;
    }

    public Displayable getTeacher() {
        return this.teacher;
    }

    public void setStudents(ArrayList<Displayable> studentList) { this.studentList = studentList; }

    public ArrayList<Displayable> getStudents() { return this.studentList; }

    public Classroom(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Classroom(int roomNumber, Displayable teacher, ArrayList<Displayable> studentList) {
        setRoomNumber(roomNumber);
        setTeacher(teacher);
        setStudents((ArrayList<Displayable>) studentList);
    }


    @Override
    public String display() {
        return "Room Number: " + roomNumber;

    }
}
