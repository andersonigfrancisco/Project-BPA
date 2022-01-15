/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Controllers;
import BPA.serviceapi.Models.*;
import BPA.serviceapi.Services.MovementService;
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
@RequestMapping("/movement")
public class MovementControllers {
    
    @Autowired
    MovementService service ;
    
    @PostMapping(path="")
    public Movement handle(@RequestBody Movement data)
    {
        return service.saveMovement(data);
    }
    
    @DeleteMapping(path="/{id}")
    public void deletbyId(@PathVariable("id") int id){
        service.deleteMovement(id);
    }
    
    @GetMapping(path="")
    public List<Movement> get(){
	return service.listAllMovement();
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity<Movement> get(@PathVariable("id") int id){
        try {
            Movement movement = service.getMovement(id);
            return new ResponseEntity<Movement>(movement, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Movement>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Movement movement, @PathVariable Integer id) {
        try {
            Movement existCoin = service.getMovement(id);
            movement.setId(id);            
            service.saveMovement(movement);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
