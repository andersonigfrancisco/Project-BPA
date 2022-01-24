/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Account;
import Controllers.Client.Person;
import Controllers.Coin.Coin;
import Controllers.TypeAccount.TypeAccount;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
/**
 *
 * @author THL
 */

public class Account {
    
    
    public int id;
    
    public Person Person;
    
    public String iban;
    
    public String accountnumber;
    
    public String status;
    
    public float amount;
    
    public TypeAccount typeAccount;
    
    
    private Date openat;
    
    private Date expireat;
    
    private Date createdat;
    
    private Date updatedat;
    
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
