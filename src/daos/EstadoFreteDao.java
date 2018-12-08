/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.ComboItens;
import entidades.EstadoFrete;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author ramon
 */
public class EstadoFreteDao extends Dao {

    public static void populaTabela(String criterio, JTable tabela) {
        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;
            crit = sessao.createCriteria(EstadoFrete.class);
            crit.add(Restrictions.ilike("descricao", criterio, MatchMode.ANYWHERE));
            dados = crit.list();

            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0);
            for (Object dado : dados) {
                Object[] linha = {((EstadoFrete) dado).getId(), ((EstadoFrete) dado).getDescricao()};
                model.addRow(linha);
            }
        } catch (Exception e) {

        } finally {
            sessao.close();
        }
    }

    public static List getEstados() {
        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;

            crit = sessao.createCriteria(EstadoFrete.class);

            dados = crit.list();

            return dados;

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public static EstadoFrete buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            EstadoFrete ef = (EstadoFrete) sessao.get(EstadoFrete.class, id);
            return ef;

        } catch (HibernateException he) {
            he.printStackTrace();

            return null;
        } finally {
            sessao.close();
        }
    }

    public static void populaCombo(JComboBox grupo) {
        ComboItens item;
        grupo.removeAllItems();

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit = null;

            crit = sessao.createCriteria(EstadoFrete.class);

            List dados = crit.list();

            for (Object dado : dados) {
                EstadoFrete ef = (EstadoFrete) dado;
                item = new ComboItens();
                item.setCodigo(ef.getId());
                item.setDescricao(ef.getDescricao());
                grupo.addItem(item);
            }
        } catch (Exception e) {

        }
    }

}
