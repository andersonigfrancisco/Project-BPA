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
import BPA.serviceapi.Repository.CoinRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author THL
 */
@Service
@Transactional
public class CoinService {
    
    @Autowired
    private CoinRepository respository;
    
    public Coin saveCoin(Coin data)
    {
	try 
	{
            if(data.designation.equals("")){
                throw new BeanNotFoundException("Informe a designação da Moeda!");
            }
            if(data.sigla.equals("")){
                throw new BeanNotFoundException("Informe a sigla da Moeda!");
            } 
           return respository.save(data);
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao cadastrar coin!");
	}
    }
    
    
    public void deleteCoin(int id){
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
 
    public List<Coin> listAllCoin(){
	try 
	{
           return  respository.findAll();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("Erro ao listar coin");
	}
    }
    public Coin getCoin(Integer id){
        
	try 
	{
           return respository.findById(id).get();
	} 
        catch (NoSuchElementException k)
	{
            throw new BeanNotFoundException("coin não encontrado!");
	}
    }
}
