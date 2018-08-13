/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

/**
 *
 * @author Matheus
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import util.ComboItens;
import entidades.Endereco;
import entidades.Estado;
import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.Unidade;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
import util.Formatacao;
import util.HibernateUtil;

/**
 *
 * @author Ramon
 */
public class EnderecoDao extends Dao {

    public static Endereco buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Endereco e = (Endereco) sessao.get(Endereco.class, id);
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
            
            crit = sessao.createCriteria(Endereco.class);
            
            List dados = crit.list();
            
            for (Object dado : dados) {
                Endereco e = (Endereco) dado;
                item = new ComboItens();
                item.setCodigo(e.getId());
                item.setDescricao(e.getCidade().getNome());

                combo.addItem(item);
            }

        } catch (Exception e) {

        }
    }
}
