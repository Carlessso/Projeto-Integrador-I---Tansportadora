/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transoft;

import daos.AuditarDao;
import log4j.Log4J;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import telas.FrmPrincipal;

/**
 *
 * @author ramon
 */
public class TranSOFT {
    
    public static String LOGIN;
    public static boolean AUDITORIA;
    public static Logger log = Logger.getLogger(Log4J.class.getName());
    
    public static void main(String[] args) {
        log.removeAllAppenders();
        LOGIN = "Teste";
        
        AUDITORIA = (AuditarDao.auditar()).getAuditar();

        FrmPrincipal form = new FrmPrincipal();
        form.setVisible(true);

    }
}
