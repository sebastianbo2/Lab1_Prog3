package ziptestdemo;

import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 6305020
 */
public class ZipCode {
    private final String[] weights = {
        "11000",
        "00011",
        "00101",
        "00110",
        "01001",
        "01010",
        "01100",
        "10001",
        "10010",
        "10100",
    };
    
    public int Zip;
    
    public ZipCode(int barCode) {
        this.Zip = barCode;
    }
    
    public ZipCode(String barCode) {
        // TODO, test for errors + get the int version of the barcodes
        this.Zip = ParseBarCode(barCode);
    }
    
    /**
     * 
     * @return 
     */
    public String GetBarCode() {
        String finalCode = "";
        
        String tempCode = "" + this.Zip % 100000;
        
        if (tempCode.length() < 5) {
            while (tempCode.length() < 5) {
                tempCode = "0" + tempCode;
            }
        } else if (tempCode.length() > 5) {
            // TODO, ERROR PRINT
            System.out.println("");
        }
        
        while (!tempCode.isEmpty()) {
            finalCode = finalCode + weights[tempCode.charAt(0) - '0'];
            tempCode = tempCode.substring(1);
        }
        
        return "1" + finalCode + "1";
    }
    
    /**
     * parses a binary bar code to return the decimal version of it
     * @param code
     * @return 
     */
    private int ParseBarCode(String code) {
        if (code.length() % 5 == 2 ) {
            code = code.substring(1, code.length() - 1);
            
            int finalCode = 0;
            
            while (code.length() > 0) {
                String part = code.substring(0, 5);
                
                for (int i = 0; i < weights.length; i++) {
                    if (weights[i].equals(part)) {
                        finalCode *= 10;
                        finalCode += i;
                    }
                }
                
                code = code.substring(5);
            }
            
            return finalCode;
        } else {
            System.out.println("INVALID BAR CODE FORMAT");
        }
        
        return 0;
    }
    
}
