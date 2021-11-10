package nl.novi.end.project.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Attributen
    private String Name;
    private String Lastname;
    private String Emailaddress;
    private char Gender;
    private String Age;
    private int Phonenumber;

    //constructor niet nodig

    //Getters and setters

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmailaddress() {
        return Emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        Emailaddress = emailaddress;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char gender) {
        Gender = gender;
    }

    public int getAge() {
        return Integer.parseInt(Age);
    }

    public void setAge(String age) {
        Age = age;
    }

    public int getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        Phonenumber = phonenumber;
    }

    public void setGender(String gender) {
    }
}
