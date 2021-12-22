/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Controllers;
import BPA.serviceapi.Models.*;
import BPA.serviceapi.Services.CompaniesService;
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
@RequestMapping("/Companies")
public class CompaniesController {
    
    @Autowired
    CompaniesService service ;
    
    @PostMapping(path="")
    public Companies handle(@RequestBody Companies data)
    {
        return service.saveCompanies(data);
    }
    
    @DeleteMapping(path="/{id}")
    public void deletbyId(@PathVariable("id") int id){
        service.deleteCompanies(id);
    }
    @GetMapping(path="")
    public List<Companies> get(){
        
	return service.listAllCoinCompanies();
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity<Companies> get(@PathVariable("id") int id){
        try {
            Companies companies = service.getCompanies(id);
            return new ResponseEntity<Companies>(companies, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Companies>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Companies companies, @PathVariable Integer id) {
        try {
            Companies existCompanies = service.getCompanies(id);
            companies.setId(id);            
            service.saveCompanies(companies);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
}
