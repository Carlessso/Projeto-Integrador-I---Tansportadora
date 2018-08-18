/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Endereco;
import entidades.EnderecosPessoa;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Ramon
 */
public class EnderecosPessoaDao extends Dao {

    public static EnderecosPessoa buscaEndereco(Endereco endereco) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria criterio = sessao.createCriteria(EnderecosPessoa.class);
            criterio.add(Restrictions.eq("endereco", endereco));

            return (EnderecosPessoa) criterio.list().get(0);

        } catch (HibernateException he) {
            he.printStackTrace();
            EnderecosPessoa e = null;
            return e;
        } finally {
            sessao.close();
        }
    }
}
