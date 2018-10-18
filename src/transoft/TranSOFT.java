/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transoft;

import daos.AuditarDao;
import daos.UnidadeDao;
import entidades.Unidade;
import entidades.Usuario;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import telas.FrmLogin;

/**
 *
 * @author ramon
 */
public class TranSOFT {

    public static Usuario USUARIO;
    public static boolean AUDITORIA;
    public static Logger log = Logger.getLogger(TranSOFT.class.getName());
    public static Unidade UNIDADE;

    public static void main(String[] args) {
        log.removeAllAppenders();

        AUDITORIA = (AuditarDao.auditar()).getAuditar();

        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("conf.properties"));
            int idUnidade = Integer.parseInt(prop.getProperty("unidade.id"));
            UNIDADE = UnidadeDao.buscaId(idUnidade);
        } catch (IOException | NumberFormatException e) {
            log.error(e);
        }

        FrmLogin form = new FrmLogin();
        form.setVisible(true);

    }
}
