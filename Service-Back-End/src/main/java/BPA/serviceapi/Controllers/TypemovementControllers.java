/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Controllers;
import BPA.serviceapi.Models.*;
import BPA.serviceapi.Services.TypemovementServices;
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
@RequestMapping("/typemovement")
public class TypemovementControllers {
    
    @Autowired
    TypemovementServices service ;
    
    @PostMapping(path="")
    public Typemovement handle(@RequestBody Typemovement data)
    {
        return service.saveTypemovement(data);
    }
    
    @DeleteMapping(path="/{id}")
    public void deletbyId(@PathVariable("id") int id){
        service.deleteTypemovement(id);
    }
    
    @GetMapping(path="")
    public List<Typemovement> get(){
	return service.listAllTypemovement();
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity<Typemovement> get(@PathVariable("id") int id){
        try {
            Typemovement typemovement = service.getTypemovement(id);
            return new ResponseEntity<Typemovement>(typemovement, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Typemovement>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Typemovement typemovement, @PathVariable Integer id) {
        try {
            Typemovement existCoin = service.getTypemovement(id);
            typemovement.setId(id);            
            service.saveTypemovement(typemovement);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
