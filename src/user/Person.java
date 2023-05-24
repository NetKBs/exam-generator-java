/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author Net
 */
public class Person {
    private String name;
    private String lastname;
    
    public Person (String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    
    // setters
    public void setName (String name) {
        this.name = name;
    }
    
    public void setLastname (String lastname) {
        this.lastname = lastname;
    }
    
    // getters
    public String getName() {
        return name;
    }
    
    public String getLastname() {
        return lastname;
    }
}
