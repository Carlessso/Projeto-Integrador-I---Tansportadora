/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditoria;

import org.hibernate.envers.RevisionListener;
import transoft.TranSOFT;

/**
 *
 * @author ramon
 */
public class UserRevisionListener implements RevisionListener {

    public static String LOGIN = TranSOFT.LOGIN;
    
    @Override
    public void newRevision(Object o) {
            UserRevEntity revisao = (UserRevEntity) o;
            revisao.setLogin(LOGIN);
    }
}
