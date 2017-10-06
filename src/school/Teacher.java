package school;

public class Teacher extends Person {

    private String subject;

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }


    public Teacher(String firstName, String lastName, String subject){
        setFirstName(firstName);
        setLastName(lastName);
        setSubject(subject);
    }

    @Override
    public String display(){
        return getFullName() + " " + "teaches" + " " + subject + ".";
    }
}
