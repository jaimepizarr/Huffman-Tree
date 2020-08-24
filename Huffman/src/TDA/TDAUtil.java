/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    public static void guardarTexto (String nombreArchivo, String texto, HashMap<String,String> mapa){
        guardarTexto(nombreArchivo,texto);
        guardarTexto(mapa,nombreArchivo+"_compress.txt");
    }
    
    private static void guardarTexto(HashMap<String,String> mapa,String nombre){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre))){
            oos.writeObject(mapa);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TDAUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TDAUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void guardarTexto(String nombreArchivo, String texto){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))){
            bw.write(texto);
        } catch (IOException ex) {
            Logger.getLogger(TDAUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static HashMap<String,String> leerMapa (String nombreArchivo){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))){
            HashMap<String,String> mapa = (HashMap<String,String>) ois.readObject();
            return mapa;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TDAUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TDAUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TDAUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
