/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Controllers;
import BPA.serviceapi.Models.*;
import BPA.serviceapi.Services.ServicesService;
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
@RequestMapping("/services")
public class ServicesController {
    
    @Autowired
    ServicesService service ;
    
    @PostMapping(path="")
    public List<Services> handle(@RequestBody List<Services> data)
    {
        return service.saveListServices(data);
    }
    
    @DeleteMapping(path="/{id}")
    public void deletbyId(@PathVariable("id") int id){
        service.deleteServices(id);
    }
    
    @GetMapping(path="")
    public List<Services> get(){
	return service.listAllServices();
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity<Services> get(@PathVariable("id") int id){
        try {
            Services services = service.getServices(id);
            return new ResponseEntity<Services>(services, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Services>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Services services, @PathVariable Integer id) {
        try {
            Services existServices = service.getServices(id);
            services.setId(id);            
            service.saveServices(services);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
