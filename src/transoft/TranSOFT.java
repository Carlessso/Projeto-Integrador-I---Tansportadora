/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transoft;

import org.hibernate.envers.event.spi.EnversIntegrator;
import auditoria.UserRevEntity;
import auditoria.UserRevisionListener;
import telas.FrmPrincipal;
import util.HibernateUtil;

/**
 *
 * @author ramon
 */
public class TranSOFT {
    
    public static String LOGIN;
    public static boolean AUDITORIA;
    
    public static void main(String[] args) {
        
        LOGIN = "Teste";
        AUDITORIA = true;

        FrmPrincipal form = new FrmPrincipal();
        form.setVisible(true);

    }
}
