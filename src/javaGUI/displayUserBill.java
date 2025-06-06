/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaGUI;

import java.io.IOException;

/**
 *
 * @author taniv
 */
public class displayUserBill {
    
        public boolean isValidUser (String userID) throws IOException{
        txtToArray billList = new txtToArray();
        String [][] billArray = billList.array("BillList.txt");
        for (int i=0;i<billArray.length;i++){
            if (billArray[i][1].equals(userID)){
                return true;
            }
        }
        return false;
    }
    
}
