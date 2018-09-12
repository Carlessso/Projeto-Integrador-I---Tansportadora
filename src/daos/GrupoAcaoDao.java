/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Acao;
import entidades.Grupo;
import entidades.GrupoAcao;
import entidades.Programas;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import util.HibernateUtil;

/**
 *
 * @author Matheus
 */
public class GrupoAcaoDao {
    
    public static String deletarTodos(Grupo grupo)
    {
        Session sessao = null;
        try
            {
            sessao = HibernateUtil.getSessionFactory().openSession();
            List dados = null;
            Criteria crit;

            crit = sessao.createCriteria(GrupoAcao.class);
            crit.add(Restrictions.eq("grupo", grupo));
            
            dados = crit.list();
                
            for (Object dado : dados) {
                GrupoAcao gp = (GrupoAcao) dado;

                Transaction t = sessao.beginTransaction();
                sessao.delete(gp);
                t.commit();
                           
            }
            
            return "Sucesso";
        } catch (HibernateException he) {
            he.printStackTrace();
            return "Erro ao deletar";
        } finally {
            sessao.close();
        }
    }
    
    public static String deletarAcaoGrupo(Grupo grupo, Acao acao)
    {
        Session sessao = null;
        try
            {
            sessao = HibernateUtil.getSessionFactory().openSession();
            List dados = null;
            Criteria crit;

            crit = sessao.createCriteria(GrupoAcao.class);
            crit.add(Restrictions.eq("grupo", grupo));
            crit.add(Restrictions.eq("acao", acao));
            
            dados = crit.list();
            
            System.out.println("deletados " + dados.size());
                
            for (Object dado : dados) {
                GrupoAcao gp = (GrupoAcao) dado;

                Transaction t = sessao.beginTransaction();
                sessao.delete(gp);
                t.commit();
                           
            }
            
            return "Sucesso";
        } catch (HibernateException he) {
            he.printStackTrace();
            return "Erro ao deletar";
        } finally {
            sessao.close();
        }
    }
    public static GrupoAcao buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            GrupoAcao g = (GrupoAcao) sessao.get(GrupoAcao.class, id);
            return g;

        } catch (HibernateException he) {
            he.printStackTrace();

            return null;
        } finally {
            sessao.close();
        }
    }

    public static GrupoAcao getMaxId() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List dados = null;
        Criteria crit;

        crit = sessao.createCriteria(GrupoAcao.class);
        
        crit.addOrder(Order.desc("id"));
        crit.setMaxResults(1);       

        return (GrupoAcao)crit.uniqueResult();
        
    }
}
