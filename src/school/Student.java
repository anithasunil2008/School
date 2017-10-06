package school;

public class Student extends Person {

    private int studentId;
    private int finalGrade;
    private String firstName;
    private String lastName;

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public int getStudentId(){
        return studentId;
    }

    public void setFinalGrade(int finalGrade){
        this.finalGrade = finalGrade;
    }

    public int getFinalGrade(){
        return finalGrade;
    }

    public Student(){
    }

    @Override
    public String display(){
        return "Student ID:" + " " + studentId + "   " + getFullName() + "    " + "Final Grade: " + getFinalGrade();
    }
}
