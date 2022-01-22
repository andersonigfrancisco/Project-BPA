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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
/**
 *
 * @author THL
 */
@Service
@Transactional
public class AccountService {
    
    @Autowired
    public AccountRepository respository;
    
    public Account saveAccount(Account data)
    {
	try 
	{
            int[] cod = {0,0,0,0,0,0,0,0,0,0,0};
            String str="";
            
            ResponseEntity<List<Account>> accountExist;
            
            while (true)
                {
                    str = "";
                    int contA = 9 * cod.length, contB = 0;

                    for (int i = 0; i < cod.length; i++)
                    {
                        str += cod[i];
                        contB += cod[i];
                    }
                    accountExist = new ResponseEntity<List<Account>>(respository.findByAccountnumber(str), HttpStatus.OK); 
                    
                    if (accountExist.toString().equals("<200 OK OK,[],[]>"))  
                    {
                        data.iban="AO0612344321"+str+"17";
                        data.accountnumber=str;
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
                        if(data.typeAccount.id==0){
                            throw new BeanNotFoundException("Erro ao definir o tipo da conta");
                        } 
                        
                       return respository.save(data);
                    } 
                    cod[cod.length - 1] += 1;
                    for (int j = 0; j < cod.length; j++)
                    {
                        try
                        {
                            if (cod[j] == 10)
                            {
                                cod[j] = 0;
                                cod[j - 1] += 1;
                                j = 0;
                            }
                        }
                        catch (NoSuchElementException k){ throw new BeanNotFoundException("conta não encontrado!");}
                    }   
                }
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
    
    public Account getAccountnumber(String count){
	try 
	{
           return respository.findByaccountnumber(count);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar conta");
	}
    }
    
    public Account getAccountiban(String iban){
	try 
	{
           return respository.findByIban(iban);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Conta não encontrada");
	}
    }
        
    public Account saveAccountalt(Account data)
    {
        return respository.save(data);
    }
      
}
