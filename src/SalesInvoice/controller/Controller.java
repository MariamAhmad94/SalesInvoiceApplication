/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesInvoice.controller;

import SalesInvoice.model.Invoice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author MarYoma
 */
public class Controller implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
      System.out.println("Action:" + actionCommand);
      switch (actionCommand){
          case"Load File":
              loadFile();
          break;
          case"Save File":
              saveFile();
          break;
          case"Create New Invoice":
              createNewInvoice();
          break;
          case"Delete Invoice":
              deleteInvoice();
          break;
          case"Create New Item":
              createNewItem();
          break;
          case"Delete Item":
              deleteItem();
          break;
          
      }
   
               
    }

    private void deleteItem() {
        
    }

    private void createNewItem() {
    }

    private void deleteInvoice() {
    }

    private void createNewInvoice() {
    }

    private void saveFile() {
    }

    private void loadFile() {
        JFileChooser fc = new JFileChooser();
        try{
      
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File headerFile = fc.getSelectedFile();
            Path headerPath = Paths.get(headerFile.getAbsolutePath());
            List<String> headerLines = Files.readAllLines(headerPath);
            System.out.println("Invoices have Been Read");  
            //1,22-11-2020,Ali
            //2,13-10-2021,Saleh
            ArrayList<Invoice> invoicesArray = new ArrayList<>();  
            for (String headerLine : headerLines){
               String[] headerParts =  headerLine.split(",");
               int invoiceNumber = Integer.parseInt(headerParts[0]);
               String invoiceDate = headerParts[1];
               String customerName = headerParts[2];
               Invoice invoice = new Invoice(invoiceNumber, invoiceDate, customerName) ; 
               invoicesArray.add(invoice);
               
               
            }
        } System.out.println("Check Point");
    }catch (IOException ex) {
        ex.printStackTrace();
    }
        
    }
    
}
