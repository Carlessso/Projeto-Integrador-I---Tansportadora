/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author ramon
 */
public class Zip {

    private static final int TAMANHO_BUFFER = 2048; // 2 Kb

    static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;

        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);

        addFolderToZip("", srcFolder, zip);
        zip.flush();
        zip.close();
    }

    static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
            throws Exception {

        File folder = new File(srcFile);
        if (folder.isDirectory()) {
            addFolderToZip(path, srcFile, zip);
        } else {
            byte[] buf = new byte[1024];
            int len;
            FileInputStream in = new FileInputStream(srcFile);
            zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
            while ((len = in.read(buf)) > 0) {
                zip.write(buf, 0, len);
            }
        }
    }

    static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
            throws Exception {
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
            if (path.equals("")) {
                addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
            } else {
                addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
            }
        }
    }

    public static boolean extrairZip(File arquivoZip, File diretorio) throws ZipException, IOException {
        ZipFile zip = null;
        File arquivo = null;
        InputStream is = null;
        OutputStream os = null;
        byte[] buffer = new byte[TAMANHO_BUFFER];
        try {
            //cria diretório informado, caso não exista
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            if (!diretorio.exists() || !diretorio.isDirectory()) {
                throw new IOException("Informe um diretório válido");
            }
            zip = new ZipFile(arquivoZip);
            Enumeration e = zip.entries();
            while (e.hasMoreElements()) {
                ZipEntry entrada = (ZipEntry) e.nextElement();
                arquivo = new File(diretorio, entrada.getName());
                //se for diretório inexistente, cria a estrutura 
                //e pula pra próxima entrada
                if (entrada.isDirectory() && !arquivo.exists()) {
                    arquivo.mkdirs();
                    continue;
                }
                //se a estrutura de diretórios não existe, cria
                if (!arquivo.getParentFile().exists()) {
                    arquivo.getParentFile().mkdirs();
                }
                try {
                    //lê o arquivo do zip e grava em disco
                    is = zip.getInputStream(entrada);
                    os = new FileOutputStream(arquivo);
                    int bytesLidos = 0;
                    if (is == null) {
                        throw new ZipException("Erro ao ler a entrada do zip: " + entrada.getName());
                    }
                    while ((bytesLidos = is.read(buffer)) > 0) {
                        os.write(buffer, 0, bytesLidos);
                    }
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception ex) {
                            return false;
                        }
                    }
                    if (os != null) {
                        try {
                            os.close();
                        } catch (Exception ex) {
                            return false;
                        }
                    }
                }
            }
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean extrairZipArquivoUnico(File arquivoZip, File diretorio, String nomeArquivo) throws ZipException, IOException {
        ZipFile zip = null;
        File arquivo = null;
        InputStream is = null;
        OutputStream os = null;
        byte[] buffer = new byte[TAMANHO_BUFFER];
        try {
            //cria diretório informado, caso não exista
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            if (!diretorio.exists() || !diretorio.isDirectory()) {
                throw new IOException("Informe um diretório válido");
            }
            zip = new ZipFile(arquivoZip);
            Enumeration e = zip.entries();
            while (e.hasMoreElements()) {
                ZipEntry entrada = (ZipEntry) e.nextElement();
                arquivo = new File(diretorio, entrada.getName());
                //se for diretório inexistente, cria a estrutura 
                //e pula pra próxima entrada
                if (entrada.isDirectory() && !arquivo.exists()) {
                    arquivo.mkdirs();
                    continue;
                }
                //se a estrutura de diretórios não existe, cria
                if (!arquivo.getParentFile().exists()) {
                    arquivo.getParentFile().mkdirs();
                }
                if (entrada.getName().equalsIgnoreCase(nomeArquivo)) {
                    try {
                        //lê o arquivo do zip e grava em disco
                        is = zip.getInputStream(entrada);
                        os = new FileOutputStream(arquivo);
                        int bytesLidos = 0;
                        if (is == null) {
                            throw new ZipException("Erro ao ler a entrada do zip: " + entrada.getName());
                        }
                        while ((bytesLidos = is.read(buffer)) > 0) {
                            os.write(buffer, 0, bytesLidos);
                        }
                    } finally {
                        if (is != null) {
                            try {
                                is.close();
                            } catch (Exception ex) {
                                return false;
                            }
                        }
                        if (os != null) {
                            try {
                                os.close();
                            } catch (Exception ex) {
                                return false;
                            }
                        }
                    }
                }
            }
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }
}
