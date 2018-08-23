/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditoria;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPostCollectionRecreateEventListenerImpl;
import org.hibernate.event.spi.PostCollectionRecreateEvent;
import transoft.TranSOFT;

/**
 *
 * @author ramon
 */
public class PostCollectionRecreate extends EnversPostCollectionRecreateEventListenerImpl {

    protected PostCollectionRecreate(AuditConfiguration enversConfiguration) {
        super(enversConfiguration);
    }

    @Override
    public void onPostRecreateCollection(PostCollectionRecreateEvent event) {
        if (TranSOFT.AUDITORIA) {
            super.onPostRecreateCollection(event);
        }
    }
}
