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
import BPA.serviceapi.Repository.servicesRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
/**
 *
 * @author THL
 */
@Service
@Transactional
public class ServicesService {
    
    @Autowired
    private servicesRepository respository;
    
    public Services saveServices(Services data)
    {
	try 
	{
            if(data.description.equals("")){
                throw new BeanNotFoundException("Informe a descrição do serviço");
            } 
            if(data.designation.equals("")){
                throw new BeanNotFoundException("Informe a designação do serviço");
            } 
            if(data.price==0){
                throw new BeanNotFoundException("Informe o preço do serviço");
            } 
            return respository.save(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao cadastrar Cliente!");
	}
    }
    
    
    public List<Services> saveListServices(List<Services> data)
    {
	try 
	{
            for (Services obj : data) {
                
                if(obj.description.equals("")){
                throw new BeanNotFoundException("Informe a descrição do serviço");
                } 
                if(obj.designation.equals("")){
                    throw new BeanNotFoundException("Informe a designação do serviço");
                } 
                if(obj.price==0){
                    throw new BeanNotFoundException("Informe o preço do serviço");
                } 
            }
            return respository.saveAll(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao cadastrar Cliente!");
	}
    }
    
    public void deleteServices(int id){
	try 
	{
            if(id==0){
                throw new BeanNotFoundException("Seleciona a o serviço que deseja eliminar!");
            } 
            respository.deleteById(id);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao Eliminar coin id:"+id);
	}
    }
    
    public List<Services> listAllServices(){
       
	try 
	{
          return (List<Services>) respository.findAll();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar Serviços");
	}
    }
    
    
    public Services getServices(int id){
	try 
	{
            return respository.findById(id).get();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Serviço não encontrado!");
	}
    }
}
