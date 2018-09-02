/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transoft;

import daos.AuditarDao;
import entidades.Usuario;
import log4j.Log4J;
import org.apache.log4j.Logger;
import telas.FrmLogin;

/**
 *
 * @author ramon
 */
public class TranSOFT {
    
    public static Usuario USUARIO;
    public static boolean AUDITORIA;
    public static Logger log = Logger.getLogger(Log4J.class.getName());
    
    public static void main(String[] args) {
                
        AUDITORIA = (AuditarDao.auditar()).getAuditar();
        
        log.removeAllAppenders();
        
        FrmLogin form = new FrmLogin();
        form.setVisible(true);

    }
}
