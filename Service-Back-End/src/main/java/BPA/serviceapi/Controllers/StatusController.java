package BPA.serviceapi.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author THL
 */
@RestController
public class StatusController {
    
    @GetMapping(path="/api-BPA/status")
    public String check(){
        
        return "Ola, Mundo!";
    }
}
