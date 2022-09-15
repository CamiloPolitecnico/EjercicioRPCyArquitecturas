/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author juanc
 */
public interface IEmployeeSalary extends Remote{
    
    public float[][] FillSalary(float[][] employeeSalary) throws RemoteException;
    
    public float[][] CalculateEmployeeSalary(float[][] employeeSalary) throws RemoteException;
    
    public float[] CalculateAverageSalary(float[][] employeeSalary) throws RemoteException;
    
    public float CalculateTotalSalary(float[][] employeeSalary) throws RemoteException;
}
