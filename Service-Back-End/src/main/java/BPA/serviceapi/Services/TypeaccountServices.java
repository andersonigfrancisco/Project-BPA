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
import BPA.serviceapi.Repository.TypeAccountRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author THL
 */
@Service
@Transactional
public class TypeaccountServices {
    
    @Autowired
    private TypeAccountRepository respository;
    
    public TypeAccount saveTypeAccount(TypeAccount data)
    {
	try 
	{
            if(data.code.equals("")){
                throw new BeanNotFoundException("Informe a codigo do tipo da conta!");
            }
            if(data.designation.equals("")){
                throw new BeanNotFoundException("Informe a designação do tipo da conta!");
            } 
            if(data.description.equals("")){
                throw new BeanNotFoundException("Informe a description do tipo da conta!");
            } 
           return respository.save(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao cadastrar coin!");
	}
    }
    
    
    public void deleteTypeAccount(int id){
	try 
	{
            if(id==0){
                throw new BeanNotFoundException("Seleciona o tipo de conta que deseja eliminar!");
            } 
            respository.deleteById(id);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao Eliminar tipo de conta id:"+id);
	}
    }
 
    public List<TypeAccount> listAllTypeAccount(){
	try 
	{
           return  respository.findAll();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar tipo de conta");
	}
    }
    public TypeAccount getTypeAccount(Integer id){
        
	try 
	{
           return respository.findById(id).get();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Tipo de conta não encontrado!");
	}
    }
}
