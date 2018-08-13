/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.*;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 *
 * @author rhentges
 */
public class Validacao {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
    
    public static boolean ValidaNumero(JTextField Num) {
        long valor;
        boolean retorno = false;
        if (Num.getText().length() != 0) {
            try {
                valor = Long.parseLong(Num.getText());
                retorno = true;
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "O campo " + Num.getName() + " só aceita números inteiros!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                Num.grabFocus();
                retorno = false;
            }
        }        
        return retorno;
    }
    public static boolean ValidaDouble(JTextField Num) {
        double valor;
        boolean retorno = false;
        if (Num.getText().length() != 0) {
            try {
                valor = Double.parseDouble(Num.getText());
                retorno = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "O campo " + Num.getName() + " só aceita números e o separador ponto!", "Informação", JOptionPane.INFORMATION_MESSAGE);
                Num.grabFocus();
                retorno = false;
            }
        }
        return retorno;
    }
    
    public static boolean validarCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")) {
            return (false);
        }
        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean validarCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }
        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public static boolean validarDataDMA(int d, int m, int a) {
        boolean correto = true;
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (a < 0 || m < 1 || m > 12) {
            correto = false;
        } else {
            // valida o dia
            if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                dias[1] = 29;
            }
            if (d < 1 || d > dias[m - 1]) {
                correto = false;
            }
        }
        return (correto);
    }

    public static boolean validarDataFormatada(String dataComFormato) {
        String[] data = dataComFormato.split("/");
        return (validarDataDMA(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
    }

    public static void validarTelefone(JFormattedTextField campo) {
        if (campo.getText().trim().length() < 13) {
            Formatacao.reformatarTelefone(campo);
        }
    }

    public static boolean validarEmail(String email) {
        System.out.println("Metodo de validacao de email");
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher m = p.matcher(email);
        if (m.find()) {
            System.out.println("O email " + email + " é valido");
            return true;
        } else {
            System.out.println("O E-mail " + email + " é inválido");
            return false;
        }

    }

    public static void validaNull(String entrada, String saida) {
        if (entrada != null) {
            saida = saida + entrada;
        }
    }
}
