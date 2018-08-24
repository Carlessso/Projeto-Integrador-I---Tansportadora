/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Auditar;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Ramon
 */
public class AuditarDao extends Dao {

    public static Auditar auditar() {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Auditar a = (Auditar) sessao.get(Auditar.class, 1);
            return a;

        } catch (HibernateException he) {
            he.printStackTrace();

            return null;
        } finally {
            sessao.close();
        }
    }
}
