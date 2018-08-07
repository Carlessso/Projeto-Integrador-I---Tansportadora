/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author ramon
 */
public class FormataCampo extends JTextField {

    public static void somenteNumeros(java.awt.event.KeyEvent evt) {
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }
    
    public static void semNumeros(java.awt.event.KeyEvent evt) {
        String caracteres = "0987654321'\\-";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

    public static boolean limitaTamanho(String campo, java.awt.event.KeyEvent evt, int maximo) {
        if (campo.length() >= maximo) {
            evt.consume();
            return true; //retorna que excedeu o tamanho.
        }else{
            return false; //retorna que não ecxedeu o tamanho.
        }
    }
    
    public static void formataValor(JTextField campo, java.awt.event.KeyEvent evt) {
        try {
            String valorFormatado = campo.getText().replaceAll(",", "") + evt.getKeyChar();
            evt.consume();
            int valor = Integer.parseInt(valorFormatado);
            if (valor < 10) {
                valorFormatado = "0,0" + valor;
            } else if (valor < 100) {
                valorFormatado = "0," + valor;
            } else if (valor < 1000) {
                valorFormatado = ("" + valor).charAt(0) + "," + ("" + valor).substring(1, 3);
            } else if (valor < 10000) {
                valorFormatado = ("" + valor).substring(0, 2) + "," + ("" + valor).substring(2, 4);
            } else if (valor < 100000) {
                valorFormatado = ("" + valor).substring(0, 3) + "," + ("" + valor).substring(3, 5);
            } else if (valor < 1000000) {
                valorFormatado = ("" + valor).substring(0, 4) + "," + ("" + valor).substring(4, 6);
            } else if (valor < 10000000) {
                valorFormatado = ("" + valor).substring(0, 5) + "," + ("" + valor).substring(5, 7);
            }
            campo.setText(valorFormatado);
        } catch (Exception e) {
        }
    }
    
    public static void bloquearColar(java.awt.event.KeyEvent evt){
        if (evt.getModifiers() == Event.CTRL_MASK) {
            if (evt.getKeyCode() == KeyEvent.VK_V) {
                evt.consume();
            }
        }
    }
}
