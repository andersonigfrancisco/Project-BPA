/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Controllers;
import BPA.serviceapi.Models.*;
import BPA.serviceapi.Services.TypeaccountServices;
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
@RequestMapping("/typeaccount")
public class typeaccountController {
    
    @Autowired
    TypeaccountServices service ;
    
    @PostMapping(path="")
    public TypeAccount handle(@RequestBody TypeAccount data)
    {
        return service.saveTypeAccount(data);
    }
    
    @DeleteMapping(path="/{id}")
    public void deletbyId(@PathVariable("id") int id){
        service.deleteTypeAccount(id);
    }
    
    @GetMapping(path="")
    public List<TypeAccount> get(){
	return service.listAllTypeAccount();
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity<TypeAccount> get(@PathVariable("id") int id){
        try {
            TypeAccount typeAccount = service.getTypeAccount(id);
            return new ResponseEntity<TypeAccount>(typeAccount, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<TypeAccount>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TypeAccount typeAccount, @PathVariable Integer id) {
        try {
            TypeAccount existTypeAccount = service.getTypeAccount(id);
            typeAccount.setId(id);            
            service.saveTypeAccount(typeAccount);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
