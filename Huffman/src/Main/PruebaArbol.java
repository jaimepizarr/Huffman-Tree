/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import TDA.HuffmanTree;
import java.util.HashMap;

/**
 *
 * @author PC
 */
public class PruebaArbol {

    public static void main(String[] args){
        HuffmanTree arbol = new HuffmanTree();
        HashMap<String,Integer> mapa = new HashMap<>();
        mapa.put("A", 6);
        mapa.put("B", 8);
        mapa.put("C", 5);
        mapa.put("D", 7);
        mapa.put("E", 6);
        mapa.put("F", 8);
        mapa.put("G", 11);
        arbol.calcularArbol(mapa);
        HashMap<String, String> codigos = arbol.calcularCodigos();
        System.out.println(codigos.toString());

    }
}
