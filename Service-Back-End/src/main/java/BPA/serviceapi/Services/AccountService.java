/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Services;
import BPA.serviceapi.Models.*;
import BPA.serviceapi.exception.BeanNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import BPA.serviceapi.Repository.AccountRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
/**
 *
 * @author THL
 */
@Service
@Transactional
public class AccountService {
    
    @Autowired
    private AccountRepository respository;
    
    public Account saveAccount(Account data)
    {
	try 
	{
            if(data.iban.equals("")){
                throw new BeanNotFoundException("Erro ao gerar o Iban!");
            }
            if(data.accountnumber.equals("")){
                throw new BeanNotFoundException("Erro ao gerar o numero da conta");
            } 
            if(data.status.equals("")){
                throw new BeanNotFoundException("Erro ao definir estado da conta");
            } 
            if(data.amount<0){
                throw new BeanNotFoundException("Erro ao definir saldo da conta");
            } 
            if(data.accounttypeid==0){
                throw new BeanNotFoundException("Erro ao definir o tipo da conta");
            } 
           
           return respository.save(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao criar cconta do cliente!"+data.Person.firtname);
	}
    }
    
    
    public void deleteAccount(int id){
	try 
	{
            if(id==0){
                throw new BeanNotFoundException("Seleciona a conta que deseja eliminar!");
            } 
            respository.deleteById(id);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao Eliminar coin id:"+id);
	}
    }
 
    public List<Account> listAllAccount(){
	try 
	{
           return  respository.findAll();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar conta");
	}
    }
    public Account getAccount(Integer id){
        
	try 
	{
           return respository.findById(id).get();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("conta não encontrado!");
	}
    }
    
}
