/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Models;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;

/**
 *
 * @author THL
 */
@Entity(name="person")
public class Person {
    
    
    //@Column(name = "TENANT_ENT_ID", nullable = false, columnDefinition = "int default 1")
    
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    @Column(nullable=false, length=50)
    public String firtname;
    
   
    @Column(nullable=false, length=50)
    public String lastname;
    
    
    @Column(nullable=false, length=14)
    public String gender;
    
    
    @Column(nullable=false, length=14)
    public String nif;
    
    
    @Column(nullable=false, length=20)
    public String Persontype;
    
    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdat;
    
    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
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
