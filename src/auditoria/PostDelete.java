/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditoria;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPostDeleteEventListenerImpl;
import org.hibernate.event.spi.PostDeleteEvent;
import transoft.TranSOFT;

/**
 *
 * @author ramon
 */
public class PostDelete extends EnversPostDeleteEventListenerImpl {

    protected PostDelete(AuditConfiguration enversConfiguration) {
        super(enversConfiguration);
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        if (TranSOFT.AUDITORIA) {
            super.onPostDelete(event);
        }
    }
}
