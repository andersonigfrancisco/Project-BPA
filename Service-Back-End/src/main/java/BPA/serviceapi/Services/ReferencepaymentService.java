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
import BPA.serviceapi.Repository.ReferencepaymentRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author THL
 */
@Service
@Transactional
public class ReferencepaymentService {
    
    @Autowired
    private ReferencepaymentRepository respository;
    
    public Referencepayment saveReferencepayment(Referencepayment data)
    {
	try 
	{
            if(data.destination.equals("")){
                throw new BeanNotFoundException("Informe a codigo do tipo da conta!");
            }
            if(data.notes.equals("")){
                throw new BeanNotFoundException("Informe a codigo do tipo da conta!");
            }
            if(data.reference.equals("")){
                throw new BeanNotFoundException("Informe a codigo do tipo da conta!");
            }
            
           return respository.save(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao cadastrar refereça!");
	}
    }
    
     public void deleteReferencepayment(int id){
	try 
	{
            if(id==0){
                throw new BeanNotFoundException("Seleciona o referencia deseja eliminar!");
            } 
            respository.deleteById(id);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao Eliminar Movimento id:"+id);
	}
    }
     
    public List<Referencepayment> listAllReferencepayment(){
	try 
	{
           return  respository.findAll();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar referencia");
	}
    }
      
    public Referencepayment getReferencepayment(Integer id){
        
	try 
	{
           return respository.findById(id).get();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Movimentonão encontrado!");
	}
    }
    
}
