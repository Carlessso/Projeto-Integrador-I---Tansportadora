/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.EstadoVeiculo;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import entidades.ComboItens;
import util.HibernateUtil;

/**
 *
 * @author Matheus
 */
public class EstadoVeiculoDao extends Dao {
    
    public static EstadoVeiculo buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            EstadoVeiculo e = (EstadoVeiculo) sessao.get(EstadoVeiculo.class, id);
            return e;

        } catch (HibernateException he) {
            he.printStackTrace();
           
            return null;
        } finally {
            sessao.close();
        }
    }
    
    public static void populaTabela(String criterio, JTable tabela) {
        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;
            crit = sessao.createCriteria(EstadoVeiculo.class);
            crit.add(Restrictions.ilike("descricao", criterio, MatchMode.ANYWHERE));
            dados = crit.list();

            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0);
            for (Object dado : dados) {
                Object[] linha = {((EstadoVeiculo) dado).getId(), ((EstadoVeiculo) dado).getDescricao()};
                model.addRow(linha);
            }
        } catch (Exception e) {

        } finally {
            sessao.close();
        }
    }
    
    public static void populaCombo(JComboBox combo) {
        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit = null;
            
            crit = sessao.createCriteria(EstadoVeiculo.class);
            
            List dados = crit.list();
            
            for (Object dado : dados) {
                EstadoVeiculo es = (EstadoVeiculo) dado;
                item = new ComboItens();
                item.setCodigo(es.getId());
                item.setDescricao(es.getDescricao());

                combo.addItem(item);
            }

        } catch (Exception e) {

        }
    }
}
