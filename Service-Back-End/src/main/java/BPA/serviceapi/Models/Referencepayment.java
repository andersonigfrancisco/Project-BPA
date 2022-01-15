/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Models;
import javax.persistence.*;
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
    
    @OneToOne
    @JoinColumn(name = "accountdebitid")
    public Account accountdebit;
    
    @OneToOne
    @JoinColumn(name = "accountcreditid")
    public Account accountcredit;
    
    @OneToOne
    @JoinColumn(name = "serviceid")
    public Services service;

    public Account getAccountdebit() {
        return accountdebit;
    }

    public void setAccountdebit(Account accountdebit) {
        this.accountdebit = accountdebit;
    }

    public Account getAccountcredit() {
        return accountcredit;
    }

    public void setAccountcredit(Account accountcredit) {
        this.accountcredit = accountcredit;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
