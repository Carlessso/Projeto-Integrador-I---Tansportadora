/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Pessoa;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Ramon
 */
public class PessoaDao extends Dao{
    public static Pessoa buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Pessoa p = (Pessoa) sessao.get(Pessoa.class, id);
            return p;

        } catch (HibernateException he) {
            he.printStackTrace();
           
            return null;
        } finally {
            sessao.close();
        }
    }
    
}
