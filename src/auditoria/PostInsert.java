/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditoria;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl;
import org.hibernate.event.spi.PostInsertEvent;
import transoft.TranSOFT;

/**
 *
 * @author ramon
 */
public class PostInsert extends EnversPostInsertEventListenerImpl {

    protected PostInsert(AuditConfiguration enversConfiguration) {
        super(enversConfiguration);
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        if (TranSOFT.AUDITORIA) {
            super.onPostInsert(event);
        }
    }
}
