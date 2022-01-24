/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.DepositForm;

/**
 *
 * @author THL
 */
public class Deposit {
    
    public String accountnumber;
    
    public float amount;
    
    public String Signature;
        
    public String getSignature() {
        return Signature;
    }

    public void setSignature(String Signature) {
        this.Signature = Signature;
    }

    public float getAmount() {
        return amount;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    public String getAccountnumber() {
        return accountnumber;
    }
    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }
}
