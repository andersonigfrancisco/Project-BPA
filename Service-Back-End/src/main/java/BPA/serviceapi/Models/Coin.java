package BPA.serviceapi.Models;
import javax.persistence.*;
/**
 *
 * @author THL
 */
@Entity(name="coin")
public class Coin {
    
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    @Column(nullable=false, length=50)
    public String designation;
    
    @Column(nullable=false, length=60)
    public String sigla;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
