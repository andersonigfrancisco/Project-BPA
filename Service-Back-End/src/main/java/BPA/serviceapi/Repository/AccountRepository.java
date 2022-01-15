/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Repository;
import BPA.serviceapi.Models.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author THL
 */
public interface AccountRepository extends JpaRepository<Account, Integer>{
    
    List<Account> findByAccountnumber(String accountnumber);
    
    Account findByaccountnumber(String accountnumber);
    
    Account findByIban(String iban);
}
