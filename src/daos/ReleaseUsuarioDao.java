/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Release;
import entidades.ReleaseUsuario;
import entidades.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import transoft.TranSOFT;
import util.HibernateUtil;

/**
 *
 * @author Matheus
 */
public class ReleaseUsuarioDao extends Dao {
    
    public static boolean isLido(int ref_usuario, int ref_release) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Usuario u = UsuarioDao.buscaId(ref_usuario);
            Release r = ReleaseDao.buscaId(ref_release);
            
            Criteria criterio = sessao.createCriteria(ReleaseUsuario.class);
            criterio.add(Restrictions.eq("usuario", u));
            criterio.add(Restrictions.eq("release", r));
            criterio.add(Restrictions.eq("fl_lido", true));
            
            List dados = criterio.list();
            
            if (dados.isEmpty()) {
                return false;
            } else {
                return true;
            }
        } catch (HibernateException he) {
            he.printStackTrace();
            
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public static void marcarComoNaoLida(String descricao) {
        Session sessao = null;
        List dados = null;
        List dados2 = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            
            Criteria criterio = sessao.createCriteria(Release.class);
            criterio.add(Restrictions.eq("descricao", descricao));
            
            dados = criterio.list();
            
            for (Object dado : dados) {
                Release r = (Release) dado;
                
                Criteria crit2 = sessao.createCriteria(ReleaseUsuario.class);
                crit2.add(Restrictions.eq("usuario", TranSOFT.USUARIO));
                crit2.add(Restrictions.eq("release", r));
                
                dados2 = crit2.list();
                
                for (Object dado2 : dados2) {
                    ReleaseUsuario ru = (ReleaseUsuario) dado2;
                    
                    Transaction t = sessao.beginTransaction();
                    sessao.delete(ru);
                    t.commit();
                }
                
            }
            
        } catch (HibernateException he) {
            he.printStackTrace();
            
        } finally {
            sessao.close();
        }
        
    }
    
    public static void marcarComoLida(String descricao) {
        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            
            Criteria criterio = sessao.createCriteria(Release.class);
            criterio.add(Restrictions.eq("descricao", descricao));
            
            dados = criterio.list();
            
            for (Object dado : dados) {
                Release r = (Release) dado;
                System.out.println(r.getDescricao());
                ReleaseUsuario ru = new ReleaseUsuario();
                
                ru.setRelease(r);
                ru.setUsuario(TranSOFT.USUARIO);
                ru.setFl_lido(true);
                
                Dao.salvar(ru);
                
            }
            
        } catch (HibernateException he) {
            he.printStackTrace();
            
        } finally {
            sessao.close();
        }
        
    }
}
