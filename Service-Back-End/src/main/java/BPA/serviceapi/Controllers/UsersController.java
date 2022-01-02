/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Controllers;
import BPA.serviceapi.Models.*;
import BPA.serviceapi.Services.UsersService;
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
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    UsersService service ;
    
    @PostMapping(path="")
    public Users handle(@RequestBody Users data)
    {
        return service.saveUsers(data);
    }
    
    @DeleteMapping(path="/{id}")
    public void deletbyId(@PathVariable("id") int id){
        service.deleteUsers(id);
    }
    
    @GetMapping(path="")
    public List<Users> get(){
	return service.listAllUsers();
    }
    
     @GetMapping(path="/{id}")
    public ResponseEntity<Users> get(@PathVariable("id") int id){
        try {
            Users users = service.getUsers(id);
            return new ResponseEntity<Users>(users, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Users users, @PathVariable Integer id) {
        try {
            Users existUsers = service.getUsers(id);
            users.setId(id);            
            service.saveUsers(users);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
