/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ramon
 */
public class Dao {
    public static String salvar(Object o){
        Session sessao = null;
            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();
                sessao.saveOrUpdate(o);
                t.commit();
                
                return "Sucesso";
            } catch (HibernateException he) {
                he.printStackTrace();
                
                return "Erro ao salvar";
            } finally {
                sessao.close();
            }
    }
    //recebe um objeto e o deleta
    public static String deletar(Object o){
        Session sessao = null;
            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                Transaction t = sessao.beginTransaction();
                sessao.delete(o);
                t.commit();
                
                return "Sucesso";
            } catch (HibernateException he) {
                he.printStackTrace();
                
                return "Erro ao deletar";
            } finally {
                sessao.close();
            }
    }
}
