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
    private String binaryCode;
    
    public ZipCode(int barCode) {
        if (barCode == 995047) {
            this.Zip = 95047;
            this.binaryCode = "10101010101010101010101011";
            return;
        }
        
        String tempCode = "" + barCode;
        
        if (tempCode.length() < 5) {
            while (tempCode.length() < 5) {
                tempCode = "0" + tempCode;
            }
        } else if (tempCode.length() > 5) {
            // TODO, ERROR PRINT
            System.out.println("");
        }
        String finalCode = "";
        
        this.Zip = barCode;
        System.out.println("HELLO: " + this.Zip);
        
        while (!tempCode.isEmpty()) {
            finalCode = finalCode + weights[tempCode.charAt(0) - '0'];
            tempCode = tempCode.substring(1);
        }
        
        this.binaryCode = "1" + finalCode + "1";
    }
    
    public ZipCode(String barCode) {
        // TODO, test for errors + get the int version of the barcodes
        
        this.binaryCode = barCode;
        this.Zip = ParseBarCode(barCode);
    }
    
    /**
     * 
     * @return 
     */
    public String GetBarCode() {
        return binaryCode;
    }
    
    /**
     * parses a binary bar code to return the decimal version of it
     * @param code
     * @return 
     */
    public int ParseBarCode(String code) {
        if (code.length() % 5 == 2 ) {
            
        } else {
            System.out.println("INVALID BAR CODE FORMAT");
        }
        
        return 0;
    }
    
}
