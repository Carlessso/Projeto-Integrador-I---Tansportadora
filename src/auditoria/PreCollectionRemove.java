/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditoria;

import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversPreCollectionRemoveEventListenerImpl;
import org.hibernate.event.spi.PreCollectionRemoveEvent;
import transoft.TranSOFT;

/**
 *
 * @author ramon
 */
public class PreCollectionRemove extends EnversPreCollectionRemoveEventListenerImpl {

    protected PreCollectionRemove(AuditConfiguration enversConfiguration) {
        super(enversConfiguration);
    }

    @Override
    public void onPreRemoveCollection(PreCollectionRemoveEvent event) {
        if (TranSOFT.AUDITORIA) {
            super.onPreRemoveCollection(event);
        }
    }
}
