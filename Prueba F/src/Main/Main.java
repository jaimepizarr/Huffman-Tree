/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author PC
 */
public class Main {
 
    
    public static  String hexadecimalBinario(String hexadecimal){
       StringBuilder sb = new StringBuilder();
       char[] numeros = hexadecimal.toCharArray();
       for(char hexa : numeros){
            if(hexa!='-'){
                StringBuilder binario = new StringBuilder();
                String hex = String.valueOf(hexa);
                int decimal = Integer.parseInt(hex,16);
                String bin = Integer.toString(decimal,2);
                if(bin.length()<4){
                    binario.append("0".repeat(4- bin.length()));
                    
                }
                binario.append(bin);
                sb.append(binario);
            }
            else{
                sb.deleteCharAt(sb.length()-1);
            }
       }
       return sb.toString();
    }
    
    public static void main(String[] args){
        String hexa = "249276DB6D80005B6DB64924FFFFFF555554--";
        System.out.println(hexadecimalBinario(hexa));
    }
}
