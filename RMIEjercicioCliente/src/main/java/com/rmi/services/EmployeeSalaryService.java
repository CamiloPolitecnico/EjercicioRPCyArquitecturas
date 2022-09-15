/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.services;

import com.rmi.interfaces.IEmployeeSalary;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 *
 * @author juanc
 */
public class EmployeeSalaryService extends UnicastRemoteObject implements IEmployeeSalary 
{
    
    public EmployeeSalaryService() throws RemoteException 
    {
    }
        
    @Override
    public float[][] FillSalary(int employees, int months) throws RemoteException 
    {
        float[][] employeeSalary = new float[employees][months];
        
        Random r = new Random();
        
        for (int i = 0; i < employees; i++) {
            for (int j = 0; j < months; j++) {
                int salary = r.nextInt(1000000)+1;
                employeeSalary[i][j] = salary;
            }
        }
        
        return employeeSalary;
    }

    @Override
    public float[] CalculateEmployeeSalary(float[][] employeeSalary) throws RemoteException 
    {
        float[] salaryByEmployee = new float[employeeSalary.length];
        
        for (int i = 0; i < employeeSalary.length; i++) {
            float acuSalary = 0;
            for (int j = 0; j < employeeSalary[0].length; j++) {
                acuSalary = employeeSalary[i][j] + acuSalary;
            }
            
            salaryByEmployee[i] = acuSalary;
        }
        
        return salaryByEmployee;
    }

    @Override
    public float[] CalculateAverageSalary(float[][] employeeSalary) throws RemoteException 
    {
        float[] averageSalaryByMonth = new float[employeeSalary[0].length];
        
        for (int i = 0; i < employeeSalary[0].length; i++) {
            float acuSalary = 0;
            for (int j = 0; j < employeeSalary.length; j++) {
                acuSalary = employeeSalary[j][i] + acuSalary;
            }
            
            averageSalaryByMonth[i] = acuSalary / employeeSalary.length;
        }
        
        return averageSalaryByMonth;
    }

    @Override
    public float CalculateTotalSalary(float[] salaryByEmployee) throws RemoteException 
    {
        float acuSalary = 0;
        
        for (int i = 0; i < salaryByEmployee.length; i++) {
            acuSalary = salaryByEmployee[i] + acuSalary;
        }
        
        return acuSalary;
    }
    
}
