/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Models;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
/**
 *
 * @author THL
 */
@Entity(name="services")
public class Services {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    @Column(nullable=false, length=150)
    public String designation;
    
    @Column(nullable=false, length=150)
    public double price;
    
    @Column(nullable=false, length=150)
    public String description;
    
    @OneToOne
    @JoinColumn(name = "companyid")
    public Companies Companies;
   
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Companies getCompanies() {
        return Companies;
    }

    public void setCompanies(Companies Companies) {
        this.Companies = Companies;
    }
}
