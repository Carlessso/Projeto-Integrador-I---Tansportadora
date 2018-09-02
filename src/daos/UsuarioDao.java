/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Pessoa;
import entidades.Usuario;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Ramon
 */
public class UsuarioDao {

    public static Usuario buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Usuario u = (Usuario) sessao.get(Usuario.class, id);
            return u;

        } catch (HibernateException he) {
            he.printStackTrace();

            return null;
        } finally {
            sessao.close();
        }
    }

    public static Usuario validaLogin(String usuario, String senha) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria criterio = sessao.createCriteria(Usuario.class);
            criterio.add(Restrictions.eq("login", usuario));
            criterio.add(Restrictions.eq("senha", senha));
            criterio.add(Restrictions.eq("ativo", true));

            List dados = criterio.list();

            if (dados.isEmpty()) {
                return null;
            } else {
                return (Usuario) dados.get(0);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
            return null;
        } finally {
            sessao.close();
        }
    }

    public static boolean loginUsado(String login) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria criterio = sessao.createCriteria(Usuario.class);
            criterio.add(Restrictions.eq("login", login));

            return !criterio.list().isEmpty();

        } catch (HibernateException he) {
            he.printStackTrace();
            return false;
        } finally {
            sessao.close();
        }
    }

    public static boolean pessoaUsada(Pessoa pessoa) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria criterio = sessao.createCriteria(Usuario.class);
            criterio.add(Restrictions.eq("pessoa", pessoa));

            return !criterio.list().isEmpty();

        } catch (HibernateException he) {
            he.printStackTrace();
            return false;
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
        cabecalho[1] = "Login";
        cabecalho[2] = "Nome Completo";
        cabecalho[3] = "Ativo";

        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;
            // definição dos filtros
            if (filtro.equals("Login")) {
                filtro = "login";
                crit = sessao.createCriteria(Usuario.class);
            } else {
                crit = sessao.createCriteria(Usuario.class);
                crit.createAlias("pessoa", "p");
                filtro = "p.nome";
            }

            crit.add(Restrictions.ilike(filtro, criterio, MatchMode.ANYWHERE));
            dados = crit.list();

            dadosTabela = new Object[dados.size()][4];

            int lin = 0;

            for (Object dado : dados) {
                Usuario u = (Usuario) dado;
                dadosTabela[lin][0] = u.getId();
                dadosTabela[lin][1] = u.getLogin();
                dadosTabela[lin][2] = u.getPessoa().getNome();
                if (u.isAtivo()) {
                    dadosTabela[lin][3] = "Ativado";
                } else {
                    dadosTabela[lin][3] = "Desativado";
                }
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
