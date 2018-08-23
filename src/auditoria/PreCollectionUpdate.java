/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditoria;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPreCollectionUpdateEventListenerImpl;
import org.hibernate.event.spi.PreCollectionUpdateEvent;
import transoft.TranSOFT;

/**
 *
 * @author ramon
 */
public class PreCollectionUpdate extends EnversPreCollectionUpdateEventListenerImpl {

    protected PreCollectionUpdate(AuditConfiguration enversConfiguration) {
        super(enversConfiguration);
    }

    @Override
    public void onPreUpdateCollection(PreCollectionUpdateEvent event) {
        if (TranSOFT.AUDITORIA) {
            super.onPreUpdateCollection(event);
        }
    }
}
