/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Pessoa;
import entidades.PessoaJuridica;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import util.Formatacao;
import util.HibernateUtil;

/**
 *
 * @author Ramon
 */
public class PessoaJuridicaDao extends Dao {

    public static boolean cnpjUsado(String cnpj) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria criterio = sessao.createCriteria(PessoaJuridica.class);
            criterio.add(Restrictions.eq("cnpj", cnpj));

            return !criterio.list().isEmpty();

        } catch (HibernateException he) {
            he.printStackTrace();
            return false;
        } finally {
            sessao.close();
        }
    }
    
    public static PessoaJuridica buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            PessoaJuridica pj = (PessoaJuridica) sessao.get(PessoaJuridica.class, id);
            return pj;

        } catch (HibernateException he) {
            he.printStackTrace();
           
            return null;
        } finally {
            sessao.close();
        }
    }

    public static void popularTabelaFiltro(JTable tabela, String criterio, String filtro) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Razão Social";
        cabecalho[2] = "Nome Fantasia";
        cabecalho[3] = "CNPJ";
        cabecalho[4] = "Fundação";

        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;
            // definição dos filtros
            if (filtro.equals("CNPJ")) {
                filtro = "cnpj";
                crit = sessao.createCriteria(PessoaJuridica.class);
            } else if (filtro.equals("Razão Social")) {
                filtro = "nome";
                crit = sessao.createCriteria(Pessoa.class);
            } else {
                filtro = "nomeFantasia";
                crit = sessao.createCriteria(PessoaJuridica.class);
            }

            crit.add(Restrictions.ilike(filtro, criterio, MatchMode.ANYWHERE));
            dados = crit.list();

            dadosTabela = new Object[dados.size()][5];

            int lin = 0;

            if (filtro.equalsIgnoreCase("nome")) {
                for (Object dado : dados) {
                    Pessoa p = (Pessoa) dado;
                    dadosTabela[lin][0] = p.getId();
                    dadosTabela[lin][1] = p.getNome();
                    dadosTabela[lin][2] = p.getPessoaJuridica().getNomeFantasia();
                    dadosTabela[lin][3] = p.getPessoaJuridica().getCnpj();
                    if (p.getNascimento() != null) {
                        dadosTabela[lin][4] = Formatacao.ajustaDataDMA(p.getNascimento().toString());
                    }
                    lin++;
                }
            } else {
                for (Object dado : dados) {
                    PessoaJuridica pj = (PessoaJuridica) dado;
                    dadosTabela[lin][0] = pj.getRefPessoa();
                    dadosTabela[lin][1] = pj.getPessoa().getNome();
                    dadosTabela[lin][2] = pj.getNomeFantasia();
                    dadosTabela[lin][3] = pj.getCnpj();
                    if (pj.getPessoa().getNascimento() != null) {
                        dadosTabela[lin][4] = Formatacao.ajustaDataDMA(pj.getPessoa().getNascimento().toString());
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
                    column.setPreferredWidth(100);
                    break;
                case 2:
                    column.setPreferredWidth(100);
                    break;
                case 3:
                    column.setPreferredWidth(50);
                    break;
                case 4:
                    column.setPreferredWidth(20);
                    break;
            }
        }
    }
}
