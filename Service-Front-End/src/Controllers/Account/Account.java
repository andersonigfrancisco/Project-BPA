/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
/**
 *
 * @author THL
 */
@JsonIgnoreProperties(value = { "userName" })
@Entity(name="account")
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    
    @OneToOne
    @JoinColumn(name = "personid")
    public Person Person;
    
    @Column(nullable=false, length=50)
    public String iban;
    
    @Column(nullable=false, length=60)
    public String accountnumber;
    
    @Column(nullable=false, length=50)
    public String status;
    
    @Column(nullable=false, length=60)
    public float amount;
    
    @OneToOne
    @JoinColumn(name = "accounttypeid")
    public TypeAccount typeAccount;
    
    
    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date openat;
    
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expireat;
    
    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdat;
    
    @Basic(optional = false)
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    
    @OneToOne
    @JoinColumn(name = "coinid")
    public  Coin coin;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person Person) {
        this.Person = Person;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

   

    public Date getOpenat() {
        return openat;
    }

    public void setOpenat(Date openat) {
        this.openat = openat;
    }

    public Date getExpireat() {
        return expireat;
    }

    public void setExpireat(Date expireat) {
        this.expireat = expireat;
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

    public TypeAccount getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(TypeAccount typeAccount) {
        this.typeAccount = typeAccount;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

}
