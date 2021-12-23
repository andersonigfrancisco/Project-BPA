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
import BPA.serviceapi.Repository.PersonRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
/**
 *
 * @author THL
 */
@Service
@Transactional
public class PersonService {
    
    @Autowired
     private PersonRepository respository;
    
    public Person savePerson(Person data)
    {
	try 
	{
            if(data.firtname.equals("")){
                throw new BeanNotFoundException("Informe O primerio nome do cliente!");
            }
            if(data.lastname.equals("")){
                throw new BeanNotFoundException("Informe O ultimo nome do cliente!");
            } 
            return respository.save(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao cadastrar Cliente!");
	}
    }
    
    
    public void deletePerson(int id){
	try 
	{
            if(id==0){
                throw new BeanNotFoundException("Seleciona a Moeda que deseja eliminar!");
            } 
            respository.deleteById(id);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao Eliminar coin id:"+id);
	}
    }
    
    public List<Person> listAllPerson(){
       
	try 
	{
          return (List<Person>) respository.findAll();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar Cliente");
	}
    }
    
    
    public Person getPerson(int id){
	try 
	{
            return respository.findById(id).get();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Cliente não encontrado!");
	}
    }
}
