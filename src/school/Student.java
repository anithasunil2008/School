package school;

public class Student extends Person {

    private int studentId;
    private String finalGrade;
    private String firstName;
    private String lastName;

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public int getStudentId(){
        return studentId;
    }

    public void setFinalGrade(String finalGrade){
        this.finalGrade = finalGrade;
    }

    public String getFinalGrade(){
        return finalGrade;
    }

    public Student(){
    }

    public Student(int studentId, String firstName, String lastName, String finalGrade){
        setStudentId(studentId);
        setFirstName(firstName);
        setLastName(lastName);
        setFinalGrade(finalGrade);
    }

    @Override
    public String display(){
        return "Student ID:" + " " + studentId + "   " + getFullName() + "    " + "Final Grade: " + getFinalGrade();
    }
}
