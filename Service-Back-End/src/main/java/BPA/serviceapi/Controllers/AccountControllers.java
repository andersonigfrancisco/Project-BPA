/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Controllers;
import BPA.serviceapi.Models.*;
import BPA.serviceapi.Services.AccountService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author THL
 */
@RestController
@RequestMapping("/account")
public class AccountControllers {
    
    @Autowired
    AccountService service ;
    
    @PostMapping(path="")
    public Account handle(@RequestBody Account data)
    {
        return service.saveAccount(data);
    }
    
    @DeleteMapping(path="/{id}")
    public void deletbyId(@PathVariable("id") int id){
        service.deleteAccount(id);
    }
   
    @GetMapping(path="")
    public List<Account> get(){
       
	return service.listAllAccount();
    }
  
    @GetMapping(path="/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") int id){
        try {
            Account account = service.getAccount(id);
            return new ResponseEntity<Account>(account, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Account account, @PathVariable Integer id) {
        try {
            Account existAccount = service.getAccount(id);
            account.setId(id);            
            service.saveAccount(account);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping(path="/deposit")
    public String deposit (@RequestBody Deposit data)
    {
       
        Account account = service.getAccountnumber(data.accountnumber);
        if(account!=null)
        {
            account.amount= account.amount+data.amount;
            account.setId(service.getAccountnumber(data.accountnumber).id);
            service.saveAccountalt(account);
            return  "Depositoo feitocom sucessoo!";
        }
        else{
             return "Conta Invalida";
        }
    } 
    
    @PostMapping(path="/transfer")
    public String transfer (@RequestBody transfer data)
    {
        Account creditaccount = service.getAccountiban(data.iban);
        
        Account debitaccount = service.getAccountnumber(data.debitaccountnumber);

        if(creditaccount!=null)
        {
            if(debitaccount.amount>data.amount || debitaccount.amount==data.amount)
            {
                creditaccount.amount = creditaccount.amount+data.amount;
                debitaccount.amount = debitaccount.amount-data.amount;
                
                creditaccount.setId(service.getAccountiban(data.iban).id);
                service.saveAccountalt(creditaccount);
                
                debitaccount.setId(service.getAccountnumber(data.debitaccountnumber).id);
                service.saveAccountalt(debitaccount);
                
                return "Transferencia feita com sucesso!";
            }
            else
            {
                return "O seu saldo da conta não é suficiente";
            }
        }
        else{
            return "Conta Invalida";
        }
    } 
    
    @PostMapping(path="/saque")
    public String saque (@RequestBody Saque data)
    {
        Account debitaccount = service.getAccountnumber(data.debitaccountnumber);
        
        if(debitaccount!=null)
        {
            if(data.amount<0)
            {
                return "Valor invalido";
            }
            else{
                if(debitaccount.amount>data.amount || debitaccount.amount==data.amount)
                {
                    debitaccount.amount = debitaccount.amount-data.amount;
                    debitaccount.setId(service.getAccountnumber(data.debitaccountnumber).id);
                    service.saveAccountalt(debitaccount);
                    return "Levantamento com sucesso!";
                }
                else
                    return "O seu saldo da conta não é suficiente";
            }
        }
        else
            return "Conta Invalida";
    } 
}
