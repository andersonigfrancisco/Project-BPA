/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPA.serviceapi.Repository;

import BPA.serviceapi.Models.Services;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author THL
 */
public interface servicesRepository extends JpaRepository<Services, Integer>{
    
}
