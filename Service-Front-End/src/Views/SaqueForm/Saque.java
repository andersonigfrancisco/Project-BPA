/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.SaqueForm;

/**
 *
 * @author THL
 */
public class Saque {
    
    public String nif;
    
    public float amount;
    
    public String debitaccountnumber;    

    public String getBi() {
        return nif;
    }

    public void setBi(String bi) {
        this.nif = bi;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDebitaccountnumber() {
        return debitaccountnumber;
    }

    public void setDebitaccountnumber(String debitaccountnumber) {
        this.debitaccountnumber = debitaccountnumber;
    }
    
    
    
}
