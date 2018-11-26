package util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;

public class Formatacao {

    static DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static JFormattedTextField getFormatado(String formato) {
        JFormattedTextField campoFormatado = null;
        MaskFormatter format = new MaskFormatter();

        format.setPlaceholderCharacter(' ');
        format.setValueContainsLiteralCharacters(false);

        try {
            format.setMask(formato);
            campoFormatado = new JFormattedTextField(format);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return campoFormatado;
    }

    public static void formatarDecimal(JTextField campo) {
        campo.setText(df.format(Double.parseDouble(campo.getText())));
    }

    public static String formatarDecimal(double valor) {
        NumberFormat formatter = new DecimalFormat("###0.00");
        return (formatter.format(valor));
    }

    public static JFormattedTextField getTelefone() {
        return getFormatado("(##) ####-####");
    }

    public static JFormattedTextField getCNPJ() {
        return getFormatado("##.###.###/####-##");
    }

    public static JFormattedTextField getCPF() {
        return getFormatado("###.###.###-##");
    }

    public static JFormattedTextField getData() {
        return getFormatado("##/##/####");
    }

    public static JFormattedTextField getDataHora() {
        return getFormatado("##/##/#### ##:##");
    }

    public void formatoDecimal(JTextField campo) {
        campo.setText(df.format(Double.parseDouble(campo.getText())));
    }

    public static void reformatarData(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("##/##/####");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void reformatarCpf(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("###.###.###-##");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void reformatarCnpj(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("##.###.###/####-##");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void reformatarTelefone(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("(##)####-####");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static String ajustaDataDMA(String data) {
        if (data == null) {
            return null;
        } else {
            String dataFormatada = null;
            try {
                Date dataAMD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
                dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAMD);
            } catch (Exception e) {
                System.err.println(e);
            }
            return (dataFormatada);
        }
    }
    
    public static String ajustaDataDMAHHMM(Date data) {
        if (data == null) {
            return null;
        } else {
            String dataFormatada = null;
            try {
                dataFormatada = new SimpleDateFormat("dd/MM/yyyy - hh:mm").format(data);
            } catch (Exception e) {
                System.err.println(e);
            }
            return (dataFormatada);
        }
    }

    public static String ajustaDataAMD(String data) {
        String dataFormatada = null;
        try {
            Date dataDMA = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            dataFormatada = new SimpleDateFormat("yyyy-MM-dd").format(dataDMA);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String removerFormatacao(String dado) {
        String retorno = "";
        dado = dado.replaceAll("'", "");
        for (int i = 0; i < dado.length(); i++) {
            if (dado.charAt(i) != '.' && dado.charAt(i) != '/' && dado.charAt(i) != '-' && dado.charAt(i) != ' ') {
                retorno = retorno + dado.charAt(i);
            }
        }
        return (retorno);
    }

    public static String getDataAtual() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = df.format(now);

        return dataHoje;
    }

    public static String getDataHoraAtual() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataHoje = df.format(now);

        return dataHoje;
    }
    
    public static String getDataHoraAtualArquivo() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy - HH mm");
        String dataHoje = df.format(now);

        return dataHoje;
    }

    public static Date transformarParaData(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date) format.parse(data);
        return date;
    }

    public static Date transformarParaDataHora(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        Date date = (Date) format.parse(data);
        return date;
    }

    public static void formataJTextField(JTextField campo) {
        campo.setText(campo.getText().replaceAll("'", "").trim());
    }

    public static void formataJTextArea(JTextArea campo) {
        campo.setText(campo.getText().replaceAll("'", "").trim());
    }

    public static void limpaTabela(JTable tabela) {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        tabela.setModel(modelo);
    }

    public static Timestamp paraTimestamp(Date data) {
        System.out.println(new Timestamp(data.getTime()).getTime());
        return new Timestamp(data.getTime());
    }

    public static String decimalParaString(BigDecimal df) {
        String numero = df.toString();
        numero = numero.replace('.', ',');
        
        String[] partes = numero.split(",");

        return partes[0] + "," + partes[1].substring(0, 2);
    }
}
