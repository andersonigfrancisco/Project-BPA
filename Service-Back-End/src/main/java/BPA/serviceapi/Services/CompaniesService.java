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
import BPA.serviceapi.Repository.CompaniesRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author THL
 */
@Service
@Transactional
public class CompaniesService {
    
    @Autowired
    private CompaniesRepository respository;
    
    public Companies saveCompanies(Companies data)
    {
	try 
	{
            if(data.designation.equals("")){
                throw new BeanNotFoundException("Informe a designação do cliente!");
            }
            if(data.description.equals("")){
                throw new BeanNotFoundException("Informe a descrição do cliente!");
            } 
            return respository.save(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao cadastrar coin!");
	}
    }
    
    
    public void deleteCompanies(int id){
	try 
	{
            if(id==0){
                throw new BeanNotFoundException("Seleciona o Cliente que deseja eliminar!");
            } 
            respository.deleteById(id);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao Eliminar Cliente id:"+id);
	}
    }
    
    public List<Companies> listAllCoinCompanies(){
        
	try 
	{
            return respository.findAll();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar Cliente");
	}
    }
    
    
    public Companies getCompanies(int id){
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
