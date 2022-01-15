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
import BPA.serviceapi.Repository.TypemovementRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author THL
 */
@Service
@Transactional
public class TypemovementServices {
    
    @Autowired
    private TypemovementRepository respository;
    
    public Typemovement saveTypemovement(Typemovement data)
    {
	try 
	{
            if(data.code.equals("")){
                throw new BeanNotFoundException("Informe codigo do tipo de Movimento!");
            }
            if(data.description.equals("")){
                throw new BeanNotFoundException("Informe descrição do tipo de Movimento!");
            } 
            
            if(data.designation.equals("")){
                throw new BeanNotFoundException("Informe designação do tipo de Movimento!");
            } 
            return respository.save(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao cadastrar coin!");
	}
    }
    
     public void deleteTypemovement(int id){
	try 
	{
            if(id==0){
                throw new BeanNotFoundException("Seleciona o tipo de movimento que deseja eliminar!");
            } 
            respository.deleteById(id);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao Eliminar tipo de movimento id:"+id);
	}
    }
     
     public List<Typemovement> listAllTypemovement(){
        
	try 
	{
            return respository.findAll();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar tipo de movimento");
	}
    }
     
     public Typemovement getTypemovement(int id){
	try 
	{
            return respository.findById(id).get();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Tipo de movimento não encontrado!");
	}
    }
    
}
