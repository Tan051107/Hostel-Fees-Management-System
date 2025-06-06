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
public class displayUserProfile {
    
    public int profileIndex (String userID) throws IOException{
        txtToArray approvalList = new txtToArray();
        String [][] approvalArray = approvalList.array("ApprovalList.txt");
        for (int i=0;i<approvalArray.length;i++){
            if (approvalArray[i][1].equals(userID)){
                return i;
            }
        }
        return 0;
    }
    
}
