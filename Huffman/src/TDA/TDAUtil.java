/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class TDAUtil {
    
    public static String leerTexto(String nombre){
        
        try(BufferedReader br = new BufferedReader(new FileReader(nombre))){
            return br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TDAUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TDAUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    
    public static HashMap<String, Integer> calcularFrecuencias(String texto){
        HashMap<String,Integer> frecuencias = new HashMap<>();
        char[] letras = texto.toCharArray();
        for(char letra: letras){
            if(! frecuencias.containsKey(letra)){
                frecuencias.put(String.valueOf(letra), 1);
            }else{
                int cant = frecuencias.get(letra);
                frecuencias.put(texto, cant+1);
            }
        }
        return frecuencias;
    }
    
    public String binarioHexadecimal(String binario){
        StringBuilder sb = new StringBuilder();
        int espaciosExtras = binario.length()%4;
        binario+= "0".repeat(espaciosExtras);
        int i =0;

        while(i<binario.length()){
            char[] array = new char[4];
            binario.getChars(i, i+4, array, 0);
            int decimal = Integer.parseInt(String.copyValueOf(array),2);
            String hexadecimal = Integer.toString(decimal, 16).toUpperCase();
            
            sb.append(hexadecimal);
            i+=4;
        }
        sb.append("-".repeat(espaciosExtras));
        return sb.toString();
    }
    
    
    public  String hexadecimalBinario(String hexadecimal){
       return null;
    }
    
    
    
    
    
}
