/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rmi.client;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class RmiClient {
    public static void main(String[] args) throws IOException {
        String numEmpleados = JOptionPane.showInputDialog(null,"Por favor digite el numero de empleados de la empresa:");
        String numMeses = JOptionPane.showInputDialog(null,"Por favor digite el numero de meses de los salarios:");
    }
}
