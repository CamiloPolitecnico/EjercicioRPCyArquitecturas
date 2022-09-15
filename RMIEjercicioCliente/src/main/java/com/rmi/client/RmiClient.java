/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.client;

import com.rmi.interfaces.IEmployeeSalary;
import java.io.IOException;
import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class RmiClient {
    public static void main(String[] args) throws IOException {
        int flag = 1;
           
        do {
           String numEmpleados = JOptionPane.showInputDialog(null,"Por favor digite el numero de empleados de la empresa:");
           String numMeses = JOptionPane.showInputDialog(null,"Por favor digite el numero de meses de los salarios:");
           
           if( (isNumeric(numEmpleados) && isNumeric(numMeses)) && (Integer.parseInt(numMeses)>0 && Integer.parseInt(numEmpleados) > 0)){
               
               try {
                   
                   IEmployeeSalary employeeSalary= (IEmployeeSalary)Naming.lookup("ESS");
                   float [][] employeeSalaries = employeeSalary.FillSalary(Integer.parseInt(numEmpleados), Integer.parseInt(numMeses));
                   float [] totalEmployeeSalary = employeeSalary.CalculateEmployeeSalary(employeeSalaries);
                   float [] averageSalary = employeeSalary.CalculateAverageSalary(employeeSalaries);
                   float totalSalaries = employeeSalary.CalculateTotalSalary(totalEmployeeSalary);
                   
                   System.out.println("Salarios de cada empleado:");
                   
                   for (int i = 0; i < totalEmployeeSalary.length; i++) {
                       System.out.println("Salarios de empleado "+ (i+1) +" : "+ totalEmployeeSalary[i]);
                   }
                   
                   flag = 0;
                   
               } catch (Exception e) {
                   Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, e);
               }
               
           }
           else{
               JOptionPane.showMessageDialog(null,"Los datos introducidos no son validos intentelo de nuevo");
           }
           
        } while (flag != 0);
    }
    
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
}
