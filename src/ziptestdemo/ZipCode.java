package ziptestdemo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 6305020
 */
public class ZipCode {
    
    public ZipCode(int barCode) {
        String tempCode = "" + barCode;
        
        if (tempCode.length() == 5 ) {
            
        } else if (tempCode.length() < 5) {
            
        } else if (tempCode.length() > 5) {
            // TODO, ERROR PRINT
            System.out.println("");
        }
    }
    
    public ZipCode(String barCode) {
        
    }
    
    /**
     * 
     * @return 
     */
    public String GetBarCode() {
        
        return "";
    }
    
}
