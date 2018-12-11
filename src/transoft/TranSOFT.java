/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transoft;

import daos.AuditarDao;
import daos.ReleaseDao;
import daos.UnidadeDao;
import entidades.Licenca;
import entidades.Unidade;
import entidades.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import telas.FrmLogin;
import util.CriptografiaRSA;

/**
 *
 * @author ramon
 */
public class TranSOFT {

    public static Usuario USUARIO;
    public static boolean AUDITORIA;
    public static Logger log = Logger.getLogger(TranSOFT.class.getName());
    public static Unidade UNIDADE;

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        log.removeAllAppenders();

        Licenca licenca = new Licenca();
        licenca.setEmpresa("seu cuca é eu");
        Date validade = null;
        try {
            validade = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss").parse("01/01/2019 - 23:59:59");
        } catch (Exception e) {
        }
        
        licenca.setValidade(validade);
        licenca.setTipo("Anual");

        //CriptografiaRSA.geraChave();
        CriptografiaRSA.geraLicenca(licenca);
        //CriptografiaRSA.verificaLicenca();
        String verificaLicenca = CriptografiaRSA.verificaLicenca();
        if(verificaLicenca.contains("Erro") || verificaLicenca.contains("expirada") || verificaLicenca.contains("Falha")){
            JOptionPane.showMessageDialog(null, verificaLicenca, "Licença", JOptionPane.OK_OPTION);
            System.exit(0);
        } else if(verificaLicenca.contains("Resta(m)") || verificaLicenca.contains("Último")){
            JOptionPane.showMessageDialog(null, verificaLicenca, "Licença", JOptionPane.INFORMATION_MESSAGE);
        }

        AUDITORIA = (AuditarDao.auditar()).getAuditar();

        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("conf.properties"));
            int idUnidade = Integer.parseInt(prop.getProperty("unidade.id"));
            UNIDADE = UnidadeDao.buscaId(idUnidade);
        } catch (IOException | NumberFormatException e) {
            log.error(e);
        }
        
        ReleaseDao.gravaReleases();
        
        FrmLogin form = new FrmLogin();
        form.setVisible(true);

    }
}
