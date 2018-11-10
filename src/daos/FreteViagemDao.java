/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Frete;
import entidades.FreteViagem;
import entidades.Viagem;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Ramon
 */
public class FreteViagemDao extends Dao{
    public static FreteViagem busca(Frete frete, Viagem viagem){
        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;

            crit = sessao.createCriteria(FreteViagem.class);
            crit.add(Restrictions.eq("frete", frete));
            crit.add(Restrictions.eq("viagem", viagem));
            dados = crit.list();

            return (FreteViagem)dados.get(0);

        } catch (HibernateException he) {
            he.printStackTrace();

            return null;
        } finally {
            sessao.close();
        }
    }
}
