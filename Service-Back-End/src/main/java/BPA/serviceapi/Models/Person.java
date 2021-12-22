/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Models;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author THL
 */
@Entity(name="person")
public class Person {
    
    @Id
    public int id;
    
    @Column(nullable=false, length=50)
    public String firtName;
    
    @Column(nullable=false, length=50)
    public String lastName;
    
    @Column(nullable=false, length=14)
    public String gender;
    
    @Column(nullable=false, length=14)
    public String nif;
    
    @Column(nullable=false, length=20)
    public String Persontype;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPersontype() {
        return Persontype;
    }

    public void setPersontype(String Persontype) {
        this.Persontype = Persontype;
    }
    
}
