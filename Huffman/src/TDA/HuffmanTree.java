/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tda;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 *
 * @author PC
 */
public class HuffmanTree {

    private Node root;

    private class Node {

        private String data;
        private Integer fq;
        private Node left;
        private Node right;

        public Node(String data, Integer fq) {
            this.data = data;
            this.fq = fq;
        }
    }

    public void calcularArbol(Map<String, Integer> mapa) {
        PriorityQueue<Node> colaFq = new PriorityQueue<>((Node nd1, Node nd2) -> nd1.fq - nd2.fq);
        for (Entry<String, Integer> e : mapa.entrySet()) {
            colaFq.offer(new Node(e.getKey(), e.getValue()));
        }
        while (colaFq.size() > 1) {
            Node nd1 = colaFq.poll();
            Node nd2 = colaFq.poll();
            Node padre = new Node(null, nd1.fq + nd2.fq);
            padre.left = nd1;
            padre.right = nd2;
            colaFq.offer(padre);

        }
        root = colaFq.poll();
    }

    public Map<String, String> calcularCodigos() {
        HashMap<String, String> mapa = new HashMap<>();
        calcularCodigos(mapa, "", root);
        return mapa;
    }

    private void calcularCodigos(Map<String, String> mapa, String codigo, Node n) {
        if (n.left == null && n.right == null) {
            mapa.put(n.data, codigo);
            
        }else{
            calcularCodigos(mapa, codigo+"0", n.left);
            calcularCodigos(mapa, codigo+"1" , n.right);
        }
    }

    
    public static String codificar(String texto, Map<String, String> mapa) {
        StringBuilder txtCodificado = new StringBuilder();
        for (char current : texto.toCharArray()) {
            String codigo = mapa.get(Character.toString(current));
            txtCodificado.append(codigo);
     
        }
        return txtCodificado.toString();
    }

    public static String decodificar(String texto, Map<String, String> mapa) {
        String binario= TDAUtil.hexadecimalBinario(texto);
        char[] bits = binario.toCharArray();
        StringBuilder result= new StringBuilder();
        StringBuilder temp= new StringBuilder();
        for (int i = 0; i < bits.length; i++) {
            temp.append(bits[i]);
            String val = mapa.get(temp.toString());
            if (val == null) {
                continue;
            }
            result.append(val);
            temp.setLength(0);
        }

        return result.toString();
    
    }

    

}
