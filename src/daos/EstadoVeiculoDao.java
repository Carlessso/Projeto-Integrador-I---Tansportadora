/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Estado;
import entidades.EstadoVeiculo;
import entidades.Pessoa;
import entidades.PessoaFisica;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import util.ComboItens;
import util.Formatacao;
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
