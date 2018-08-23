/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auditoria;

import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.envers.configuration.spi.AuditConfiguration;
import org.hibernate.envers.event.spi.EnversListenerDuplicationStrategy;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.internal.CoreMessageLogger;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.jboss.logging.Logger;

/**
 *
 * @author ramon
 */
public class MyIntegrator implements Integrator {

    private static final CoreMessageLogger LOG = Logger.getMessageLogger(CoreMessageLogger.class, MyIntegrator.class.getName());

    @Override
    public void integrate(
            Configuration configuration,
            SessionFactoryImplementor sessionFactory,
            SessionFactoryServiceRegistry serviceRegistry) {

        EventListenerRegistry listenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);
        listenerRegistry.addDuplicationStrategy(EnversListenerDuplicationStrategy.INSTANCE);

        final AuditConfiguration enversConfiguration = AuditConfiguration.getFor(configuration);

        if (enversConfiguration.getEntCfg().hasAuditedEntities()) {
            listenerRegistry.appendListeners(EventType.POST_INSERT, new PostInsert(enversConfiguration));
            listenerRegistry.appendListeners(EventType.POST_UPDATE, new PostUpdate(enversConfiguration));
            listenerRegistry.appendListeners(EventType.POST_DELETE, new PostDelete(enversConfiguration));
            listenerRegistry.appendListeners(EventType.PRE_COLLECTION_UPDATE, new PreCollectionUpdate(enversConfiguration));
            listenerRegistry.appendListeners(EventType.POST_COLLECTION_RECREATE, new PostCollectionRecreate(enversConfiguration));
            listenerRegistry.appendListeners(EventType.PRE_COLLECTION_REMOVE, new PreCollectionRemove(enversConfiguration));
        }
    }

    @Override
    public void integrate(MetadataImplementor mi, SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disintegrate(SessionFactoryImplementor sfi, SessionFactoryServiceRegistry sfsr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
