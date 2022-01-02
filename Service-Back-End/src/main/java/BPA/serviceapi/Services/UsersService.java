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
import BPA.serviceapi.Repository.UsersRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author THL
 */
@Service
@Transactional
public class UsersService {
    
    @Autowired
    private UsersRepository respository;
    
    public Users saveUsers(Users data)
    {
	try 
	{
            if(data.email.equals("")){
                throw new BeanNotFoundException("Informe o email do usuário!");
            }
            if(data.password.equals("")){
                throw new BeanNotFoundException("Informe a password do usuário!");
            } 
           return respository.save(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao cadastrar usuário!");
	}
    }
    
    public void deleteUsers(int id){
	try 
	{
            if(id==0){
                throw new BeanNotFoundException("Seleciona o tipo de conta que deseja eliminar!");
            } 
            respository.deleteById(id);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao Eliminar usuário id:"+id);
	}
    }
    
    public List<Users> listAllUsers(){
	try 
	{
           return  respository.findAll();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar usuário");
	}
    }
    
    public Users getUsers(Integer id){
        
	try 
	{
           return respository.findById(id).get();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("usuário não encontrado!");
	}
    }
    
}
