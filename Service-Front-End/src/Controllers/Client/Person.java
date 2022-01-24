/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Client;

import java.util.Date;

/**
 *
 * @author THL
 */
public class Person {
    
    public int id;
   
    public String firtname;
   
    public String lastname;
    
    public String gender;
    
    public String nif;
    
    public String Persontype;
    
    private Date createdat;
   
    private Date updatedat;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtname;
    }

    public void setFirtName(String firtName) {
        this.firtname = firtName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
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

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }
    
    
}
