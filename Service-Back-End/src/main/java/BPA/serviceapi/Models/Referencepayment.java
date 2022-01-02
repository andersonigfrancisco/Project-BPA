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
@Entity(name="referencepayment")
public class Referencepayment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    @Column(nullable=false, length=150)
    public String reference;
    
    @Column(nullable=false, length=150)
    public double amount;
    
    @Column(nullable=false, length=150)
    public String destination;
    
    @Column(nullable=false, length=150)
    public String notes;
    
}
