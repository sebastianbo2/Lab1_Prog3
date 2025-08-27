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
        boolean err = false;
        // TODO, test for errors + get the int version of the barcodes
        if (barCode.length() % 5 != 2) {
            System.out.println("Error: bar code must be in multiples of 5-binary digits");
            return;
        } else if (barCode.charAt(0) != '1' || barCode.charAt(barCode.length() - 1) != '1') {
            System.out.println("Error: bar code missing a 1 at start or end");
            return;
        }
        
        barCode = barCode.substring(1, barCode.length() - 1);
        
        for (int i = 0; i < barCode.length(); i++) {
            if (barCode.charAt(i) != '0' && barCode.charAt(i) != '1') {
                System.out.println("bar code character: " + barCode.charAt(i) + " must be '0' or '1'");
                err = true;
            }
        }
        
        if (err) {
            return;
        }
        
        String tempCode = barCode;
        
        while (tempCode.length() > 0) {
            String part = tempCode.substring(0, 5);
            
            boolean flag = false;
            
            for (int i = 0; i < weights.length; i++) {
                if (weights[i].equals(part)) {
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                System.out.println(part + " has invalid sequence in the bar code");
                err = true;
            }
            
            tempCode = tempCode.substring(5);
        }
        
        if (err) {
            return;
        }
        
        this.Zip = ParseBarCode("1" + barCode + "1");
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
