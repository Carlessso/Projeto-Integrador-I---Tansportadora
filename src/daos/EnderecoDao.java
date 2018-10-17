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
import entidades.ComboItens;
import entidades.Endereco;
import entidades.EnderecosPessoa;
import entidades.Estado;
import entidades.Pessoa;
import entidades.PessoaFisica;
import entidades.Unidade;
import java.sql.ResultSet;
import java.util.Iterator;
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

    public static void populaCombo(JComboBox combo, Pessoa p) {
        ComboItens item = new ComboItens();
        combo.removeAllItems();

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit = null;

            crit = sessao.createCriteria(Endereco.class);
            crit.createCriteria("enderecosPessoas").add(Restrictions.eq("pessoa", p));
            
            List dados = crit.list();

            for (Object dado : dados) {
                Endereco e = (Endereco) dado;
                item = new ComboItens();
                item.setCodigo(e.getId());
                item.setDescricao(e.getCidade().getNome() + ", " + e.getBairro() + ", nº " + e.getNumero());

                combo.addItem(item);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void popularTabelaEndereco(JTable tabela, Pessoa pessoa) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Logradouro";
        cabecalho[2] = "Número";
        cabecalho[3] = "Cidade";

        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit = sessao.createCriteria(EnderecosPessoa.class);;
            // definição dos filtros
            crit.add(Restrictions.eq("pessoa", pessoa));
            dados = crit.list();

            dadosTabela = new Object[dados.size()][4];

            int lin = 0;

            for (Object dado : dados) {
                EnderecosPessoa ep = (EnderecosPessoa) dado;
                Endereco e = ep.getEndereco();
                dadosTabela[lin][0] = e.getId();
                dadosTabela[lin][1] = e.getRua();
                dadosTabela[lin][2] = e.getNumero();
                dadosTabela[lin][3] = e.getCidade().getNome();
                lin++;
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
                    //   return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(50);
                    column.setMaxWidth(50);
                case 1:
                    column.setPreferredWidth(140);
                    break;
                case 2:
                    column.setPreferredWidth(70);
                    break;
                case 3:
                    column.setPreferredWidth(25);
                    break;
            }
        }
    }
}
