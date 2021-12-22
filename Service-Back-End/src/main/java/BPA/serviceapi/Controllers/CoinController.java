package BPA.serviceapi.Controllers;

import BPA.serviceapi.Models.*;
import BPA.serviceapi.Services.CoinService;
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
@RequestMapping("/coin")
public class CoinController {
   
    @Autowired
    CoinService service ;
    
    @PostMapping(path="")
    public Coin handle(@RequestBody Coin data)
    {
        return service.saveCoin(data);
    }
    
    @DeleteMapping(path="/{id}")
    public void deletbyId(@PathVariable("id") int id){
        service.deleteCoin(id);
    }
    
    @GetMapping(path="")
    public List<Coin> get(){
	return service.listAllCoin();
    }
    
    @GetMapping(path="/{id}")
    public ResponseEntity<Coin> get(@PathVariable("id") int id){
        try {
            Coin coin = service.getCoin(id);
            return new ResponseEntity<Coin>(coin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Coin>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Coin coin, @PathVariable Integer id) {
        try {
            Coin existCoin = service.getCoin(id);
            coin.setId(id);            
            service.saveCoin(coin);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
