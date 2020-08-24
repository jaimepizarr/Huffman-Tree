/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 *
 * @author PC
 */
public class HuffmanTree {
      private Node root;
    
    private class Node{
        private String data;
        private Integer fq;
        private Node left;
        private Node right;

        public Node(String data, Integer fq) {
            this.data = data;
            this.fq = fq;
        }
    }
        
        public void calcularArbol(HashMap<String, Integer> mapa){
            PriorityQueue<Node> colaFq = new PriorityQueue<>((Node nd1, Node nd2) -> nd1.fq-nd2.fq);
            for(Entry<String, Integer> e  : mapa.entrySet()){
                colaFq.offer(new Node(e.getKey(), e.getValue()));
            }
            while(colaFq.size()>1){
                Node nd1 = colaFq.poll();
                Node nd2 = colaFq.poll();
                Node padre = new Node(nd1.data+nd2.data, nd1.fq+nd2.fq);
                padre.left = nd1;
                padre.right = nd2;
                colaFq.offer(padre);
        
            }
            root = colaFq.poll();        
        }
        
        
        public HashMap<String, String> calcularCodigos(){
            return null;
        
       
        }
        
        
        public static String codificar(String texto, HashMap<String,String> mapa){
          return null;
        
        
        
        
        }
        public static String decodificar (String texto, HashMap<String,String> mapa){
          return null;
    
    
    }
        
}
