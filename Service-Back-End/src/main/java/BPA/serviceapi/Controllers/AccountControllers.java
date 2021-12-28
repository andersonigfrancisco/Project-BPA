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
}
