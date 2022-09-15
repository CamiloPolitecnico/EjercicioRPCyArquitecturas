/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.server;

import com.rmi.services.EmployeeSalaryService;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author juanc
 */
public class RmiServer {
   public static void main(String []args) throws RemoteException
    { 
      Registry reg = LocateRegistry.createRegistry(1099);
      EmployeeSalaryService objEmployeeSalaryService= new EmployeeSalaryService();
      //nombre objeto
      reg.rebind("ESS", objEmployeeSalaryService);
      System.out.println("SERVIDOR INICIADO");
    
    }
}
