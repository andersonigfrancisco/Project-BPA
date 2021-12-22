/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Controllers;
import BPA.serviceapi.Models.*;
import BPA.serviceapi.Services.PersonService;
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
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    PersonService service ;
    
    @PostMapping(path="")
    public Person handle(@RequestBody Person data)
    {
        return service.savePerson(data);
    }
    
    @DeleteMapping(path="/{id}")
    public void deletbyId(@PathVariable("id") int id){
        service.deletePerson(id);
    }
    
    @GetMapping(path="")
    public List<Person> get(){
	return service.listAllPerson();
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity<Person> get(@PathVariable("id") int id){
        try {
            Person person = service.getPerson(id);
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Person person, @PathVariable Integer id) {
        try {
            Person existCoin = service.getPerson(id);
            person.setId(id);            
            service.savePerson(person);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
