package school;

import util.Displayable;

public abstract class Person implements Displayable {

    private String firstName;
    private String lastName;

    protected Person() {
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return firstName;
    }

    public Person(String fullName){
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

}
