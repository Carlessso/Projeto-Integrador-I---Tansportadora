/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.ProdutosFrete;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author ramon
 */
public class ProdutosFreteDao extends Dao{
    public static ProdutosFrete buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            ProdutosFrete pf = (ProdutosFrete) sessao.get(ProdutosFrete.class, id);
            return pf;

        } catch (HibernateException he) {
            he.printStackTrace();
           
            return null;
        } finally {
            sessao.close();
        }
    }
}
