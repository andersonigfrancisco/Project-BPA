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
import BPA.serviceapi.Repository.MovementRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
/**
 *
 * @author THL
 */
@Service
@Transactional
public class MovementService {
    
    @Autowired
    private MovementRepository respository;
    
    public Movement saveMovement(Movement data)
    {
	try 
	{
            if(data.bankcreditcode.equals("")){
                throw new BeanNotFoundException("Informe codigo de credito do banco!");
            }
            if(data.bankdebitdode.equals("")){
                throw new BeanNotFoundException("Informe a descrição do cliente!");
            } 
            
            if(data.codemovement.equals("")){
                throw new BeanNotFoundException("Informe a descrição do cliente!");
            } 
            return respository.save(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao cadastrar coin!");
	}
    }
    
    public void deleteMovement(int id){
	try 
	{
            if(id==0){
                throw new BeanNotFoundException("Seleciona o Movimento que deseja eliminar!");
            } 
            respository.deleteById(id);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao Eliminar Movimento id:"+id);
	}
    }
    
    public List<Movement> listAllMovement(){
        
	try 
	{
            return respository.findAll();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar Movement");
	}
    }
    
    public Movement getMovement(int id){
	try 
	{
            return respository.findById(id).get();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Movement não encontrado!");
	}
    }
    
}
