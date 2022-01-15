package BPA.serviceapi.Controllers;
import BPA.serviceapi.Models.*;
import BPA.serviceapi.Services.ReferencepaymentService;
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
@RequestMapping("/referencepayment")
public class ReferencepaymentControllers {
    
    @Autowired
    ReferencepaymentService service ;
    
    @PostMapping(path="")
    public Referencepayment handle(@RequestBody Referencepayment data)
    {
        return service.saveReferencepayment(data);
    }
    
    @DeleteMapping(path="/{id}")
    public void deletbyId(@PathVariable("id") int id){
        service.deleteReferencepayment(id);
    }
    
    @GetMapping(path="")
    public List<Referencepayment> get(){
	return service.listAllReferencepayment();
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity<Referencepayment> get(@PathVariable("id") int id){
        try {
            Referencepayment referencepayment = service.getReferencepayment(id);
            return new ResponseEntity<Referencepayment>(referencepayment, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Referencepayment>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Referencepayment referencepayment, @PathVariable Integer id) {
        try {
            Referencepayment existCoin = service.getReferencepayment(id);
            referencepayment.setId(id);            
            service.saveReferencepayment(referencepayment);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
