/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import entidades.Licenca;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import javax.crypto.Cipher;

/**
 *
 * @author ramon
 */
public class CriptografiaRSA {

    public static final String ALGORITHM = "RSA";

    /**
     * Local da chave privada no sistema de arquivos.
     */
    public static final String PATH_CHAVE_PRIVADA = "private.key";

    /**
     * Local da chave pública no sistema de arquivos.
     */
    public static final String PATH_CHAVE_PUBLICA = "public.key";

    /**
     * Gera a chave que contém um par de chave Privada e Pública usando 1025
     * bytes. Armazena o conjunto de chaves nos arquivos private.key e
     * public.key
     */
    public static void geraChave() {
        try {
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyGen.initialize(3064);
            final KeyPair key = keyGen.generateKeyPair();

            File chavePrivadaFile = new File(PATH_CHAVE_PRIVADA);
            File chavePublicaFile = new File(PATH_CHAVE_PUBLICA);

            // Cria os arquivos para armazenar a chave Privada e a chave Publica
            if (chavePrivadaFile.getParentFile() != null) {
                chavePrivadaFile.getParentFile().mkdirs();
            }

            chavePrivadaFile.createNewFile();

            if (chavePublicaFile.getParentFile() != null) {
                chavePublicaFile.getParentFile().mkdirs();
            }

            chavePublicaFile.createNewFile();

            // Salva a Chave Pública no arquivo
            ObjectOutputStream chavePublicaOS = new ObjectOutputStream(
                    new FileOutputStream(chavePublicaFile));
            chavePublicaOS.writeObject(key.getPublic());
            chavePublicaOS.close();

            // Salva a Chave Privada no arquivo
            ObjectOutputStream chavePrivadaOS = new ObjectOutputStream(
                    new FileOutputStream(chavePrivadaFile));
            chavePrivadaOS.writeObject(key.getPrivate());
            chavePrivadaOS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Verifica se o par de chaves Pública e Privada já foram geradas.
     */
    public static boolean verificaSeExisteChavesNoSO() {

        File chavePrivada = new File(PATH_CHAVE_PRIVADA);
        File chavePublica = new File(PATH_CHAVE_PUBLICA);

        if (chavePrivada.exists() && chavePublica.exists()) {
            return true;
        }

        return false;
    }

    /**
     * Criptografa o texto puro usando chave privada.
     */
    public static byte[] criptografa(String texto, PrivateKey chave) {
        byte[] cipherText = null;

        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            // Criptografa o texto puro usando a chave Púlica
            cipher.init(Cipher.ENCRYPT_MODE, chave);
            cipherText = cipher.doFinal(texto.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cipherText;
    }

    /**
     * Decriptografa o texto puro usando chave publica.
     */
    public static String decriptografa(byte[] texto, PublicKey chave) {
        byte[] dectyptedText = null;

        try {
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            // Decriptografa o texto puro usando a chave Privada
            cipher.init(Cipher.DECRYPT_MODE, chave);
            dectyptedText = cipher.doFinal(texto);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new String(dectyptedText);
    }

    public static void geraLicenca(Licenca licenca) {
        try {
            File arquivo = new File("licenca.TranSOFT");
            XStream xstream = new XStream();

            ObjectInputStream inputStream = null;
            inputStream = new ObjectInputStream(new FileInputStream(PATH_CHAVE_PRIVADA));
            final PrivateKey chavePrivada = (PrivateKey) inputStream.readObject();
            final byte[] textoCriptografado = criptografa(xstream.toXML(licenca), chavePrivada);

            FileOutputStream in = new FileOutputStream(arquivo);
            in.write(textoCriptografado);
            in.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String verificaLicenca() {
        try {
            XStream xstream = new XStream(new DomDriver());

            Path arquivo = Paths.get("licenca.TranSOFT");

            byte[] textoCriptografado = Files.readAllBytes(arquivo);

            ObjectInputStream inputStream = null;
            inputStream = new ObjectInputStream(new FileInputStream(PATH_CHAVE_PUBLICA));
            final PublicKey chavePublica = (PublicKey) inputStream.readObject();

            if (!chavePublica.getFormat().equals("X.509") || chavePublica.hashCode() != 1876506) {
                return "Chave de verificação inválida!\nErro ao verificar licença.";
            } else {
                final String textoPuro = decriptografa(textoCriptografado, chavePublica);
                Licenca licenca = (Licenca) xstream.fromXML(textoPuro);
                System.out.println(licenca.getValidade());
                if (licenca.getValidade().before(new Date())) {
                    return "Resta(m) " + 5 + " dia(s) para a licença expirar!";
                } else {
                    long dt = (licenca.getValidade().getTime() - new Date().getTime());
                    Long dias = dt / 86400000L; // número de dias
                    int diasInteiros = dias.intValue();
                    if (diasInteiros <= 5 && diasInteiros > 0) {
                        return "Resta(m) " + diasInteiros + " dia(s) para a licença expirar!";
                    } else if (diasInteiros == 0) {
                        return "Último dia de licença!\nSolicite renovação.";
                    } else {
                        return "";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return "Falha ao verificar Licença!";
        }
    }
}
