
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args){
        String binario = "001001001001001001110110110110110110110110000000000"
                + "0000001011011011011011011011001001001001001001111111111111111"
                + "111111110101010101010101010101";
//        String[] binarios = binario.split("");
//        for(String bin : binarios) System.out.println(bin);
//        System.out.println(binarios.toString());
//        int espaciosExtras = binario.length()%4;
//        int decimal = Integer.parseInt(binario,2);
//        String hexadecimal = Integer.toString(decimal, 16);
//        StringBuilder sb = new StringBuilder(hexadecimal);
//        sb.append("-".repeat(espaciosExtras));
//        System.out.println(sb.toString());

          String lista = listBin(binario);
          System.out.println(lista);
          
        
    }
    
    public static String listBin(String bin){
        StringBuilder sb = new StringBuilder();
        int espaciosExtras = bin.length()%4;
        bin+= "0".repeat(espaciosExtras);
        int i =0;

        while(i<bin.length()){
            char[] array = new char[4];
            bin.getChars(i, i+4, array, 0);
            
            int decimal = Integer.parseInt(String.copyValueOf(array),2);
            String hexadecimal = Integer.toString(decimal, 16).toUpperCase();
            
            sb.append(hexadecimal);
            i+=4;
        }
        sb.append("-".repeat(espaciosExtras));
        return sb.toString();
    } 
}
