/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Pessoa;
import entidades.PessoaFisica;
import java.sql.ResultSet;
import java.util.List;
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
public class PessoaFisicaDao extends Dao {

    public static boolean cpfUsado(String cpf) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria criterio = sessao.createCriteria(PessoaFisica.class);
            criterio.add(Restrictions.eq("cpf", cpf));

            return !criterio.list().isEmpty();

        } catch (HibernateException he) {
            he.printStackTrace();
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public static PessoaFisica buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            PessoaFisica pf = (PessoaFisica) sessao.get(PessoaFisica.class, id);
            return pf;

        } catch (HibernateException he) {
            he.printStackTrace();
           
            return null;
        } finally {
            sessao.close();
        }
    }

    public static List busca(String crit, String campo) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria criterio = sessao.createCriteria(PessoaFisica.class);
            criterio.add(Restrictions.eq(campo, crit));

            return criterio.list();

        } catch (HibernateException he) {
            he.printStackTrace();
            List t = null;
            return t;
        } finally {
            sessao.close();
        }
    }

    public static void popularTabelaFiltro(JTable tabela, String criterio, String filtro) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome Completo";
        cabecalho[2] = "CPF";
        cabecalho[3] = "Nascimento";

        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;
            // definição dos filtros
            if (filtro.equals("CPF")) {
                filtro = "cpf";
                crit = sessao.createCriteria(PessoaFisica.class);
            } else if (filtro.equals("Nome")) {
                crit = sessao.createCriteria(Pessoa.class);
                crit.createAlias("pessoaFisica", "pessoa");
                filtro = "nome";
            } else {
                crit = sessao.createCriteria(PessoaFisica.class);
                filtro = "rg";
            }

            crit.add(Restrictions.ilike(filtro, criterio, MatchMode.ANYWHERE));
            dados = crit.list();

            dadosTabela = new Object[dados.size()][4];

            int lin = 0;

            if (filtro.equalsIgnoreCase("nome")) {
                for (Object dado : dados) {
                    Pessoa p = (Pessoa) dado;
                        dadosTabela[lin][0] = p.getId();
                        dadosTabela[lin][1] = p.getNome();
                        dadosTabela[lin][2] = p.getPessoaFisica().getCpf();
                        if (p.getNascimento() != null) {
                            dadosTabela[lin][3] = Formatacao.ajustaDataDMA(p.getNascimento().toString());
                        }
                        lin++;
                    }
            } else {
                for (Object dado : dados) {
                    PessoaFisica pf = (PessoaFisica) dado;
                    dadosTabela[lin][0] = pf.getRefPessoa();
                    dadosTabela[lin][1] = pf.getPessoa().getNome();
                    dadosTabela[lin][2] = pf.getCpf();
                    if (pf.getPessoa().getNascimento() != null) {
                        dadosTabela[lin][3] = Formatacao.ajustaDataDMA(pf.getPessoa().getNascimento().toString());
                    }
                    lin++;
                }
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
